package com.sunhao.controller.redis;

import com.sunhao.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

/**
 * 项目名称：redistest
 * 类 名 称：goodsControlle
 * 类 描 述：获取redis中的数据 进行crud操作（全部包含）
 * 创建时间：2019/12/6 4:39 下午
 * 创 建 人：sunhao
 */
@Controller
public class goodsControlle {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("update")
    public String update(HttpServletRequest request,Goods goods){
        List<Goods> list = redisTemplate.opsForList().range("goods_list", 0, -1);
        for (int i=0;i<list.size();i++){
            Goods g = list.get(i);
            if (goods.getId()==g.getId()){
                list.remove(g);
                list.add(goods);
            }
        }
        redisTemplate.delete("goods_list");
        redisTemplate.opsForList().leftPushAll("goods_list",list.toArray());

        return "redirect:list";
    }

    @GetMapping("toupdate")
    public String toupdate(HttpServletRequest request, Integer id) {
        List<Goods> list = redisTemplate.opsForList().range("goods_list", 0, -1);
        Goods g = null;
        for (int i = 0; i < list.size(); i++) {
            Goods goods = list.get(i);
            if (goods.getId() == id) {
                g = goods;
            }
        }
        request.setAttribute("goods", g);
        return "update";
    }


    @RequestMapping("list")
    public String list(HttpServletRequest request,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pagesize) {

//      (page-1)*pagesize+1
//
        List<Goods> list = redisTemplate.opsForList().range("goods_list", (page - 1) * pagesize, (page - 1) * pagesize + pagesize - 1);
        Long size = redisTemplate.opsForList().size("goods_list");
        int totalpage = (int) (size % pagesize > 0 ? size / pagesize + 1 : size / pagesize);
        request.setAttribute("list", list);
        request.setAttribute("page", page);
        request.setAttribute("totalpage", totalpage);

        return "list";
    }

    @RequestMapping("zset")
    public String zset(HttpServletRequest request,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pagesize) {

        // (page-1)*pagesize +pagesize-1
        Set<Goods> list = redisTemplate.opsForZSet().range("goods_zset", (page - 1) * pagesize, (page - 1) * pagesize + pagesize - 1);
        int size = list.size();
//        System.out.println(size+"==========");
//        Long size1 = redisTemplate.opsForZSet().size("goods_zset");
//        System.out.println(size1+"-----------");
        int totalpage = 0;
        totalpage = (int) (size % pagesize > 0 ? size / pagesize + 1 : size / pagesize);

        request.setAttribute("page", page);
        request.setAttribute("totalpage", totalpage);
        request.setAttribute("list", list);

        return "list";
    }

}

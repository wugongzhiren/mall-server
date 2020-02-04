package com.mall.server.controller;

import com.mall.server.model.Goods;
import com.mall.server.model.Response;
import com.mall.server.model.User;
import com.mall.server.repository.GoodsRepository;
import com.mall.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 */
@RestController
public class Goodsmanage {
    @Autowired
    private GoodsRepository goodsRepository;

    /**
     * 注册
     *
     * @return
     */
    @RequestMapping(value = "/api/goods/add", method = RequestMethod.POST)
    public Response add(@RequestParam String name, @RequestParam String type, @RequestParam String img, @RequestParam String description
            , @RequestParam String stockNum, @RequestParam String unitPrice) {
        System.out.println("description:"+description);
        Goods good = goodsRepository.findByGoodsname(name);
        Response response = new Response();
        if (good != null) {
            response.setCode(201);
            response.setMsg("商品已经存在");
            response.setT(good);
        } else {
            good = new Goods();
            good.setGoodsname(name);
            good.setType(type);
            good.setDescription(description);
            good.setImgurl(img);
            good.setStock(stockNum);
            good.setPrice(unitPrice);
            goodsRepository.save(good);
            response.setCode(200);
            response.setMsg("");
            response.setT(good);
        }
        return response;
    }

    @RequestMapping(value = "/api/goods/getAll", method = RequestMethod.GET)
    public Response getAll() {
        List<Goods> goods = goodsRepository.findAll();
        Response response = new Response();
        response.setCode(200);
        response.setMsg("");
        response.setT(goods);
        return response;
    }

    @RequestMapping(value = "/api/goods/getOne", method = RequestMethod.GET)
    public Response getOne(@RequestParam String id) {
        Goods goods = goodsRepository.findById(Long.parseLong(id));
        Response response = new Response();
        if(goods!=null){
            response.setCode(200);
            response.setMsg("");
            response.setT(goods);
        }
        return response;
    }

    @RequestMapping(value = "/api/goods/getByType", method = RequestMethod.GET)
    public Response getGoods(@RequestParam String type) {
        List<Goods> goods;
        if(type.equals("0")){
            goods=goodsRepository.findAll();
        }else{
            goods = goodsRepository.findByType(type);
        }
        Response response = new Response();
        if(goods!=null){
            response.setCode(200);
            response.setMsg("");
            response.setT(goods);
        }
        return response;
    }
    @RequestMapping(value = "/api/goods/getByKeyWord", method = RequestMethod.GET)
    public Response getGoodsByKey(@RequestParam String keyword) {
        List<Goods> goods;
        System.out.println(keyword);
        goods=goodsRepository.findByGoodsnameLike("%"+keyword+"%");
        Response response = new Response();
        if(goods!=null){
            response.setCode(200);
            response.setMsg("");
            response.setT(goods);
        }
        return response;
    }

    @RequestMapping(value = "/api/goods/delete", method = RequestMethod.DELETE)
    public Response getAll(@RequestParam String id) {
        Goods goods = goodsRepository.findById(Long.parseLong(id));
        Response response = new Response();
        if(goods!=null){
            goodsRepository.delete(goods);
            response.setCode(200);
            response.setMsg("");
            response.setT(goods);
        }else{
            response.setCode(201);
            response.setMsg("商品不存在");
            response.setT(null);
        }
        return response;
    }

    @RequestMapping(value = "/api/goods/update", method = RequestMethod.POST)
    public Response updateGoods(@RequestParam String id,@RequestParam String name, @RequestParam String type, @RequestParam String img, @RequestParam String description
            , @RequestParam String stockNum, @RequestParam String unitPrice) {
        Goods goods = goodsRepository.findById(Long.parseLong(id));
        Response response = new Response();
        if(goods!=null){
            goods.setGoodsname(name);
            goods.setType(type);
            goods.setDescription(description);
            goods.setImgurl(img);
            goods.setStock(stockNum);
            goods.setPrice(unitPrice);
            goodsRepository.save(goods);
            response.setCode(200);
            response.setMsg("");
            response.setT(goods);
        }
        return response;
    }
}

package com.mall.server.controller;

import com.mall.server.model.Goods;
import com.mall.server.model.Orders;
import com.mall.server.model.Response;
import com.mall.server.repository.GoodsRepository;
import com.mall.server.repository.OrdersRepository;
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
public class Ordersmanage {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private GoodsRepository goodsRepository;
    /**
     * 注册
     *
     * @return
     */
    @RequestMapping(value = "/api/goods/addOrder", method = RequestMethod.POST)
    public Response add(@RequestParam String goodsid,@RequestParam String userid, @RequestParam String orderName, @RequestParam String orderNum, @RequestParam String orderPrice
            , @RequestParam String salePrice,@RequestParam String status) {
        Orders order = new Orders();
        order.setUserid(userid);
        order.setOrderName(orderName);
        order.setGoodid(goodsid);
        order.setOrderNum(orderNum);
        order.setOrderPrice(orderPrice);
        order.setSalePrice(salePrice);
        order.setOrderSumPrice((Integer.parseInt(orderNum)*Integer.parseInt(orderPrice)-Integer.parseInt(salePrice))+"");
        order.setCreteTime(System.currentTimeMillis()+"");
        order.setStatus(status);
        ordersRepository.save(order);
        //减去库存
       Goods goods= goodsRepository.findById(Long.parseLong(goodsid));
       if(goods!=null){
           goods.setStock((Integer.parseInt(goods.getStock())-Integer.parseInt(orderNum))+"");
           goodsRepository.save(goods);
       }
        Response response = new Response();
        response.setCode(200);
        response.setMsg("保存成功");
        response.setT(order);
        return response;
    }
    /**
     * 注册
     *
     * @return
     */
    @RequestMapping(value = "/api/user/getOrderByState", method = RequestMethod.GET)
    public Response getOrderByState(@RequestParam String userid,@RequestParam String status) {
        List<Orders> orders=ordersRepository.findByUseridAndStatus(userid,status);
        Response response = new Response();
        response.setCode(200);
        response.setMsg("");
        response.setT(orders);
        return response;
    }

    /**
     * 注册
     *
     * @return
     */
    @RequestMapping(value = "/api/user/deleteOrder", method = RequestMethod.GET)
    public Response getOrderByState(@RequestParam String id) {
        Orders order=ordersRepository.findById(Long.parseLong(id));
        if(order!=null){
            ordersRepository.delete(order);
        }
        Response response = new Response();
        response.setCode(200);
        response.setMsg("");
        response.setT(order);
        return response;
    }
}

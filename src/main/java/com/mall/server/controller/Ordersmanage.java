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

    /**
     * 注册
     *
     * @return
     */
    @RequestMapping(value = "/api/goods/addOrder", method = RequestMethod.POST)
    public Response add(@RequestParam String userid, @RequestParam String orderName, @RequestParam String orderNum, @RequestParam String orderPrice
            , @RequestParam String salePrice) {
        Orders orders = new Orders();
        Response response = new Response();
        /*if (good != null) {
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
        }*/
        return response;
    }


}

package com.mall.server.controller;

import com.mall.server.model.Orders;
import com.mall.server.model.Response;
import com.mall.server.model.Ticket;
import com.mall.server.repository.OrdersRepository;
import com.mall.server.repository.TicketsRepository;
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
public class Ticketsmanage {
    @Autowired
    private TicketsRepository ticketsRepository;

    /**
     * 注册
     *
     * @return
     */
    @RequestMapping(value = "/api/goods/addTicket", method = RequestMethod.POST)
    public Response add(@RequestParam String userid, @RequestParam String money) {
        Ticket ticket = new Ticket();
        Response response = new Response();
        ticket.setMoney(money);
        ticket.setUserid(userid);
        ticket.setStatus("有效");
        ticketsRepository.save(ticket);
        response.setCode(200);
        return response;
    }
    /**
     * 注册
     *
     * @return
     */
    @RequestMapping(value = "/api/user/getAllTicket", method = RequestMethod.GET)
    public Response getAllTicket() {
        List<Ticket> tickets = ticketsRepository.findAll();
        Response response = new Response();
        response.setCode(200);
        response.setT(tickets);
        return response;
    }
    /**
     * 注册
     *
     * @return
     */
    @RequestMapping(value = "/api/user/deleteTicket", method = RequestMethod.GET)
    public Response getAllTicket(@RequestParam String id) {

        Ticket ticket = ticketsRepository.findById(Long.parseLong(id));
        if(ticket!=null){
            ticketsRepository.delete(ticket);
        }
        Response response = new Response();
        response.setCode(200);
        response.setT(null);
        return response;
    }
}

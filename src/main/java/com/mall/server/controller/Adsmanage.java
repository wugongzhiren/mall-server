package com.mall.server.controller;

import com.mall.server.model.Ads;
import com.mall.server.model.Response;
import com.mall.server.model.User;
import com.mall.server.repository.AdsRepository;
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
public class Adsmanage {
    @Autowired
    private AdsRepository adsRepository;

    /**
     * 注册
     *
     * @return
     */
    @RequestMapping(value = "/api/ads/getAds", method = RequestMethod.GET)
    public Response getAds() {
        Response response = new Response();
        response.setCode(200);
        response.setMsg("");
        response.setT(adsRepository.findAll());
        return response;
    }

    /**
     * 注册
     *
     * @return
     */
    @RequestMapping(value = "/api/ads/add", method = RequestMethod.POST)
    public Response add(@RequestParam String id, @RequestParam String tips1, @RequestParam String tips2, @RequestParam String tips3, @RequestParam String img1, @RequestParam String img2, @RequestParam String img3) {

        System.out.println(id);
        Ads ads ;
        if (id .equals("")) {
            ads = new Ads();
            ads.setImg1(img1);
            ads.setImg2(img2);
            ads.setImg3(img3);
            ads.setTips1(tips1);
            ads.setTips2(tips2);
            ads.setTips3(tips3);
            adsRepository.save(ads);

        } else {
            ads = adsRepository.findById(Long.parseLong(id));
            ads.setImg1(img1);
            ads.setImg2(img2);
            ads.setImg3(img3);
            ads.setTips1(tips1);
            ads.setTips2(tips2);
            ads.setTips3(tips3);
            adsRepository.save(ads);
        }
        Response response = new Response();
        response.setCode(200);
        response.setMsg("");
        response.setT(ads);

        return response;
    }

}

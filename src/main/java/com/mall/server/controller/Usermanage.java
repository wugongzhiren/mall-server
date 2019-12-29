package com.mall.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 */
@RestController
public class Usermanage {

    /**
     * 根据商品条码查询对应商品的信息，主要是查库存,收款时扫码调用
     *
     * @return
     */
    @RequestMapping(value = "/getInstoreInfo", method = RequestMethod.GET)
    public String getInstoreInfo() {
        return "222";
    }


}

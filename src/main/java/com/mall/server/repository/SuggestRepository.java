package com.mall.server.repository;

import com.mall.server.model.Ads;
import com.mall.server.model.Suggest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Administrator on 2017/4/23.
 */
public interface SuggestRepository extends JpaRepository<Suggest,Long> {


    /*Ads findById(@Param("id") long id);*/
    /*@Query(value = "update goods u set u.goods_count=u.goods_count-?1 where u.zxing_code=?2 ",nativeQuery = true)
    void updateGoodsCount(@Param("count") int count,@Param("zxing_code") String zxing_code);*/
}

package com.mall.server.repository;

import com.mall.server.model.Collects;
import com.mall.server.model.Suggest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/4/23.
 */
public interface CollectRepository extends JpaRepository<Collects,Long> {


    List<Collects> findByUserid(@Param("userid") String userid);
    Collects findByUseridAndGoodid(@Param("userid") String userid,@Param("goodid") String goodid);
    /*Ads findById(@Param("id") long id);*/
    /*@Query(value = "update goods u set u.goods_count=u.goods_count-?1 where u.zxing_code=?2 ",nativeQuery = true)
    void updateGoodsCount(@Param("count") int count,@Param("zxing_code") String zxing_code);*/
}

package com.elastic.example.entity;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description
 * @date created on 2019/8/28
 */
@Repository
public interface CommodityRepository extends ElasticsearchRepository<Commodity, String> {

}
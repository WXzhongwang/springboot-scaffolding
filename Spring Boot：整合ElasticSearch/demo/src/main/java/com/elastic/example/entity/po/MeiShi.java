package com.elastic.example.entity.po;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description
 * @date created on 2019/9/17
 */
@Data
@ToString
@AllArgsConstructor
@Setter
@Getter
@Builder
public class MeiShi {

    private Integer id;

    private String name;

    private String address;

    private BigDecimal avg_price;
}

package com.elastic.example.entity.po;

import lombok.*;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description Hotel
 * @date created on 2019/9/17
 */
@Data
@ToString
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Hotel {

    private Integer id;

    private String name;

    private String address;

    private String type;
}

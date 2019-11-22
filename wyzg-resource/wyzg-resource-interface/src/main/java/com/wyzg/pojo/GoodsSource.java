package com.wyzg.pojo;

import lombok.Data;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_goods_resource")
public class GoodsSource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String startPlace;

    private String endPlace;

    private String goodsType;

    private Double weight;

    private String publishName;

    private String phone;

    private String comment;

    private Date createTime;

}

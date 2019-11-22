package com.wyzg.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "tb_car_resource")
public class CarSource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String startPlace;

    private String endPlace;

    //车辆载重
    private Double weight;

    //路线类型
    private String lineType;

    //车辆数
    private Integer count;

    //车源是否被接单
    private Integer status;

    //发布人姓名
    private String publishName;

    //发布人联系电话
    private String phone;

    //备注
    private String comment;

    //订单创建时间
    private Date createTime;
}

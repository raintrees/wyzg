package com.wyzg.user.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author raintrees
 * @date 2019/11/19 16:33
 */
@Data
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String phone;
    private String name;
    private String password;
    @JsonIgnore
    private Integer isCompany;
    @JsonIgnore
    private Integer permission;
    @JsonIgnore
    private Integer forbidden;
    @JsonIgnore
    private Integer type;
    @JsonIgnore
    private String idCard;

    @Transient
    private String userCompany;

    @Transient
    private String uPermission;

    @Transient
    private String uForbidden;

    @Transient
    private String uType;


}

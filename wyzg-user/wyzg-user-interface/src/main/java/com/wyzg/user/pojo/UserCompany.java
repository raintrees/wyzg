package com.wyzg.user.pojo;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name="tb_user_company")
public class UserCompany {

  private Integer id;
  private Integer userId;
  private Integer companyId;

}

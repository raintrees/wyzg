package com.wyzg.user.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="tb_company_detail")
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String companyName;
  private String bossName;
  private String tel;
  private Integer province;
  private Integer city;
  private Integer area;
  private String addressDetail;
  private String business;
  //营业执照
  private String license;
  private Integer userId;
  private String bossIdCard;

}

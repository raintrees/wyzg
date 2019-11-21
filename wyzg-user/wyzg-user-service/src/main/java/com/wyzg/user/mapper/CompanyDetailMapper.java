package com.wyzg.user.mapper;

import com.wyzg.user.pojo.CompanyDetail;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author raintrees
 * @date 2019/11/20 16:27
 */
public interface CompanyDetailMapper extends Mapper<CompanyDetail> {

    @Select("select cd.* from tb_company_detail cd where cd.company_name like #{key1} or tel like #{key2} order by id ${orderByClause}")
    List<CompanyDetail> selectCompanyUser(String key1,String key2,String orderByClause);


}

package com.wyzg.user.mapper;

import com.wyzg.user.pojo.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author raintrees
 * @date 2019/11/20 15:33
 */
public interface UserMapper extends Mapper<User> {

    @Select("select u.id,u.phone,u.name,u.password,u.id_card,c.user_company,p.u_permission,t.u_type,f.u_forbidden from tb_user u left join tb_is_company c on u.is_company=c.id left join tb_permission p on u.permission=p.id left join tb_type t on u.type=t.id left join tb_forbidden f on u.forbidden=f.id where phone like #{key1} or name like #{key2} order by id ${orderByClause}")
    List<User> seleceUserPage(String key1, String key2,String orderByClause);

}

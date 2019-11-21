package com.wyzg.user.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wyzg.common.VO.PageResult;
import com.wyzg.user.mapper.CompanyDetailMapper;
import com.wyzg.user.mapper.UserCompanyMapper;
import com.wyzg.user.mapper.UserMapper;
import com.wyzg.user.pojo.CompanyDetail;
import com.wyzg.user.pojo.User;
import com.wyzg.user.pojo.UserCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author raintrees
 * @date 2019/11/19 16:59
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CompanyDetailMapper companyDetailMapper;

    @Autowired
    private UserCompanyMapper userCompanyMapper;



    /**
     * 系统用户管理--->增加个人用户
     * @param user
     * @return
     */
    public User saveNewUser(User user) {
        userMapper.insertSelective(user);
        UserCompany userCompany=new UserCompany();
        userCompany.setUserId(user.getId());
        userCompanyMapper.insertSelective(userCompany);
        return user;
    }

    /**
     * 系统用户管理--->增加企业用户
     * @param user
     * @param companyDetail
     */
    public void saveCompanyUser(User user, CompanyDetail companyDetail) {
        userMapper.insertSelective(user);
        companyDetail.setUserId(user.getId());
        companyDetailMapper.insertSelective(companyDetail);
        UserCompany userCompany=new UserCompany();
        userCompany.setUserId(user.getId());
        userCompany.setCompanyId(companyDetail.getId());
    }

    /**
     * 系统用户管理--->修改用户内容
     * @param user
     * @param companyDetail
     * @param isCompany
     */
    public void updateUser(User user, CompanyDetail companyDetail,Integer isCompany) {
        userMapper.updateByPrimaryKeySelective(user);
        if(isCompany==1){
            companyDetailMapper.updateByPrimaryKeySelective(companyDetail);
        }
    }

    /**
     * 系统用户管理--->删除用户
     * @param userId
     */
    public void deleteUser(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        userMapper.deleteByPrimaryKey(userId);
        UserCompany userCompany=new UserCompany();
        userCompany.setUserId(user.getId());
        userCompanyMapper.delete(userCompany);
        Integer isCompany=user.getIsCompany();
        if(isCompany!=null){
            companyDetailMapper.deleteByPrimaryKey(isCompany);
        }
    }

    /**
     * 屏蔽/封号
     * @param userId
     * @return
     */
    public void forbiddenUser(Integer userId) {

        User user=new User();
        user.setId(userId);
        user.setForbidden(2);
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 解封用户
     * @param userId
     */
    public void openUser(Integer userId) {
        User user=new User();
        user.setId(userId);
        user.setForbidden(1);
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 个人用户分页
     * @param page
     * @param rows
     * @param desc
     * @param key
     * @return
     */
    public PageResult<User> queryUserPage(Integer page, Integer rows, Boolean desc, String key) {
        PageHelper.startPage(page, rows);
        //排序
        String orderByClause =desc ? "DESC" : "ASC";
        Page<User> users = (Page<User>)userMapper.seleceUserPage("%"+key+"%","%"+key+"%",orderByClause);

        return new PageResult<User>(users.getTotal(),(long) users.getPageNum(),users.getResult());

    }

    /**
     * 企业用户分页
     * @param page
     * @param rows
     * @param desc
     * @param key
     * @return
     */
    public PageResult<CompanyDetail> queryCompanyUserPage(Integer page, Integer rows,Boolean desc, String key) {
        PageHelper.startPage(page, rows);
        //排序
        String orderByClause =desc ? "DESC" : "ASC";
        Page<CompanyDetail> result=(Page<CompanyDetail>)companyDetailMapper.selectCompanyUser("%"+key+"%","%"+key+"%",orderByClause);
        return new PageResult<CompanyDetail>(result.getTotal(),(long)result.getPageNum(),result.getResult());
    }
}

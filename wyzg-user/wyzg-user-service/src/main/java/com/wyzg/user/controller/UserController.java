package com.wyzg.user.controller;

import com.wyzg.common.VO.PageResult;
import com.wyzg.common.enums.ExceptionEnums;
import com.wyzg.common.exceptions.WyzgException;
import com.wyzg.user.pojo.CompanyDetail;
import com.wyzg.user.pojo.User;
import com.wyzg.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author raintrees
 * @date 2019/11/19 16:38
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 系统用户管理--->增加个人用户
     * @param user
     * @param isCompany
     * @return
     */
    @PostMapping(value = "/saveUser/{isCompany}")
    public ResponseEntity<User> saveNewUser(User user,@PathVariable("isCompany")Integer isCompany){
        if(isCompany!=0){
            throw new WyzgException(ExceptionEnums.ILLEGAL_PARAMETER);
        }
        User newUser=userService.saveNewUser(user);
        if(newUser == null){
            throw new WyzgException(ExceptionEnums.FAIL_TO_SAVE);
        }
        return ResponseEntity.ok(newUser);
    }

    /**
     * 系统用户管理--->增加企业用户
     * @param user
     * @param companyDetail
     * @param isCompany
     * @return
     */
    @PostMapping(value = "/saveCompanyUser/{isCompany}")
    public ResponseEntity<Void> saveCompanyUser(User user, CompanyDetail companyDetail, @PathVariable("isCompany")Integer isCompany){
        if(isCompany!=1){
            throw new WyzgException(ExceptionEnums.ILLEGAL_PARAMETER);
        }
        userService.saveCompanyUser(user,companyDetail);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 系统用户管理--->修改用户内容
     * @param user
     * @param companyDetail
     * @param isCompany
     * @return
     */
    @PutMapping(value = "/updateUser/{isCompany}")
    public ResponseEntity<String> updateUser(User user,CompanyDetail companyDetail,@PathVariable("isCompany")Integer isCompany){
        userService.updateUser(user,companyDetail,isCompany);
        return ResponseEntity.ok("删除成功");
    }

    /**
     * 系统用户管理--->删除用户
     * @param userId
     * @return
     */
    @DeleteMapping(value = "/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestParam("userId")Integer userId){
        System.out.println(userId);
        userService.deleteUser(userId);
        return ResponseEntity.ok("删除成功");
    }

    /**
     * 个人用户查询
     * @param page
     * @param rows
     * @param desc
     * @param key
     * @return
     */
    @GetMapping(value = "/userPage")
    public ResponseEntity<PageResult<User>> queryUserPage(
            @RequestParam(value = "page",defaultValue = "1")Integer page,
            @RequestParam(value = "rows",defaultValue = "5")Integer rows,
            @RequestParam(value = "desc",defaultValue = "false")Boolean desc,
            @RequestParam(value = "key",required = false,defaultValue = "")String key){

        PageResult<User> pageResult=userService.queryUserPage(page,rows,desc,key);
        return ResponseEntity.ok(pageResult);
    }


    /**
     * 企业用户查询
     * @param page
     * @param rows
     * @param desc
     * @param key
     * @return
     */
    @GetMapping(value = "/companyUserPage")
    public ResponseEntity<PageResult<CompanyDetail>> queryCompanyUserPage(
            @RequestParam(value = "page",defaultValue = "1")Integer page,
            @RequestParam(value = "rows",defaultValue = "5")Integer rows,
            @RequestParam(value = "desc",defaultValue = "false")Boolean desc,
            @RequestParam(value = "key",required = false,defaultValue = "")String key){

        PageResult<CompanyDetail> result=userService.queryCompanyUserPage(page,rows,desc,key);
        return ResponseEntity.ok(result);

    }


    /*@GetMapping(value = "/queryUser")
    public ResponseEntity<User> queryUser(@RequestParam("userId")Integer userId){

    }*/

    /**
     * 屏蔽/封号
     * @param userId
     * @return
     */
    @PutMapping(value = "/forbidden")
    public ResponseEntity<String> forbiddenUser(@RequestParam("userId")Integer userId){
        userService.forbiddenUser(userId);
        return ResponseEntity.ok("操作成功");
    }

    /**
     * 解封用户
     * @param userId
     * @return
     */
    @PutMapping(value = "/open")
    public ResponseEntity<String> openUser(@RequestParam("userId")Integer userId){
        userService.openUser(userId);
        return ResponseEntity.ok("操作成功");
    }

}

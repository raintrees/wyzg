package com.wyzg.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author raintrees
 * @date 2019/10/24 16:08
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum  ExceptionEnums {

    USER_NOT_FOUND(10020,"用户不存在"),
    INVALID_USERNAME_PASSWORD(10030,"用户名或密码不正确"),
    FAIL_TO_SAVE(10010,"添加新用户失败"),
    ILLEGAL_PARAMETER(500,"非法参数异常"),
    NO_CARSOURCE_COULD_USE(10040,"没有车源可用"),
    NO_GOODS_SOURCE_COULD_USE(10050,"没有货源可用");
    private Integer code;
    private String message;

}

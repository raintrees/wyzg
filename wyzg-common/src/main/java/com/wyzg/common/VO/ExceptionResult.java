package com.wyzg.common.VO;

import com.wyzg.common.enums.ExceptionEnums;
import lombok.Data;

/**
 * @author raintrees
 * @date 2019/10/24 16:13
 */

@Data
public class ExceptionResult {
    private Integer code;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnums exceptionEnums) {
        this.code = exceptionEnums.getCode();
        this.message = exceptionEnums.getMessage();
        this.timestamp =System.currentTimeMillis();
    }
}

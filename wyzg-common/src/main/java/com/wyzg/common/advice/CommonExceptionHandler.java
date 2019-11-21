package com.wyzg.common.advice;

import com.wyzg.common.VO.ExceptionResult;
import com.wyzg.common.enums.ExceptionEnums;
import com.wyzg.common.exceptions.WyzgException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author raintrees
 * @date 2019/10/24 14:58
 */

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResult> handleException(WyzgException e){
        ExceptionEnums exceptionEnums = e.getExceptionEnums();
        ExceptionResult result = new ExceptionResult(exceptionEnums);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}

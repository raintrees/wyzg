package com.wyzg.common.exceptions;

import com.wyzg.common.enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author raintrees
 * @date 2019/10/24 16:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WyzgException extends RuntimeException {

    private ExceptionEnums exceptionEnums;
}

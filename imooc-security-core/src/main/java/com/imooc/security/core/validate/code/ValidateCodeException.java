package com.imooc.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**针对验证码异常的处理
 * LN
 * 2019/10/10 0010 18:10
 */

public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public ValidateCodeException(String msg) {
        super(msg);
    }
}

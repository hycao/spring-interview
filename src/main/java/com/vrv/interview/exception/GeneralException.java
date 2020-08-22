package com.vrv.interview.exception;

/**
 * 一般性异常
 * 不需要单独自定义的 Exception 可以使用该异常
 *
 * @author hycao
 */
public class GeneralException extends RuntimeException {

    public GeneralException() {
        super();
    }

    /**
     * @param message 是的错误信息
     */
    public GeneralException(String message) {
        super(message);
    }
}

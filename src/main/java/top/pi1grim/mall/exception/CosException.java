package top.pi1grim.mall.exception;

import top.pi1grim.mall.type.ErrorCode;

public class CosException extends BaseException{
    public CosException(ErrorCode errorCode, Object data) {
        super(errorCode, data);
    }
}

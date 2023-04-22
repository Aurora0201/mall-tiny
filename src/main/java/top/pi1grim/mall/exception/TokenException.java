package top.pi1grim.mall.exception;

import top.pi1grim.mall.type.ErrorCode;

public class TokenException extends BaseException{
    public TokenException(ErrorCode errorCode, Object data) {
        super(errorCode, data);
    }
}

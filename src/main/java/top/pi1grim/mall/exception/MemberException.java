package top.pi1grim.mall.exception;

import top.pi1grim.mall.type.ErrorCode;

public class MemberException extends BaseException{
    public MemberException(ErrorCode errorCode, Object data) {
        super(errorCode, data);
    }
}

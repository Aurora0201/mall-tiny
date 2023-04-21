package top.pi1grim.mall.exception;

import lombok.Getter;
import lombok.ToString;
import top.pi1grim.mall.type.ErrorCode;

@Getter
@ToString
public class BaseException extends RuntimeException{
    private final ErrorCode errorCode;
    private final Object data;

    public BaseException(ErrorCode errorCode, Object data) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.data = data;
    }
}

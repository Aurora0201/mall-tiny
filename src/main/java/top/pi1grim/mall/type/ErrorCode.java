package top.pi1grim.mall.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    GENERATE_KEY_FAIL(1000, HttpStatus.OK, "生成临时key失败"),
    ILLEGAL_REQUEST(1005, HttpStatus.OK, "请求非法，存在空字段"),
    USERNAME_EXIST(1010, HttpStatus.OK, "用户名已存在"),
    MEMBER_NOT_AVAILABLE(1015, HttpStatus.OK, "用户不可用"),
    USERNAME_PASSWORD_MISMATCH(1020, HttpStatus.OK, "账号密码不匹配"),
    MEMBER_NOT_EXIST(1025, HttpStatus.OK, "用户不存在，请确认用户名是否输入正确")

    ;
    private final int code;
    private final HttpStatus status;
    private final String message;
}

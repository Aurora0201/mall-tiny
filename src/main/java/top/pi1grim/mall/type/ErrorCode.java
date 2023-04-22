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
    MEMBER_NOT_EXIST(1025, HttpStatus.OK, "用户不存在，请确认用户名是否输入正确"),
    NO_TOKEN_CARRIED(1030, HttpStatus.OK, "访问敏感资源未携带TOKEN"),
    TOKEN_EXPIRATION(1035, HttpStatus.OK, "TOKEN已过期，请重新登录"),
    OLD_PASSWORD_MISMATCH(1040, HttpStatus.OK, "旧密码不一致"),

    ;
    private final int code;
    private final HttpStatus status;
    private final String message;
}

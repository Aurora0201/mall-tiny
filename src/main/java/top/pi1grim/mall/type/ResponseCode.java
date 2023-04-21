package top.pi1grim.mall.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode implements GenericEnum{
    GENERATE_KEY_SUCCESS(2000, "生成临时key成功"),
    REGISTER_SUCCESS(2005, "用户注册成功"),
    LOGIN_SUCCESS(2010, "用户登录成功"),

    ;
    private final int code;
    private final String message;
}

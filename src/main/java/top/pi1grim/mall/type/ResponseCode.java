package top.pi1grim.mall.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode implements GenericEnum{
    GENERATE_KEY_SUCCESS(2000, "生成临时key成功");


    private final int code;
    private final String message;
}

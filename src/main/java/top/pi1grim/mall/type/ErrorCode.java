package top.pi1grim.mall.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    GENERATE_KEY_FAIL(1000, HttpStatus.OK, "生成临时key失败");

    private final int code;
    private final HttpStatus status;
    private final String message;
}

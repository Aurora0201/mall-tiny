package top.pi1grim.mall.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterDTO {
    private String username;
    private String phone;
    private String password;
    private Byte gender;
}

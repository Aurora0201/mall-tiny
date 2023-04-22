package top.pi1grim.mall.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PasswordDTO {
    private String oldPassword;
    private String newPassword;
}

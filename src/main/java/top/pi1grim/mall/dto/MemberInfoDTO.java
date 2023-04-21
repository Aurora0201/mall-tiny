package top.pi1grim.mall.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MemberInfoDTO {
    private String nickname;
    private String avatar;
    private String gender;
    private LocalDate birthday;
    private String city;
    private String job;
    private String signature;
}

package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 会员登录记录
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Getter
@Setter
@TableName("ums_member_login_log")
public class UmsMemberLoginLog {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long memberId;

    private LocalDateTime createTime;

    private String ip;

    private String city;

    /**
     * 登录类型：0->PC；1->android;2->ios;3->小程序
     */
    private Integer loginType;

    private String province;
}

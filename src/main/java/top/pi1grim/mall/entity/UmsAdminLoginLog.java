package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 后台用户登录日志表
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Getter
@Setter
@TableName("ums_admin_login_log")
public class UmsAdminLoginLog {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long adminId;

    private LocalDateTime createTime;

    private String ip;

    private String address;

    /**
     * 浏览器登录类型
     */
    private String userAgent;
}

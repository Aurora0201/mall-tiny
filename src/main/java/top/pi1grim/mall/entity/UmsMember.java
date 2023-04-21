package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("ums_member")
public class UmsMember {

    /**
     * 用户id;主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名;登录时用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称;显示昵称
     */
    private String nickname;

    /**
     * 手机号;手机号码
     */
    private String phone;

    /**
     * 头像;头像，存储文件名
     */
    private String avatar;

    /**
     * 性别;0->女  1->男
     */
    private Byte gender;

    /**
     * 生日;生日
     */
    private LocalDate birthday;

    /**
     * 所在城市;所在城市
     */
    private String city;

    /**
     * 职业;职业
     */
    private String job;

    /**
     * 个性签名;个性签名，个人描述，200字以内
     */
    private String signature;

    /**
     * 账户状态;0->停用 1->启用
     */
    private Byte status;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;
}

package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 限时购场次表
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Getter
@Setter
@TableName("sms_flash_promotion_session")
public class SmsFlashPromotionSession {

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 场次名称
     */
    private String name;

    /**
     * 每日开始时间
     */
    private LocalTime startTime;

    /**
     * 每日结束时间
     */
    private LocalTime endTime;

    /**
     * 启用状态：0->不启用；1->启用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}

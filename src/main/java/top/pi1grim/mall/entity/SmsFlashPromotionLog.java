package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 限时购通知记录
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Getter
@Setter
@TableName("sms_flash_promotion_log")
public class SmsFlashPromotionLog {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer memberId;

    private Long productId;

    private String memberPhone;

    private String productName;

    /**
     * 会员订阅时间
     */
    private LocalDateTime subscribeTime;

    private LocalDateTime sendTime;
}

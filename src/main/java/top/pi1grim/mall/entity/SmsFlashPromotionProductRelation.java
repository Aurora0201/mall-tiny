package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 商品限时购与商品关系表
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Getter
@Setter
@TableName("sms_flash_promotion_product_relation")
public class SmsFlashPromotionProductRelation {

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long flashPromotionId;

    /**
     * 编号
     */
    private Long flashPromotionSessionId;

    private Long productId;

    /**
     * 限时购价格
     */
    private BigDecimal flashPromotionPrice;

    /**
     * 限时购数量
     */
    private Integer flashPromotionCount;

    /**
     * 每人限购数量
     */
    private Integer flashPromotionLimit;

    /**
     * 排序
     */
    private Integer sort;
}

package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 优惠券和产品的关系表
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Getter
@Setter
@TableName("sms_coupon_product_relation")
public class SmsCouponProductRelation {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long couponId;

    private Long productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品编码
     */
    private String productSn;
}

package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 产品满减表(只针对同商品)
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Getter
@Setter
@TableName("pms_product_full_reduction")
public class PmsProductFullReduction {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long productId;

    private BigDecimal fullPrice;

    private BigDecimal reducePrice;
}

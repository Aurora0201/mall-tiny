package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 产品属性分类表
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Getter
@Setter
@TableName("pms_product_attribute_category")
public class PmsProductAttributeCategory {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    /**
     * 属性数量
     */
    private Integer attributeCount;

    /**
     * 参数数量
     */
    private Integer paramCount;
}

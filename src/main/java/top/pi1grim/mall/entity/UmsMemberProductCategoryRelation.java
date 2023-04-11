package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 会员与产品分类关系表（用户喜欢的分类）
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Getter
@Setter
@TableName("ums_member_product_category_relation")
public class UmsMemberProductCategoryRelation {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long memberId;

    private Long productCategoryId;
}

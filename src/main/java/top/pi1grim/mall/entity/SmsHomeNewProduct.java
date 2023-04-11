package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 新鲜好物表
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Getter
@Setter
@TableName("sms_home_new_product")
public class SmsHomeNewProduct {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long productId;

    private String productName;

    private Integer recommendStatus;

    private Integer sort;
}

package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 订单设置表
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Getter
@Setter
@TableName("oms_order_setting")
public class OmsOrderSetting {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 秒杀订单超时关闭时间(分)
     */
    private Integer flashOrderOvertime;

    /**
     * 正常订单超时时间(分)
     */
    private Integer normalOrderOvertime;

    /**
     * 发货后自动确认收货时间（天）
     */
    private Integer confirmOvertime;

    /**
     * 自动完成交易时间，不能申请售后（天）
     */
    private Integer finishOvertime;

    /**
     * 订单完成后自动好评时间（天）
     */
    private Integer commentOvertime;
}

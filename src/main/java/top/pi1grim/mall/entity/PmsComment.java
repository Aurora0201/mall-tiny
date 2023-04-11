package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 商品评价表
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Getter
@Setter
@TableName("pms_comment")
public class PmsComment {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long productId;

    private String memberNickName;

    private String productName;

    /**
     * 评价星数：0->5
     */
    private Integer star;

    /**
     * 评价的ip
     */
    private String memberIp;

    private LocalDateTime createTime;

    private Integer showStatus;

    /**
     * 购买时的商品属性
     */
    private String productAttribute;

    private Integer collectCouont;

    private Integer readCount;

    private String content;

    /**
     * 上传图片地址，以逗号隔开
     */
    private String pics;

    /**
     * 评论用户头像
     */
    private String memberIcon;

    private Integer replayCount;
}

package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 成长值变化历史记录表
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Getter
@Setter
@TableName("ums_growth_change_history")
public class UmsGrowthChangeHistory {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long memberId;

    private LocalDateTime createTime;

    /**
     * 改变类型：0->增加；1->减少
     */
    private Integer changeType;

    /**
     * 积分改变数量
     */
    private Integer changeCount;

    /**
     * 操作人员
     */
    private String operateMan;

    /**
     * 操作备注
     */
    private String operateNote;

    /**
     * 积分来源：0->购物；1->管理员修改
     */
    private Integer sourceType;
}

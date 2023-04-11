package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户和标签关系表
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Getter
@Setter
@TableName("ums_member_member_tag_relation")
public class UmsMemberMemberTagRelation {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long memberId;

    private Long tagId;
}

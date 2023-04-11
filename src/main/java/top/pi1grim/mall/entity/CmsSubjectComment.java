package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 专题评论表
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Getter
@Setter
@TableName("cms_subject_comment")
public class CmsSubjectComment {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long subjectId;

    private String memberNickName;

    private String memberIcon;

    private String content;

    private LocalDateTime createTime;

    private Integer showStatus;
}

package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 专题表
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Getter
@Setter
@TableName("cms_subject")
public class CmsSubject {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long categoryId;

    private String title;

    /**
     * 专题主图
     */
    private String pic;

    /**
     * 关联产品数量
     */
    private Integer productCount;

    private Integer recommendStatus;

    private LocalDateTime createTime;

    private Integer collectCount;

    private Integer readCount;

    private Integer commentCount;

    /**
     * 画册图片用逗号分割
     */
    private String albumPics;

    private String description;

    /**
     * 显示状态：0->不显示；1->显示
     */
    private Integer showStatus;

    private String content;

    /**
     * 转发数
     */
    private Integer forwardCount;

    /**
     * 专题分类名称
     */
    private String categoryName;
}

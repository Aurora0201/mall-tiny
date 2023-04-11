package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 优选专区
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Getter
@Setter
@TableName("cms_prefrence_area")
public class CmsPrefrenceArea {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private String subTitle;

    /**
     * 展示图片
     */
    private byte[] pic;

    private Integer sort;

    private Integer showStatus;
}

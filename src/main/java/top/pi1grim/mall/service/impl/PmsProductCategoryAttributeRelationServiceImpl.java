package top.pi1grim.mall.service.impl;

import top.pi1grim.mall.entity.PmsProductCategoryAttributeRelation;
import top.pi1grim.mall.mapper.PmsProductCategoryAttributeRelationMapper;
import top.pi1grim.mall.service.PmsProductCategoryAttributeRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类） 服务实现类
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Service
public class PmsProductCategoryAttributeRelationServiceImpl extends ServiceImpl<PmsProductCategoryAttributeRelationMapper, PmsProductCategoryAttributeRelation> implements PmsProductCategoryAttributeRelationService {

}

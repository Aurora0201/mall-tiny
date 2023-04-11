package top.pi1grim.mall.service.impl;

import top.pi1grim.mall.entity.UmsAdminPermissionRelation;
import top.pi1grim.mall.mapper.UmsAdminPermissionRelationMapper;
import top.pi1grim.mall.service.UmsAdminPermissionRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) 服务实现类
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-04-11
 */
@Service
public class UmsAdminPermissionRelationServiceImpl extends ServiceImpl<UmsAdminPermissionRelationMapper, UmsAdminPermissionRelation> implements UmsAdminPermissionRelationService {

}

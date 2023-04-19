package top.pi1grim.mall.service;

import com.tencent.cloud.Response;
import top.pi1grim.mall.type.KeyType;

public interface CosService {
    Response genTemporaryKey(KeyType keyType);
}

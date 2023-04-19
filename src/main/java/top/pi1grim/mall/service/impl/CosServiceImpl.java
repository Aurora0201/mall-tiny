package top.pi1grim.mall.service.impl;

import com.tencent.cloud.CosStsClient;
import com.tencent.cloud.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.pi1grim.mall.exception.CosException;
import top.pi1grim.mall.service.CosService;
import top.pi1grim.mall.type.ErrorCode;
import top.pi1grim.mall.type.KeyType;

import java.util.SimpleTimeZone;
import java.util.TreeMap;
@Service
@Slf4j
public class CosServiceImpl implements CosService {

    @Value("${cos.secret.id}")
    private String secretId;

    @Value("${cos.secret.key}")
    private String secretKey;

    @Override
    @Cacheable(value = "temporaryKey", key = "#type")
    public Response genTemporaryKey(KeyType type) {
        Response response;
        try {
            TreeMap<String, Object> config = new TreeMap<>();

            config.put("secretId", secretId);
            config.put("secretKey", secretKey);

            config.put("durationSeconds", 1800);

            // 换成您的 bucket
            config.put("bucket", "tiny-mall-1317045976");
            // 换成 bucket 所在地区
            config.put("region", "ap-nanjing");
            config.put("allowPrefixes", new String[]{
                    "*"
            });

            String[] allowActions;
            switch (type){
                case PUT -> allowActions = new String[]{"name/cos:PutObject"};
                case POST -> allowActions = new String[]{"name/cos:PostObject"};
                case GET -> allowActions = new String[]{"name/cos:GetObject"};
                case MULTIPART -> allowActions = new String[]{
                        "name/cos:InitiateMultipartUpload",
                        "name/cos:ListMultipartUploads",
                        "name/cos:ListParts",
                        "name/cos:UploadPart",
                        "name/cos:CompleteMultipartUpload",
                        "name/cos:AbortMultipartUpload"
                };
                default -> allowActions = new String[]{};
            }

            config.put("allowActions", allowActions);
            response = CosStsClient.getCredential(config);
        } catch (Exception e) {
            log.error("get credential error!", e);
            throw new CosException(ErrorCode.GENERATE_KEY_FAIL, e);
        }
        log.info("生成了临时key : " + type);
        return response;
    }
}

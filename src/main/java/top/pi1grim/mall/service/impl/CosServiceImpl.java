package top.pi1grim.mall.service.impl;

import com.tencent.cloud.CosStsClient;
import com.tencent.cloud.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.pi1grim.mall.exception.CosException;
import top.pi1grim.mall.service.CosService;
import top.pi1grim.mall.type.ErrorCode;

import java.util.TreeMap;
@Service
@Slf4j
public class CosServiceImpl implements CosService {

    @Value("${cos.secret.id}")
    private String secretId;

    @Value("${cos.secret.key}")
    private String secretKey;

    @Override
    public Response genTemporaryKey() {
        Response response;
        try {
            TreeMap<String, Object> config = new TreeMap<>();

            config.put("secretId", secretId);
            config.put("secretKey", secretKey);

            config.put("durationSeconds", 3600);

            // 换成您的 bucket
            config.put("bucket", "tiny-mall-1317045976");
            // 换成 bucket 所在地区
            config.put("region", "ap-nanjing");
            config.put("allowPrefixes", new String[]{
                    "*"
            });

            String[] allowActions = new String[] {
                    // 简单上传
                    "name/cos:PutObject",
                    // 表单上传、小程序上传
                    "name/cos:PostObject",
                    // 分块上传
                    "name/cos:InitiateMultipartUpload",
                    "name/cos:ListMultipartUploads",
                    "name/cos:ListParts",
                    "name/cos:UploadPart",
                    "name/cos:CompleteMultipartUpload"
            };
            config.put("allowActions", allowActions);
            response = CosStsClient.getCredential(config);



        } catch (Exception e) {
            log.error("get credential error!", e);
            throw new CosException(ErrorCode.GENERATE_KEY_FAIL, e);
        }
        log.info("生成了临时key");
        return response;
    }
}

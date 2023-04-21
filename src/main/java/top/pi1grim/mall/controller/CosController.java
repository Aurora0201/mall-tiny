package top.pi1grim.mall.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.pi1grim.mall.common.response.Response;
import top.pi1grim.mall.service.CosService;
import top.pi1grim.mall.type.KeyType;
import top.pi1grim.mall.type.ResponseCode;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/cos")
@Tag(name = "COS业务API，负责生成临时key等多种职责")
public class CosController {

    @Resource
    private CosService cosService;

    @GetMapping("/put-key")
    @Operation(summary = "生成PUT Key", description = "使用GET请求，返回具有简单上传功能的临时Key")
    public Response genPutKey() {
        com.tencent.cloud.Response response = cosService.genTemporaryKey(KeyType.PUT);
        return Response.success(ResponseCode.GENERATE_KEY_SUCCESS, response);
    }

    @GetMapping("/post-key")
    @Operation(summary = "生成POST Key", description = "使用GET请求，返回具有表单内容上传功能的临时Key")
    public Response genPostKey() {
        com.tencent.cloud.Response response = cosService.genTemporaryKey(KeyType.POST);
        return Response.success(ResponseCode.GENERATE_KEY_SUCCESS, response);
    }

    @GetMapping("/get-key")
    @Operation(summary = "生成GET Key", description = "使用GET请求，返回能访问COS中存储对象的临时Key")
    public Response genGetKey() {
        com.tencent.cloud.Response response = cosService.genTemporaryKey(KeyType.GET);
        return Response.success(ResponseCode.GENERATE_KEY_SUCCESS, response);
    }

    @GetMapping("/multipart-key")
    @Operation(summary = "生成Multipart Key", description = "使用GET请求，返回具有分块上传对象功能的临时Key")
    public Response genMultipartKey() {
        com.tencent.cloud.Response response = cosService.genTemporaryKey(KeyType.MULTIPART);
        return Response.success(ResponseCode.GENERATE_KEY_SUCCESS, response);
    }
}

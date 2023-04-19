package top.pi1grim.mall.controller;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.pi1grim.mall.response.Response;
import top.pi1grim.mall.service.CosService;
import top.pi1grim.mall.type.KeyType;
import top.pi1grim.mall.type.ResponseCode;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/cos")
public class CosController {

    @Resource
    private CosService cosService;

    @GetMapping("/put-key")
    public Response genPutKey() {
        com.tencent.cloud.Response response = cosService.genTemporaryKey(KeyType.PUT);
        return Response.success(ResponseCode.GENERATE_KEY_SUCCESS, response);
    }

    @GetMapping("/post-key")
    public Response genPostKey() {
        com.tencent.cloud.Response response = cosService.genTemporaryKey(KeyType.POST);
        return Response.success(ResponseCode.GENERATE_KEY_SUCCESS, response);
    }

    @GetMapping("/get-key")
    public Response genGetKey() {
        com.tencent.cloud.Response response = cosService.genTemporaryKey(KeyType.GET);
        return Response.success(ResponseCode.GENERATE_KEY_SUCCESS, response);
    }

    @GetMapping("/multipart-key")
    public Response genMultipartKey() {
        com.tencent.cloud.Response response = cosService.genTemporaryKey(KeyType.MULTIPART);
        return Response.success(ResponseCode.GENERATE_KEY_SUCCESS, response);
    }
}

package top.pi1grim.mall.controller;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.pi1grim.mall.response.Response;
import top.pi1grim.mall.service.CosService;
import top.pi1grim.mall.type.ResponseCode;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/cos")
public class CosController {

    @Resource
    private CosService cosService;

    @GetMapping("/temporary-key")
    public Response genKey() {
        com.tencent.cloud.Response response = cosService.genTemporaryKey();
        return Response.success(ResponseCode.GENERATE_KEY_SUCCESS, response);
    }
}

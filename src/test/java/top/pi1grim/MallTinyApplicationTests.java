package top.pi1grim;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.pi1grim.mall.common.utils.EntityUtils;
import top.pi1grim.mall.dto.LoginDTO;
import top.pi1grim.mall.dto.RegisterDTO;
import top.pi1grim.mall.entity.UmsMember;

@SpringBootTest(classes = MallTinyApplicationTests.class)
class MallTinyApplicationTests {

    @Test
    void contextLoads() {
        UmsMember member = new UmsMember();
        RegisterDTO dto = RegisterDTO.builder()
                .gender((byte) 1)
                .username("123123")
                .phone("12312873012")
                .password("asdiasijk")
                .build();
        EntityUtils.assign(member, dto);
        System.out.println(member);
    }

}

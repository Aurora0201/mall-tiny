package top.pi1grim;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.pi1grim.mall.common.utils.EntityUtils;
import top.pi1grim.mall.dto.LoginDTO;

@SpringBootTest(classes = MallTinyApplicationTests.class)
class MallTinyApplicationTests {

    @Test
    void contextLoads() {
        LoginDTO dto = LoginDTO.builder().username("123123").password("123").build();
        System.out.println(EntityUtils.fieldIsNull(dto));
    }

}

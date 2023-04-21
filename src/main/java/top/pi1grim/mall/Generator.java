package top.pi1grim.mall;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collections;

public class Generator {

    public static void main(String[] args) {

        FastAutoGenerator.create("jdbc:mysql://101.42.30.159:3306/tiny_mall", "root", System.getenv("PASSWORD"))
                .globalConfig(builder -> {
                    builder.author("Bin JunKai") // 设置作者
                            .outputDir("/home/binjunkai/mall/mall-tiny/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("top.pi1grim.mall") // 设置父包名
//                            .moduleName("mapper") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "/home/binjunkai/mall/mall-tiny/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder
                            .entityBuilder()
                            .enableChainModel()
                            .enableFileOverride()
                            .enableLombok()
                            .disableSerialVersionUID()
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .mapperBuilder()
                            .superClass(BaseMapper.class);//specify BaseMapper
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}

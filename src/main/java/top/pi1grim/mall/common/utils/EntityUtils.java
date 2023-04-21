package top.pi1grim.mall.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

@Slf4j
public class EntityUtils {

    private EntityUtils() {

    }

    public static final String GET = "get";

    public static final String SET = "set";

    /*
    * 检查对象是否有字段为空，或者为空字符串，前提是提供了getter方法
    * */
    public static boolean fieldIsNull(Object obj) {
        if(Objects.isNull(obj))return false;
        Class<?> clazz = obj.getClass();
        for (Field f : clazz.getDeclaredFields()) {
            try {
                String name = f.getName();
                String methodName = GET + name.toUpperCase().charAt(0) + name.substring(1);
                Method method = clazz.getDeclaredMethod(methodName);
                Object o = method.invoke(obj);
                if(Objects.isNull(o) || StringUtils.isEmpty(o.toString()))return true;
            } catch (Exception e) {
                log.error("error occur!", e);
            }
        }
        return false;
    }
}

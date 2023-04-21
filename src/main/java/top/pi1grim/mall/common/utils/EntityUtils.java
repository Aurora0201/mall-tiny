package top.pi1grim.mall.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.Objects;

@Slf4j
public class EntityUtils {

    private EntityUtils() {

    }

    public static boolean fieldsIsNull(Object obj) {
        if(Objects.isNull(obj))return false;
        for (Field f : obj.getClass().getDeclaredFields()) {
            try {
                f.setAccessible(true);
                Object o = f.get(obj);
                if(Objects.isNull(o) || StringUtils.isEmpty(o.toString()))return true;
            } catch (IllegalAccessException e) {
                log.error("error occur!", e);
            }
        }
        return false;
    }
}

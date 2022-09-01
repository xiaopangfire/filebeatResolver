package com.filebeat.util;

import lombok.experimental.UtilityClass;

/**
 * @author Jones chen
 * @Classname ReflectUtil
 * @description reflect util class
 * @since 2022/09/01 15:16
 */
@UtilityClass
public class ReflectUtil {
    public boolean checkIsBasicType(Object obj) {
        return obj instanceof String
                || obj instanceof Integer
                || obj instanceof Long
                || obj instanceof Character
                || obj instanceof Byte
                || obj instanceof Float
                || obj instanceof Double
                || obj instanceof Boolean;
    }
}

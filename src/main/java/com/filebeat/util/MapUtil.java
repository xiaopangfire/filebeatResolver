package com.filebeat.util;

import lombok.experimental.UtilityClass;

import java.util.Map;

/**
 * @author Jones chen
 * @Classname MapUtil
 * @description map util class
 * @since 2022/09/01 15:14
 */
@UtilityClass
public class MapUtil {

    public boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }
}

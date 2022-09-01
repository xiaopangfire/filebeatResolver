package com.filebeat.util;

import lombok.experimental.UtilityClass;

import java.util.Collection;

/**
 * @author Jones chen
 * @Classname CollectionUtil
 * @description collections util class
 * @since 2022/09/01 15:10
 */
@UtilityClass
public class CollectionUtil {
    public boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
}

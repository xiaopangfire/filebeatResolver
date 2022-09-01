package com.filebeat.util;

import lombok.experimental.UtilityClass;

/**
 * @author Jones chen
 * @Classname StringUtil
 * @description string util class
 * @since 2022/09/01 15:08
 */
@UtilityClass
public class StringUtil {
    public boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }
}

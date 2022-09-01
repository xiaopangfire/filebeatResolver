package com.filebeat.model.filebeat;

import lombok.Data;

/**
 * @author Jones chen
 * @Classname FilebeatMeta
 * @description metadata in  filebeat output message
 * @since 2022/09/01 15:31
 */
@Data
public class FilebeatMeta {
    private String beat;
    private String type;
    private String version;
}

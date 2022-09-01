package com.filebeat.model.filebeat;

import lombok.Data;

/**
 * @author Jones chen
 * @Classname FilebeatLog
 * @description log in  filebeat output message
 * @since 2022/09/01 15:26
 */
@Data
public class FilebeatLog {
    private File file;
    private String offset;

    @Data
    public static class File {
        private String path;
    }
}
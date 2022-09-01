package com.filebeat.model.filebeat;

import lombok.Data;

/**
 * @author Jones chen
 * @Classname FilebeatInput
 * @description input in  filebeat output message
 * @since 2022/09/01 15:26
 */
@Data
public class FilebeatInput {
    private String type;
}
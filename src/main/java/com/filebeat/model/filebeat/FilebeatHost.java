package com.filebeat.model.filebeat;

import lombok.Data;

import java.util.List;

/**
 * @author Jones chen
 * @Classname FilebeatHost
 * @description host in  filebeat output message
 * @since 2022/09/01 15:26
 */
@Data
public class FilebeatHost {
    private List<String> ip;
    private List<String> mac;
    private String name;
    private String hostname;
    private String architecture;
}

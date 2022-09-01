package com.filebeat.model.filebeat;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author Jones chen
 * @Classname FilebeatAgent
 * @description agent in  filebeat output message
 * @since 2022/09/01 15:26
 */
@Data
public class FilebeatAgent {
    private String name;
    private String type;
    private String version;
    @JSONField(name = "ephemeral_id")
    private String ephemeralId;
    private String id;
}
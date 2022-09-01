package com.filebeat.model.filebeat;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Jones chen
 * @Classname FileBeatMsg
 * @description filebeat output message
 * @since 2022/09/01 15:26
 */
@Data
public class FilebeatMsg {
    @JSONField(name = "@timestamp")
    private LocalDateTime timestamp;

    @JSONField(name = "@metadata")
    private FilebeatMeta metadata;

    private FilebeatLog log;

    private String message;

    private FilebeatHost host;

    private List<String> tags;
}

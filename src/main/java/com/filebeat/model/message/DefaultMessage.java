package com.filebeat.model.message;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author Jones chen
 * @Classname DefaultMessage
 * @description DefaultMessage includes a java strace log resolve msg
 * @since 2022/09/01 16:52
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DefaultMessage extends BaseMessage{
    private LocalDateTime datetime;
    private String level;
    private String threadName;
    private String javaClass;
    private Integer linenumber;
    private String desc;
}

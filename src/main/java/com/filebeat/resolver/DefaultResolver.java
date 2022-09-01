package com.filebeat.resolver;

import com.filebeat.model.filebeat.FilebeatMsg;
import com.filebeat.model.message.DefaultMessage;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jones chen
 * @Classname DefaultResolver
 * @description DefaultResolver default resolver,just as a example
 * @since 2022/09/01 16:52
 */
public class DefaultResolver extends BaseResolver<FilebeatMsg, DefaultMessage> {
    private static final Logger log = LoggerFactory.getLogger(DefaultResolver.class);

    @Override
    public void dealMsg(DefaultMessage defaultMessage) {
        System.out.printf("receive msg: %s", defaultMessage);
        if (log.isDebugEnabled()) {
            log.debug("receive msg: {}", defaultMessage);
        }
    }

    @Override
    public Map<String, String> getRegisterPattern() {
        Map<String, String> map = new HashMap<>();
        map.put("DATETIME", "[0-9,\\.\\-: ]+");
        map.put("JAVACLASS", "(?:[a-zA-Z$_][a-zA-Z$_0-9]*\\.)*[a-zA-Z$_][a-zA-Z$_0-9]*");
        return map;
    }

    @Override
    public String getPattern() {
        return "\\[%{DATETIME:datetime}\\]%{SPACE}%{LOGLEVEL:level}%{SPACE}\\[%{DATA:threadName}\\]%{SPACE}%{JAVACLASS:javaClass}:%{INT:linenumber}--%{SPACE}%{GREEDYDATA:desc}";
    }
}

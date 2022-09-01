package com.filebeat.source;

/**
 * @author Jones chen
 * @Classname BaseSource
 * @description message from filebeat, like http、mq... just extends this class
 * implement yourself receive method
 * @since 2022/09/01 15:20
 */
public interface BaseSource {

    default void receiveFilebeatMsg(String msgStr){}
}

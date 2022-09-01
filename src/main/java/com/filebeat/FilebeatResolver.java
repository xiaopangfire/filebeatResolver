package com.filebeat;

import com.alibaba.fastjson.JSONObject;
import com.filebeat.exception.FilebeatResolveException;
import com.filebeat.model.filebeat.FilebeatMsg;
import com.filebeat.resolver.BaseResolver;
import com.filebeat.util.CollectionUtil;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jones chen
 * @Classname FilebeatResolver
 * @description filebeat resolver
 * @since 2022/09/01 15:44
 */
public class FilebeatResolver {

    private List<BaseResolver> resolvers;

    private FilebeatResolver () {

    }

    public static FilebeatResolver getInstance() {
        FilebeatResolver filebeatResolver = new FilebeatResolver();
        filebeatResolver.resolvers = new LinkedList<>();
        return filebeatResolver;
    }


    public <T extends FilebeatMsg> void dealMsg(String filebeatMsg, Class<T> msgClass) {
        FilebeatMsg fileBeatMsg = JSONObject.parseObject(filebeatMsg, msgClass);
        dealMsg(fileBeatMsg);
    }


    public <T extends FilebeatMsg> void dealMsg(T t) {
        if(CollectionUtil.isEmpty(resolvers)){
            throw new FilebeatResolveException("please invoke registerResolver first");
        }
      resolvers=  resolvers.stream().sorted(new Comparator<BaseResolver>() {
            @Override
            public int compare(BaseResolver o1, BaseResolver o2) {
                return o1.getOrder() - o2.getOrder();
            }
        }).collect(Collectors.toList());
      resolvers.forEach(resolver->{
          resolver.resolve(t);
      });
    }


    public void registerResolver(BaseResolver<?, ?> t) {
        resolvers.add(t);
    }

}

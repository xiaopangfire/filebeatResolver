package com.filebeat.resolver;

import com.alibaba.fastjson.JSONObject;
import com.filebeat.exception.FilebeatResolveException;
import com.filebeat.model.filebeat.FilebeatMsg;
import com.filebeat.model.message.BaseMessage;
import com.filebeat.util.CollectionUtil;
import com.filebeat.util.MapUtil;
import io.krakens.grok.api.Grok;
import io.krakens.grok.api.GrokCompiler;
import io.krakens.grok.api.Match;
import lombok.SneakyThrows;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * @author Jones chen
 * @Classname BaseResolver
 * @description base filebeat resolver
 * @since 2022/09/01 15:56
 */
public abstract class BaseResolver<P extends FilebeatMsg, T extends BaseMessage> {

    /**
     * whether invoke {@link io.krakens.grok.api.GrokCompiler registerDefaultPatterns}
     *
     * @return whether
     */
    public boolean registerDefaultGrokPattern() {
        return true;
    }

    /**
     * resolve message order,if  not rewrite it, no order
     *
     * @return order index
     */
    public int getOrder() {
        return 0;
    }

    /**
     * resolve message grok self pattern classpath,if  not rewrite it, no self pattern classpath
     *
     * @return pattern classpath
     */
    public Set<String> getPatternClassPath() {
        return Collections.emptySet();
    }

    /**
     * resolve message grok self pattern ,if  not rewrite it, no self pattern
     *
     * @return pattern
     */
    public Map<String, String> getRegisterPattern() {
        return Collections.emptyMap();
    }

    @SneakyThrows(FilebeatResolveException.class)
    public void resolve(P p) {
        GrokCompiler grokCompiler = GrokCompiler.newInstance();
        if (registerDefaultGrokPattern()) {
            grokCompiler.registerDefaultPatterns();
        }
        if (CollectionUtil.isNotEmpty(getPatternClassPath())) {
            getPatternClassPath().forEach(grokCompiler::registerPatternFromClasspath);
        }
        if (MapUtil.isNotEmpty(getRegisterPattern())) {
            getRegisterPattern().forEach(grokCompiler::register);
        }
        Grok grok = grokCompiler.compile(getPattern());
        Match grokMatch = grok.match(p.getMessage());
        Map<String, Object> resultMap = grokMatch.capture();
        if (MapUtil.isEmpty(resultMap)) {
            throw new FilebeatResolveException("grok can not match any result");
        }
        T t = JSONObject.parseObject(JSONObject.toJSONString(resultMap), getMessageClass());
        dealMsg(t);
    }

    public abstract void dealMsg(T t);

    public abstract String getPattern();

    protected Class<T> getMessageClass() {
        Type genType = this.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        return (Class<T>) params[1];
    }
}

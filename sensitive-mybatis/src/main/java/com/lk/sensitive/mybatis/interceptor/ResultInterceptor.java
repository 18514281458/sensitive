package com.lk.sensitive.mybatis.interceptor;

import com.lk.sensitive.core.filter.SensitiveServiceFilter;
import com.lk.sensitive.core.type.SensitiveMode;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Objects;
import java.util.Properties;

/**
 * 查询结果拦截器
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class,
                RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class,
                RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),})
public class ResultInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        Object result = invocation.proceed();

        if (Objects.isNull(result)) {
            return result;
        }
        SensitiveServiceFilter.process(result, SensitiveMode.MYBATIS);
        return result;
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}

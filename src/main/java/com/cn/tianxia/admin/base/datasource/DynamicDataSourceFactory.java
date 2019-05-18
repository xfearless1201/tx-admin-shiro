package com.cn.tianxia.admin.base.datasource;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
import com.cn.tianxia.admin.base.properties.DataSourceProperties;

/**
 * 
 * @ClassName DynamicDataSourceFactory
 * @Description druid配置
 * @author Hardy
 * @Date 2019年5月2日 下午6:05:20
 * @version 1.0.0
 */
public class DynamicDataSourceFactory {

    public static DruidDataSource buildDruidDataSource(DataSourceProperties properties) {
        DruidDataSource druidDataSource = new DruidDataSource();
        try {
            druidDataSource.setDriverClassName(properties.getDriverClassName());
            druidDataSource.setUrl(properties.getUrl());
            druidDataSource.setUsername(properties.getUsername());
            druidDataSource.setPassword(ConfigTools.decrypt(properties.getPublicKey(), properties.getPassword()));
            druidDataSource.setInitialSize(properties.getInitialSize());
            druidDataSource.setMaxActive(properties.getMaxActive());
            druidDataSource.setMinIdle(properties.getMinIdle());
            druidDataSource.setMaxWait(properties.getMaxWait());
            druidDataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
            druidDataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
            druidDataSource.setMaxEvictableIdleTimeMillis(properties.getMaxEvictableIdleTimeMillis());
            druidDataSource.setValidationQuery(properties.getValidationQuery());
            druidDataSource.setValidationQueryTimeout(properties.getValidationQueryTimeout());
            druidDataSource.setTestOnBorrow(properties.isTestOnBorrow());
            druidDataSource.setTestOnReturn(properties.isTestOnReturn());
            druidDataSource.setPoolPreparedStatements(properties.isPoolPreparedStatements());
            druidDataSource.setMaxOpenPreparedStatements(properties.getMaxOpenPreparedStatements());
            druidDataSource.setSharePreparedStatements(properties.isSharePreparedStatements());
            druidDataSource.setFilters(properties.getFilters());
            druidDataSource.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }
}
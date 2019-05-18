package com.cn.tianxia.admin.base.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource{
    
    @Override
	protected Object determineCurrentLookupKey() {
	    return DataSourceHolder.peek();
	}

}

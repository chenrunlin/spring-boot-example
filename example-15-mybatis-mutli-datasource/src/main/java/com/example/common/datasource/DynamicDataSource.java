package com.example.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源（需要继承AbstractRoutingDataSource）
 */
public class DynamicDataSource  extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		
		return DataSourceContextHolder.getDbType();
		
	}

}

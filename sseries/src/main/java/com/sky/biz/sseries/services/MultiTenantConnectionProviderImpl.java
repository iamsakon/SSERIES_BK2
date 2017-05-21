package com.sky.biz.sseries.services;

import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.DataSourceLookup;

public class MultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl{
	
	private static final long serialVersionUID = 14535345L;
    @Autowired
    private DataSource defaultDataSource;
    @Autowired
    private DataSourceLookup dataSourceLookup;

    /**
     * Select datasources in situations where not tenantId is used (e.g. startup processing).
    */
    @Override
    protected DataSource selectAnyDataSource() {
        //logger.trace("Select any dataSource: " + defaultDataSource);
        return defaultDataSource;
    }
    /**
     * Obtains a DataSource based on tenantId
    */
    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
        DataSource ds = dataSourceLookup.getDataSource(tenantIdentifier);
        //logger.trace("Select dataSource from "+ tenantIdentifier+ ": " + ds);
        return ds;
    }
}

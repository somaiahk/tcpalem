package com.tcpalem.studentdata.jpa.datasource;

import java.util.Collections;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

/**
 * @since 17/06/2016
 * @author somaiah
 *
 */
@Component(value = "dataSource")
public class StudentRoutingDataSource extends AbstractRoutingDataSource {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentRoutingDataSource.class);
	
	@Override
	protected Object determineCurrentLookupKey() {
		return null;
	}

	@PostConstruct
	public void setTargetDataSources() {

		Map<Object, Object> targetDataSources = Collections.emptyMap();

		super.setTargetDataSources(targetDataSources);
	}

	@Override
	protected DataSource determineTargetDataSource() {
		/*Object o = RequestContext.getCurrentContext().get(Constants.TENANT_MYSQL_DBCP_KEY);

        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Extracted from RequestContext: {}={}", Constants.TENANT_MYSQL_DBCP_KEY, o);
        }
        
        DataSource dataSource = (DataSource)o;
        //TODO Throw Exception
        if(dataSource == null){
        	dataSource = new BasicDataSource();
        }*/
		
        //return dataSource;
		return null;
	}
}

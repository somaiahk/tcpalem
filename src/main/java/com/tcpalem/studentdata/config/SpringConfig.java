package com.tcpalem.studentdata.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tcpalem.studentdata.jpa.datasource.StudentRoutingDataSource;

/**
 * @since 17/06/2016
 * @author somaiah
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.tcpalem.studentdata.*"))
@EnableJpaRepositories(basePackages = "com.tcpalem.studentdata.backend.repository", entityManagerFactoryRef = "tcpalemEntityManagerFactory", transactionManagerRef = "tcpalemTransactionManager")
public class SpringConfig {
	
	@Autowired
	StudentRoutingDataSource dataSource;
	
	@Autowired
	StudentDataConfig studentConfig;	
	
	
	@Bean(name = "jerseyClient")
	public com.sun.jersey.api.client.Client getJerseyClient() {		
		ClientConfig cc = new DefaultClientConfig();
	    cc.getProperties().put(ClientConfig.PROPERTY_FOLLOW_REDIRECTS, true);
	    com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create(cc);
	    client.addFilter(new com.sun.jersey.api.client.filter.LoggingFilter());
	    return client;
	}
	 
	 
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(false);
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		return hibernateJpaVendorAdapter;
	}
		
	@Bean
	public LocalContainerEntityManagerFactoryBean originationEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	    emf.setDataSource(dataSource);
	    emf.setJpaVendorAdapter(jpaVendorAdapter());
	    emf.setPersistenceUnitName("realdoc-capture");
		emf.setPackagesToScan("com.tcpalem.studentdata.backend.entity", "com.tcpalem.studentdata.backend.entity");   // <- package for entities
		return emf;
	}
		
	@Bean
	public JpaTransactionManager originationTransactionManager(EntityManagerFactory emf){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);			
		return transactionManager;
	}
		
	

}

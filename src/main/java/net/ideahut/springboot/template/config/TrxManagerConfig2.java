package net.ideahut.springboot.template.config;

import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.ideahut.springboot.template.AppConstants;
import net.ideahut.springboot.template.properties.AppProperties;
import net.ideahut.springboot.template.properties.AppProperties.Audit;
import net.ideahut.springboot.template.properties.OtherProperties;
import net.ideahut.springboot.util.FrameworkUtil;

/*
 * Konfigurasi Second Transaction Manager & Entity Manager
 * 
 */
//@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
(
	entityManagerFactoryRef = "entityManagerFactory_2",
	transactionManagerRef = "transactionManager_2"
)
class TrxManagerConfig2 {
	
	@Autowired
	private OtherProperties otherProperties;
	

	@Bean(name = "dataSource_2")
	protected DataSource dataSource() {
		AppProperties.Datasource datasource = otherProperties.getTrxManager().getSecond().getDatasource();
		String jndi = datasource.getJndiName();
		jndi = jndi != null ? jndi.trim() : "";
		if (jndi.length() != 0) {
			JndiDataSourceLookup lookup = new JndiDataSourceLookup();
			return lookup.getDataSource(jndi);
		} else {
			return DataSourceBuilder.create()
			.driverClassName(datasource.getDriverClassName())
			.url(datasource.getJdbcUrl())
			.username(datasource.getUsername())
			.password(datasource.getPassword())
			.build();
		}
    }
	
	@Bean(name = "entityManagerFactory_2")
	protected LocalContainerEntityManagerFactoryBean entityManagerFactory(
		EntityManagerFactoryBuilder builder,
		@Qualifier("dataSource_2") DataSource dataSource,
		@Qualifier("auditSessionFactory_2") SessionFactory auditSessionFactory
	) {
		AppProperties.Jpa jpa = otherProperties.getTrxManager().getSecond().getJpa();
		Map<String, Object> properties = FrameworkUtil.getHibernateSettings(jpa.getProperties());
		LocalContainerEntityManagerFactoryBean bean = builder
			.dataSource(dataSource)		
			.persistenceUnit("default")
			.properties(properties)			
			.build();
		bean.setPersistenceUnitPostProcessors(new PersistenceUnitPostProcessor() {
			@Override
			public void postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo pui) {
				pui.addManagedClassName(AppConstants.PACKAGE + ".entity.Information");
				pui.addManagedClassName(AppConstants.PACKAGE + ".entity.CompositeHardDel");
			}
		});
		return bean;
	}
	
	@Bean(name = "transactionManager_2")
	protected PlatformTransactionManager transactionManager(
		@Qualifier("entityManagerFactory_2") EntityManagerFactory entityManagerFactory
	) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	@Bean(name = "auditDatasource_2")
	protected DataSource auditDatasource() {
		Audit audit = otherProperties.getTrxManager().getSecond().getAudit();
		String jndi = audit.getDatasource().getJndiName();
		jndi = jndi != null ? jndi.trim() : "";
		if (jndi.length() != 0) {
			JndiDataSourceLookup lookup = new JndiDataSourceLookup();
			return lookup.getDataSource(jndi);
		} else {
			AppProperties.Datasource datasource = audit.getDatasource();
			return DataSourceBuilder.create()
			.driverClassName(datasource.getDriverClassName())
			.url(datasource.getJdbcUrl())
			.username(datasource.getUsername())
			.password(datasource.getPassword())
			.build();
		}
    }
	
	@Bean(name = "auditSessionFactory_2")
	protected LocalSessionFactoryBean auditSessionFactory(
		@Qualifier("auditDatasource_2") DataSource datasource
	) {
		Audit audit = otherProperties.getTrxManager().getSecond().getAudit();
		Properties properties = FrameworkUtil.getHibernateProperties(audit.getJpa().getProperties());
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(datasource);
        sessionFactory.setHibernateProperties(properties);
        sessionFactory.setEntityInterceptor(null);
        return sessionFactory;
	}
	
}

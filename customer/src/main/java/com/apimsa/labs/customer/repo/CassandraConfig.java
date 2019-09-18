package com.apimsa.labs.customer.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(
		  basePackages = "com.apimsa.labs.customer.repo")
public class CassandraConfig extends AbstractCassandraConfiguration {

	    private static final Logger LOG = LoggerFactory.getLogger(CassandraConfig.class);

	    @Autowired
	    private Environment environment;

	    @Bean
	    public CassandraClusterFactoryBean cluster() {
	        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
	        cluster.setContactPoints(environment.getProperty("spring.data.cassandra.contact-points"));
	        cluster.setPort(Integer.parseInt(environment.getProperty("spring.data.cassandra.port")));
	        return cluster;
	    }

	    @Override
	    protected String getKeyspaceName() {
	        return environment.getProperty("spring.data.cassandra.keyspace-name");
	    }

	    @Bean
	    public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
	        return new BasicCassandraMappingContext();
	    }
}


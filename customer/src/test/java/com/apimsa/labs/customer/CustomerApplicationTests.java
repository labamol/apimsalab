package com.apimsa.labs.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.apimsa.labs.customer.repo.CassandraConfig;


@SpringBootTest
@ContextConfiguration(classes = CassandraConfig.class)
public class CustomerApplicationTests {

	@Test
	public void contextLoads() {
		
	}

}

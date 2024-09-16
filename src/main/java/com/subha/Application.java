package com.subha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.subha.entity.Order;
import com.subha.repo.OrderRepo;

@SpringBootApplication
public class Application implements ApplicationRunner{
	
	@Autowired
	private OrderRepo repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Order order=new Order();
		order.setName("Reebook Shoe");
		repo.save(order);
		
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

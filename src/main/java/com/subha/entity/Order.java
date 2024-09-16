package com.subha.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="order_tbl")
public class Order {
	
	@Id
	@GenericGenerator(name="order_id",strategy = "com.subha.generator.CustomIdGenerator")
	@GeneratedValue(generator = "order_id")
	@Column(name="order_id")
	private String id;
	
	@Column(name="order_name")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}

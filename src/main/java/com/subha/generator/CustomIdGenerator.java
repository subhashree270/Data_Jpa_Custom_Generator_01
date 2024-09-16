package com.subha.generator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

@Component
public  class CustomIdGenerator implements IdentifierGenerator {
	
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object){

	    String prefix = "OD_000";
	JdbcConnectionAccess con = session.getJdbcConnectionAccess();
	        
	            try {
	                JdbcConnectionAccess jdbcConnectionAccess = session.getJdbcConnectionAccess();
	                Connection connection = jdbcConnectionAccess.obtainConnection();
	                Statement statement = connection.createStatement();
	                String query = "select count(order_id) as Id from order_tbl";

	                ResultSet resultSet = statement.executeQuery(query);

	                if (resultSet.next()) {
	                     int id=resultSet.getInt(1)+1;
	                     String generatedId = prefix + new Integer(id).toString();
	                     return generatedId;
	                }

	                resultSet.close();
	                statement.close();
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	return null;
	}}
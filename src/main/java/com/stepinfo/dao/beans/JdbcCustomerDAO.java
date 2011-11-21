package com.stepinfo.dao.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.stepinfo.dao.CustomerDAO;

public class JdbcCustomerDAO extends JdbcDaoSupport implements CustomerDAO {

//	private DataSource dataSource;
//	 
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	
	
	public void insert(Customer customer) {
		
		String sql = "INSERT INTO customer ";
		String sqlId = "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		String sqlAutoId = "(NAME, AGE) VALUES (?, ?)";
		if (customer.getCustId() >0)
			sql = sql+sqlId;
		else 
			sql = sql+sqlAutoId;

		Connection conn = null;
 
		try {
//			conn = dataSource.getConnection();
			conn = getJdbcTemplate().getDataSource().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			if ( customer.getCustId() > 0  )
			{
				ps.setInt(1, customer.getCustId());
				ps.setString(2, customer.getName());
				ps.setInt(3, customer.getAge());
			}
			else
			{
				ps.setString(1, customer.getName());
				ps.setInt(2, customer.getAge());
			}
			ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}

	}

	public Customer findByCustomerId(int custId) {
		String sql = "SELECT * FROM customer WHERE CUST_ID = ?";
		 
		Connection conn = null;
 
		try {
//			conn = dataSource.getConnection();
			conn = getJdbcTemplate().getDataSource().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			Customer customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(
					rs.getInt("CUST_ID"),
					rs.getString("NAME"), 
					rs.getInt("AGE")
				);
			}
			rs.close();
			ps.close();
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public int getMaxId() {

		String sql = "SELECT max(cust_id) FROM customer";
		 
		Connection conn = null;
 
		try {
			// conn = dataSource.getConnection();
			conn = getJdbcTemplate().getDataSource().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int numberOfRows = 0;
			if (rs.next())
				numberOfRows = rs.getInt(1);
			rs.close();
			ps.close();
			return numberOfRows;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DBUtils;

/**
 * 	DAO类
 *
 */
public class UserDAO {
	
	public User find(String uname){
		User user = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			String sql = "SELECT * FROM t_user "
					+ "WHERE username=?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUname(uname);
				user.setPwd(rs.getString(
						"password"));
				user.setPhone(
						rs.getString("phone"));
				user.setEmail(
						rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtils.closeConn(conn);
		}
		return user;
	}
	
	
	public void delete(int id){
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			String sql = "DELETE FROM t_user "
					+ "WHERE id=?";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtils.closeConn(conn);
		}
	}
	
	
	public void save(User user){
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			String sql = "INSERT INTO t_user "
					+ "VALUES(null,?,?,?,?)";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getPwd());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtils.closeConn(conn);
		}
	}
	

	public List<User> findAll(){
		List<User> users =  
				new ArrayList<User>();
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			String sql = "SELECT * FROM t_user";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String uname = rs.getString(
						"username");
				String pwd = rs.getString(
						"password");
				String phone = rs.getString(
						"phone");
				String email = rs.getString(
						"email");
				User user = new User();
				user.setId(id);
				user.setUname(uname);
				user.setPwd(pwd);
				user.setPhone(phone);
				user.setEmail(email);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtils.closeConn(conn);
		}
		return users;
	}
	
}










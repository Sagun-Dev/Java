package lab4.Q3.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBModel {
	Connection conn;

	public Connection prepare() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/news", "root","");
		return conn;
	}
	public void close() throws SQLException {
		conn.close();
	}

	public void save(ArrayList<String> row) throws SQLException {
		String query = "INSERT INTO articles(`Title`,`Description`,`Author`,`Author_ID`,`upvoters`,`downvoters`) Values (?,?,?,0,'[]','[]')";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,row.get(0));
		ps.setString(2, row.get(1));
		ps.setString(3, row.get(2));
		ps.executeUpdate();
	}

	public ResultSet select(ArrayList<String> row) throws SQLException {
		String query = "SELECT * FROM articles WHERE I_D LIKE ? and Title LIKE ? and Description LIKE ? and Author LIKE ? and Upvotes LIKE ? and Downvotes LIKE ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, row.get(0));
		ps.setString(2, "%"+row.get(1)+"%");
		ps.setString(3, "%"+row.get(2)+"%");
		ps.setString(4, "%"+row.get(3)+"%");
		ps.setString(5, row.get(4));
		ps.setString(6, row.get(5));
		ResultSet result = ps.executeQuery();
		return result;
	}

	public void update(ArrayList<String> row) throws SQLException {
		for(String str:row) {
			System.out.println(str);
		}
		String query = "UPDATE articles SET Title = ?, Description = ? WHERE I_D = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, row.get(0));
		ps.setString(2, row.get(1));
		ps.setString(3, row.get(2));
		ps.executeUpdate();
	}

	public void delete(String id) throws SQLException {
		String query = "DELETE FROM articles WHERE I_D = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.executeUpdate();
	}
}

package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.helpers.DBHelper;
import ro.emanuel.pojo.Restaurant;

public class RestaurantDAO {

	public static Restaurant getRestaurantById(int id) throws SQLException {
		String select = "SELECT * FROM restaurant WHERE id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Restaurant result = null;

		if (rs.next()) {
			String nume = rs.getString("nume");
			String telefon = rs.getString("telefon");
			String adresa = rs.getString("adresa");
			Double rating = rs.getDouble("rating");
			String imagine = rs.getString("imagine");
			
			result = new Restaurant(id, nume, telefon, adresa, rating, imagine);
		}
		DBHelper.closeConnection();
		return result;
	}

	public static ArrayList<Restaurant> getRestaurantByName(String nameQuery) throws SQLException {
		String select = "SELECT * FROM restaurant WHERE nume LIKE ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, "%" + nameQuery + "%");
		ResultSet rs = stmt.executeQuery();
		ArrayList<Restaurant> result = new ArrayList<Restaurant>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String telefon = rs.getString("telefon");
			String adresa = rs.getString("adresa");
			double rating = rs.getDouble("rating");
			String imagine = rs.getString("imagine");
			
			result.add(new Restaurant(id, nume, telefon, adresa, rating, imagine));
		}
		DBHelper.closeConnection();
		return result;
	}

	public static ArrayList<Restaurant> getRestaurante() throws SQLException {

		String select = "select * from restaurant";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		ArrayList<Restaurant> result = new ArrayList<Restaurant>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String telefon = rs.getString("telefon");
			String adresa = rs.getString("adresa");
			double rating = rs.getDouble("rating");
			String imagine = rs.getString("imagine");
			
			Restaurant c = new Restaurant(id, nume, telefon, adresa, rating, imagine);
			result.add(c);

		}
		DBHelper.closeConnection();
		return result;
	}

	public static void createRestaurant(String nume, String telefon, String adresa, double rating, String imagine) throws SQLException {
		String insert = "INSERT INTO restaurant(nume, telefon, adresa, rating, imagine)" + "VALUE(?,?,?,?,?)";
		Connection con = DBHelper.getConnection();

		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setString(1, nume);
		stmt.setString(2, telefon);
		stmt.setString(3, adresa);
		stmt.setDouble(4, rating);
		stmt.setString(5, imagine);
		
		stmt.executeUpdate();

		DBHelper.closeConnection();
	}

	public static void createRestaurant(Restaurant c) throws SQLException {
		RestaurantDAO.createRestaurant(c.getNume(), c.getTelefon(), c.getAdresa(), c.getRating(), c.getImagine());
	}

	public static void updateRestaurant(Restaurant c) throws SQLException {
		String update = "UPDATE restaurant SET nume = ?, telefon = ?, adresa = ?, rating = ?, imagine = ? WHERE id = ?";
		Connection con = DBHelper.getConnection();

		PreparedStatement stmt = con.prepareStatement(update);
		stmt.setString(1, c.getNume());
		stmt.setString(2, c.getTelefon());
		stmt.setString(3, c.getAdresa());
		stmt.setDouble(4, c.getRating());
		stmt.setString(5, c.getImagine());
		stmt.setInt(6, c.getId());
		
		stmt.executeUpdate();

		DBHelper.closeConnection();
	}

	public static void deleteRestaurant(int id) throws SQLException {
		String delete = "DELETE FROM restaurant WHERE id = ?";
		Connection con = DBHelper.getConnection();

		PreparedStatement stmt = con.prepareStatement(delete);
		stmt.setInt(1, id);
		stmt.executeUpdate();

		DBHelper.closeConnection();
	}

	public static void deleteRestaurant(Restaurant c) throws SQLException {
		RestaurantDAO.deleteRestaurant(c.getId());
	}
	
	public static int countRestaurante() throws SQLException {
		String select = "select * from restaurant";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		int result = 0;
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			result++;

		}
		DBHelper.closeConnection();
		return result;
	}
	
}

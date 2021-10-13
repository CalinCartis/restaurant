package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.helpers.DBHelper;
import ro.emanuel.pojo.Comanda;

public class ComandaDAO {

	public static Comanda getComandaById(int id) throws SQLException {
		String select = "SELECT * FROM comanda WHERE id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Comanda result = null;

		if (rs.next()) {
			int idClient = rs.getInt("idClient");
			int idRestaurant = rs.getInt("idRestaurant");
			String produsComandat = rs.getString("produsComandat");
			int cantitate = rs.getInt("cantitate");
			double pret = rs.getDouble("pret");
			
			result = new Comanda(id, idClient, idRestaurant, produsComandat, cantitate, pret);
		}
		DBHelper.closeConnection();
		return result;
	}

	public static ArrayList<Comanda> getComandaByName(String nameQuery) throws SQLException {
		String select = "SELECT * FROM comanda WHERE nume LIKE ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, "%" + nameQuery + "%");
		ResultSet rs = stmt.executeQuery();
		ArrayList<Comanda> result = new ArrayList<Comanda>();
		while (rs.next()) {
			int id = rs.getInt("id");
			int idClient = rs.getInt("idClient");
			int idRestaurant = rs.getInt("idRestaurant");
			String produsComandat = rs.getString("produsComandat");
			int cantitate = rs.getInt("cantitate");
			double pret = rs.getDouble("pret");
			
			result.add(new Comanda(id, idClient, idRestaurant, produsComandat, cantitate, pret));
		}
		DBHelper.closeConnection();
		return result;
	}

	public static ArrayList<Comanda> getComenzi() throws SQLException {

		String select = "select * from comanda";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		ArrayList<Comanda> result = new ArrayList<Comanda>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			int idClient = rs.getInt("idClient");
			int idRestaurant = rs.getInt("idRestaurant");
			String produsComandat = rs.getString("produsComandat");
			int cantitate = rs.getInt("cantitate");
			double pret = rs.getDouble("pret");

			Comanda c = new Comanda(id, idClient, idRestaurant, produsComandat, cantitate, pret);
			result.add(c);

		}
		DBHelper.closeConnection();
		return result;
	}

	public static void createComanda(int idClient, int idRestaurant, String produsComandat, int cantitate, double pret) throws SQLException {
		String insert = "INSERT INTO comanda(idClient, idRestaurant, produsComandat, cantitate, pret) VALUE(?,?,?,?,?)";
		Connection con = DBHelper.getConnection();

		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setInt(1, idClient);
		stmt.setInt(2, idRestaurant);
		stmt.setString(3, produsComandat);
		stmt.setInt(4, cantitate);
		stmt.setDouble(5, pret);
		
		stmt.executeUpdate();

		DBHelper.closeConnection();
	}

	public static void createComanda(Comanda c) throws SQLException {
		ComandaDAO.createComanda(c.getIdClient(), c.getIdRestaurant(), c.getProdusComandat(), c.getCantitate(), c.getPret());
	}

	public static void updateComanda(Comanda c) throws SQLException {
		String update = "UPDATE comanda SET idClient = ?, idRestaurant = ?, produsComandat = ?, cantitate = ?, pret = ? WHERE id = ?";
		Connection con = DBHelper.getConnection();

		PreparedStatement stmt = con.prepareStatement(update);
		stmt.setInt(1, c.getIdClient());
		stmt.setInt(2, c.getIdRestaurant());
		stmt.setString(3, c.getProdusComandat());
		stmt.setInt(4, c.getCantitate());
		stmt.setDouble(5, c.getPret());
		stmt.setInt(6, c.getId());
		
		stmt.executeUpdate();

		DBHelper.closeConnection();
	}

	public static void deleteComanda(int id) throws SQLException {
		String delete = "DELETE FROM comanda WHERE id = ?";
		Connection con = DBHelper.getConnection();

		PreparedStatement stmt = con.prepareStatement(delete);
		stmt.setInt(1, id);
		stmt.executeUpdate();

		DBHelper.closeConnection();
	}

	public static void deleteComanda(Comanda c) throws SQLException {
		ComandaDAO.deleteComanda(c.getId());
	}
	
	public static int countComenzi() throws SQLException {
		String select = "select * from comanda";
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

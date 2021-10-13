package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.helpers.DBHelper;
import ro.emanuel.pojo.Client;

public class ClientDAO {

	public static Client getClientById(int id) throws SQLException {
		String select = "SELECT * FROM client WHERE id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Client result = null;

		if (rs.next()) {
			String nume = rs.getString("nume");
			String prenume = rs.getString("prenume");
			String adresa = rs.getString("adresa");
			String telefon = rs.getString("telefon");
			
			result = new Client(id, nume, prenume, adresa,telefon);
		}
		DBHelper.closeConnection();
		return result;
	}

	public static ArrayList<Client> getClientByName(String nameQuery) throws SQLException {
		String select = "SELECT * FROM client WHERE nume LIKE ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, "%" + nameQuery + "%");
		ResultSet rs = stmt.executeQuery();
		ArrayList<Client> result = new ArrayList<Client>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String prenume = rs.getString("prenume");
			String adresa = rs.getString("adresa");
			String telefon = rs.getString("telefon");
			
			result.add(new Client(id, nume, prenume, adresa,telefon));
		}
		DBHelper.closeConnection();
		return result;
	}

	public static ArrayList<Client> getClienti() throws SQLException {

		String select = "select * from client";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		ArrayList<Client> result = new ArrayList<Client>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String prenume = rs.getString("prenume");
			String adresa = rs.getString("adresa");
			String telefon = rs.getString("telefon");

			Client c = new Client(id, nume, prenume, adresa,telefon);
			result.add(c);

		}
		DBHelper.closeConnection();
		return result;
	}

	public static void createClient(String nume, String prenume, String adresa, String telefon) throws SQLException {
		String insert = "INSERT INTO client(nume, prenume, adresa, telefon)" + "VALUE(?,?,?,?)";
		Connection con = DBHelper.getConnection();

		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setString(1, nume);
		stmt.setString(2, prenume);
		stmt.setString(3, adresa);
		stmt.setString(4, telefon);

		stmt.executeUpdate();

		DBHelper.closeConnection();
	}

	public static void createClient(Client c) throws SQLException {
		ClientDAO.createClient(c.getNume(), c.getPrenume(), c.getAdresa(), c.getTelefon());
	}

	public static void updateClient(Client c) throws SQLException {
		String update = "UPDATE client SET nume = ?, prenume = ?, adresa = ?, telefon = ? WHERE id = ?";
		Connection con = DBHelper.getConnection();

		PreparedStatement stmt = con.prepareStatement(update);
		stmt.setString(1, c.getNume());
		stmt.setString(2, c.getPrenume());
		stmt.setString(3, c.getAdresa());
		stmt.setString(4, c.getTelefon());
		stmt.setInt(5, c.getId());
		
		stmt.executeUpdate();

		DBHelper.closeConnection();
	}

	public static void deleteClient(int id) throws SQLException {
		String delete = "DELETE FROM client WHERE id = ?";
		Connection con = DBHelper.getConnection();

		PreparedStatement stmt = con.prepareStatement(delete);
		stmt.setInt(1, id);
		stmt.executeUpdate();

		DBHelper.closeConnection();
	}

	public static void deleteClient(Client c) throws SQLException {
		ClientDAO.deleteClient(c.getId());
	}
	
	public static int countClienti() throws SQLException {
		String select = "select * from client";
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

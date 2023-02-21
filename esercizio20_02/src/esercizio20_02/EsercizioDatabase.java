package esercizio20_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class EsercizioDatabase {
	
	private Connection con;
	public static void main (String[] args) {
		
		EsercizioDatabase ed = new EsercizioDatabase();
		try {
			System.out.println(ed.StartConnection().isValid(100));
			System.out.println(ed.StartConnection().isClosed());
			//ed.MetodoInsert(2, "Mario", "Rossi", "mario.rossi@gmail.com");
			//ed.MetodoInsert(3, "Giovanna", "Rossi", "Giovanna.rossi@gmail.com");
			ed.MetodoUpdate("Giovanna", "De Rossi", "Giovanna.DeRossi@gmail.com",3);
			//ed.MetodoDelete(2);
			ed.ViewDatabase();
		}catch (SQLException e) {
			System.out.println("Errore connessione");
			e.printStackTrace();
		}

	}
	
	private Connection StartConnection() throws SQLException{
		if (con == null) {
			
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setServerName("127.0.0.1");
			dataSource.setPortNumber(3306);
			dataSource.setUser("root");
			dataSource.setPassword("root");
			dataSource.setDatabaseName("db_es_20_02");
			
			con = dataSource.getConnection();	
		}
		return con;
		}
	
	private void MetodoInsert(int id, String nome, String cognome, String email) throws SQLException{
		String sql = "INSERT INTO clienti (id, nome, cognome, email) values (?,?,?,?)";
		PreparedStatement statement = StartConnection().prepareStatement(sql);
		statement.setInt(1,id);
		statement.setString(2,nome);
		statement.setString(3,cognome);
		statement.setString(4,email);
		statement.executeUpdate();
		}
	
	public void MetodoUpdate(String nome, String cognome, String email, int id) throws SQLException {
		
		String sql = "UPDATE clienti SET nome=?, cognome =?, email=? WHERE id =?";
		PreparedStatement statement = StartConnection().prepareStatement(sql);
		statement.setInt(4,id);
		statement.setString(1,nome);
		statement.setString(2,cognome);
		statement.setString(3,email);
		statement.executeUpdate();
	}
	
	public void MetodoDelete (int id) throws SQLException {
		
		String sql = "DELETE FROM clienti WHERE id =? ";
		PreparedStatement statement = StartConnection().prepareStatement(sql);
		statement.setInt(1,id);
		statement.executeUpdate();
	}
	
	public void ViewDatabase() throws SQLException {
		
		String sql = "SELECT * FROM clienti";
		PreparedStatement statement = StartConnection().prepareStatement(sql);
		
		statement.executeQuery();
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			System.out.println("id: " + rs.getInt(1));
			System.out.println("nome: " + rs.getString(2));
			System.out.println("cognome: " + rs.getString(3));
			System.out.println("email:" +rs.getString(4));
			System.out.println("---------------------------" );
		}
				
	}
				
				
		
	}
	
	


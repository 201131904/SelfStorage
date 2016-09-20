package za.ac.uj.acsse.miniproject.methods;

import java.sql.*;

/**
 * 
 * @author Broadkast
 *	This class takes in details of new clients to be assigned plots
 *
 */
public class Registration {


	private long idNumber;
	private String title;
	private String name;
	private String surname;
	private long cellNumber;
	private long telNumber;
	private String physicalAddress;
	private String postalAddress;
	private String email;
	
	
	public void register(long idNumber, String title, String name, String surname, long cellNumber, long telNumber,
							String physicalAddress, String postalAddress, String email) throws ClassNotFoundException, SQLException {
		idNumber = this.idNumber;
		title = this.title;
		name = this.name;
		surname = this.surname;
		cellNumber = this.cellNumber;
		telNumber = this.telNumber;
		physicalAddress = this.physicalAddress;
		postalAddress = this.postalAddress;
		email = this.email;

		//Accessing driver
		Class.forName("com.mysql.jdbc.Driver");
		

		String url = "jdbc:mysql://localhost:3306/BroadkastDist";
		String user = "root";
		String password = "itinerari";
		String sql = "Insert into User (IdNumber, Title, Name, Surname, Email, CellNumber, TelNumber, PhysicalAddress, "
				+ "PostalAddress) values (?,?,?,?,?,?,?,?)";
		
		//Creating connection instance
		Connection conn = DriverManager.getConnection(url, user, password);
		
		//insert query
		PreparedStatement insert = conn.prepareStatement(sql);
		insert.setLong(1, idNumber);
		insert.setString(2, title);
		insert.setString(3, name);
		insert.setString(4, surname);
		insert.setString(5, email);
		insert.setLong(6, cellNumber);
		insert.setLong(7, telNumber);
		insert.setString(8, physicalAddress);
		insert.setString(9, postalAddress);
		
		insert.execute();
		insert.close();
	}
}

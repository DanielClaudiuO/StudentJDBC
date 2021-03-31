package ro.emanuel.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class tema {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Properties connectionProps = new Properties();
		connectionProps.put("user", "root");
		connectionProps.put("password", "");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1", connectionProps);

		PreparedStatement stmt;
		Scanner input = new Scanner(System.in);
		System.out.println("Chose action:");
		System.out.println("create/read/update/delete");
		String command = input.nextLine();

		while (!command.equals("end")) {

			if (command.equals("create")) {
				String createString = "insert into curs(id,materie,profesor,sala,credite)" + "value(?,?,?,?,?)";
				stmt = conn.prepareStatement(createString);
				System.out.print("How many courses would you like to add?");
				int nr = input.nextInt();
				input.nextLine();
				for (int i = 0; i < nr; i++) {
					System.out.println("Dati ID");
					int id = input.nextInt();
					input.nextLine();
					System.out.println("Dati materie");
					String materie = input.nextLine();
					System.out.println("Dati profesor");
					String profesor = input.nextLine();
					System.out.println("Dati sala");
					String sala = input.nextLine();
					System.out.println("Dati credite");
					int credite = input.nextInt();
					input.nextLine();
					stmt.setInt(1, id);
					stmt.setString(2, materie);
					stmt.setString(3, profesor);
					stmt.setString(4, sala);
					stmt.setInt(5, credite);
					stmt.execute();
				}
			}

			if (command.equals("read")) {
				System.out.println("What do you want to display?");
				String column = input.nextLine();
				String readString = "select " + column + " from curs";
				stmt = conn.prepareStatement(readString);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					if (column.charAt(0)=='*') {
						int id = rs.getInt("id");
						String materie = rs.getString("materie");
						String profesor = rs.getString("profesor");
						String sala = rs.getString("sala");
						int credite = rs.getInt("credite");
						System.out.println(id + " | " + materie + " | " + profesor + " | " + sala + " | " + credite);
					} else {
						String selected = rs.getString(column);
						System.out.println(selected);
					}
				}

			}

			if (command.equals("update")) {
				System.out.println("Which row would you like to update? (type the ID)");
				int id = input.nextInt();
				input.nextLine();
				String updateString = "update curs set id=?, materie=?, profesor=?,sala=?,credite=? where id=? ";
				stmt = conn.prepareStatement(updateString);
				System.out.println("Enter updated course id");
				int id_n = input.nextInt();
				input.nextLine();
				System.out.println("Enter updated course name");
				String materie_n = input.nextLine();
				System.out.println("Enter updated teacher name");
				String profesor_n = input.nextLine();
				System.out.println("Enter updated classroom name");
				String sala_n = input.nextLine();
				System.out.println("Enter updated credit amount");
				int credite= input.nextInt();
				input.nextLine();

				stmt.setInt(1, id_n);
				stmt.setString(2, materie_n);
				stmt.setString(3, profesor_n);
				stmt.setString(4, sala_n);
				stmt.setInt(5, credite);
				stmt.setInt(6,id);
				stmt.execute();
			}

			if (command.equals("delete")) {
				System.out.println("Which row would you like to delete? (type the ID)");
				int delete = input.nextInt();
				input.nextLine();
				String deleteString = "delete from curs where id= " + delete;
				stmt = conn.prepareStatement(deleteString);
				stmt.execute();
			}
			System.out.println("Chose action:");
			System.out.println("create/read/update/delete");
			command = input.nextLine();
		}
		conn.close();
	}

}

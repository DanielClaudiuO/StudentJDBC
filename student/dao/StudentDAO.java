package ro.emanuel.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.student.helpers.DBHelper;
import ro.emanuel.student.pojo.Student;

public class StudentDAO {
	//Student Data Access Object
	public static ArrayList<Student> getStudenti() throws SQLException{
		
		String select="select *from student";
		
		Connection con= DBHelper.getConnection();
		
		PreparedStatement stmt=con.prepareStatement(select);
		
		ArrayList<Student> result=new ArrayList<Student>();
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
			//citim din db coloane
			int id=rs.getInt("id");
			String nume=rs.getString("nume");
			String email=rs.getString("email");
			int varsta=rs.getInt("varsta");
			//cream obiect
			Student s=new Student(id,nume,email,varsta);
			result.add(s);
		}
		DBHelper.closeConnection();
		return result;
	
	}

	public static void createStudent(Student s) throws SQLException {
		String createString = "insert into student(nume,email,varsta)" + "value(?,?,?)";
		
		Connection con= DBHelper.getConnection();
		PreparedStatement stmt=con.prepareStatement(createString);
		stmt.setString(1, s.getNume());
		stmt.setString(2, s.getEmail());
		stmt.setInt(3, s.getVarsta());
		stmt.executeUpdate();
		
		DBHelper.closeConnection();
	}
	
	public static void updateStudent(Student s)throws SQLException{
		String update="update student set nume=?, email=?, varsta=? where id=?";
		Connection con= DBHelper.getConnection();
		PreparedStatement stmt=con.prepareStatement(update);
		stmt.setString(1, s.getNume());
		stmt.setString(2, s.getEmail());
		stmt.setInt(3, s.getVarsta());
		stmt.setInt(4, s.getId());
		stmt.executeUpdate();
		DBHelper.closeConnection();

	}
	
	
	public static void deleteStudent(Student s) throws SQLException{
		String delete="delete from student where id=?";
		Connection con=DBHelper.getConnection();
		PreparedStatement stmt=con.prepareStatement(delete);
		stmt.setInt(1, s.getId());
		stmt.executeUpdate();
		
		DBHelper.closeConnection();
		
	}
}

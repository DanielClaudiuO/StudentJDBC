package ro.emanuel.student;

import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.student.dao.StudentDAO;
import ro.emanuel.student.pojo.Student;

public class Main {

	public static void main(String[] args) throws SQLException {
		/* sa se implementeze op CRUD pentru  
		 * tabela Student folosind obiecte java
		 * */
		//obtinere conexiune
	
		
		//afisare studenti din DB
		ArrayList<Student> studenti=StudentDAO.getStudenti();
		for(Student s:studenti) {
			System.out.println(s.getId() + " | " + s.getNume() + " | " + s.getEmail() + " | " + s.getVarsta());
		}
		
		Student s= new Student(0,"s1","s1@.com",20);
		StudentDAO.createStudent(s);
		
		studenti=StudentDAO.getStudenti();
		for(Student st:studenti) {
			System.out.println(s.getId() + " | " + st.getNume() + " | " + st.getEmail() + " | " + st.getVarsta());
		}
		
	}

}

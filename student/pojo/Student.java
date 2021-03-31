package ro.emanuel.student.pojo;

public class Student {
	// POJO=Plain Old Java Object
	private int id;
	private String nume;
	private String email;
	private int varsta;

	public Student() {
		super();

	}

	public Student(int id, String nume, String email, int varsta) {
		super();
		this.id = id;
		this.nume = nume;
		this.email = email;
		this.varsta = varsta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

}

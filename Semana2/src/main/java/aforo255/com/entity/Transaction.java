package aforo255.com.entity;

import javax.validation.constraints.NotBlank;

public class Transaction {
	private int id;
	// Validacion Hibernate
	@NotBlank( message="No debereria ser vacio")
	private String description;

	public Transaction() {
	}
	

	public Transaction(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

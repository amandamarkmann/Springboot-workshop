package lexicon.se.workshopspringboot.entity;

import java.util.Objects;

public class AppUser {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;

	public String getFirstName() {
		return firstName;
	}
	
	

	public AppUser(int id, String firstName, String lastName, String email) {
		this.id = id;
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
	}

	
	
	public AppUser(String firstName, String lastName, String email) {
		this(0, firstName, lastName, email);
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(email, id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppUser other = (AppUser) obj;
		return Objects.equals(email, other.email) && id == other.id;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AppUser [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
	

	
	
}

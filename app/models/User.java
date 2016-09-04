package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.data.binding.As;
import play.data.validation.Email;
import play.data.validation.Password;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

@Entity
public class User extends Model {
	@Required
	public String name;
	@Required
	public String lastName;
	@Email
	@Required
	@Unique
	public String email;

	@Required
	@Password
	public String password;

	public boolean isAdmin;

	@Temporal(TemporalType.TIMESTAMP)
	@As("yyyy-MM-dd HH:mm:ss")
	public Date postedAt = new Date();

	public User(String email, String password, String lastName) {
		this.email = email;
		this.password = password;
		this.lastName = lastName;
	}

	public static User connect(String email, String password) {
        return find("byEmailAndPassword", email, password).first();
    }

	public static User verifyByEmail(String email) {
		return find("byEmail", email).first();
	}

	public static User verifyByCPF(String cpf) {
		return find("byCpf", cpf).first();
	}

	public static User verifyByInstitutionId(long id) {
		return find("byInstitutionId", id).first();
	}

	public String toString() {
		return email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getPostedAt() {
		if (postedAt == null) {
			postedAt = new Date();
		}
		return postedAt;
	}

	public void setPostedAt(Date postedAt) {
		this.postedAt = postedAt;
	}

}
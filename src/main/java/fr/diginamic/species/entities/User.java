package fr.diginamic.species.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "s_user")
public class User extends BaseEntity {

	@Column(name = "username", nullable = false)
	@NotEmpty
	private String userName;
	
	@Column(name = "password", nullable = false, length = 60)
	@NotEmpty
	private String password;
	
	@ManyToMany
	@JoinTable(name = "s_user_authority",
			joinColumns = @JoinColumn(name = "s_user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "authority_name", referencedColumnName = "name"))
	private List<Authority> authorities;

	public User() {
		super();
		authorities = new ArrayList<>();
	}

	public User(@NotNull String userName, String password) {
		this();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
}

package org.fkit.springboot.security.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_user")
public class FKUser implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	private String loginName;
	private String username;
	private String password;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<FKRole> getRoles() {
		return roles;
	}

	public void setRoles(List<FKRole> roles) {
		this.roles = roles;
	}

	@ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinTable(name="tb_user_role",
	joinColumns= {@JoinColumn(name="user_id")},
	inverseJoinColumns= {@JoinColumn(name="role_id")})
	private List<FKRole> roles;
	
	@Override
	public String toString() {
		return "User [id="+id+", loginName="+loginName+", username="+username+", password="+password+", roles="+roles+"]";
	}
}
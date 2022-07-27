package com.myspring.hungernet.Model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user")
public class User {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  @Column(name="name") private String name;
  @Column(name="role") private String userRole;
  @Column(name="email")private String email;
  

  public String getUserRole() {
	return userRole;
  }

  public void setUserRole(String userRole) {
	this.userRole = userRole;
  }


  public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
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
}

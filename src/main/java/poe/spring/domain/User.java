package poe.spring.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;

@OneToMany(mappedBy="user")
private List<Trajet> trajets;

private String login;
private String password;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public List<Trajet> getTrajets() {
	return trajets;
}
public void setTrajets(List<Trajet> trajets) {
	this.trajets = trajets;
}

}

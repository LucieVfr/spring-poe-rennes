package poe.spring.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Trajet {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;

@ManyToOne
private User user;

private String villeDepart;
private String villeArrivee;
private Date date;
private int prix;
private int nombrePlace;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getVilleDepart() {
	return villeDepart;
}
public void setVilleDepart(String villeDepart) {
	this.villeDepart = villeDepart;
}
public String getVilleArrivee() {
	return villeArrivee;
}
public void setVilleArrivee(String villeArrivee) {
	this.villeArrivee = villeArrivee;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public int getPrix() {
	return prix;
}
public void setPrix(int prix) {
	this.prix = prix;
}
public int getNombrePlace() {
	return nombrePlace;
}
public void setNombrePlace(int nombrePlace) {
	this.nombrePlace = nombrePlace;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

	
	
}

package code;

import java.io.Serializable;

public abstract class Met implements Serializable {
private String nom;
private boolean disponibilite;
protected int nb_calories;
private double prix;

public int getNb_calories() {
	return nb_calories;
}

public String getNom() {
	return nom;
}
public boolean getDisponibilite() {
	return disponibilite;
}
public abstract  int nb_calories() ;
public abstract  double Calculer_prix() ;
public double getPrix() {
	return prix;
}
public Met(String nom, boolean disponibilite, int nb_calories, double prix) {
	
	this.nom = nom;
	this.disponibilite = disponibilite;
	this.nb_calories = nb_calories;
	this.prix = prix;
}
public Met(String nom) {
	
	this.nom = nom;
	
}
public boolean equals(Met o) {
	return nom.equals(o.getNom());
}
public int hashCode() {
	return nom.hashCode();
}

}

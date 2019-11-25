package code;

import java.io.Serializable;

public class Supplement implements Serializable{
 private String nom;
 private double prix;
 private int nb_calories;
 
 
public Supplement(String nom, double prix, int nb_calories) {
	
	this.nom = nom;
	this.prix = prix;
	this.nb_calories = nb_calories;
}
public String getNom() {
	return nom;
}
public double getPrix() {
	return prix;
}
public int getNb_calories() {
	return nb_calories;
}

}

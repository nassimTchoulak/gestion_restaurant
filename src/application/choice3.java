package application;

import code.Boisson;

public class choice3 {
	private String nom;
	private String type;
	private String marque;
	private Boisson val;
	private double prix_i;
	private Boisson save;
	public choice3(Boisson b) {
		val=b;
		setNom(b.getNom());
		setType(b.getType().toString());
		setMarque(b.getMarque());
		setPrix_i(b.getPrix());
		save=b;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public double getPrix_i() {
		return prix_i;
	}
	public void setPrix_i(double prix_i) {
		this.prix_i = prix_i;
	}
	
	public Boisson getBoisson() {
		return save;
	}
}

package code;

import java.io.Serializable;

public class Boisson extends Met implements Serializable{
private String gout;
private String marque;
private Type_Boisson type;


public Boisson(String nom, boolean disponibilite, int nb_calories, double prix, String gout, String marque,
		Type_Boisson type) {
	super(nom, disponibilite, nb_calories, prix);
	this.gout = gout;
	this.setMarque(marque);
	this.setType(type);
}
public Boisson(String nom,Type_Boisson type) {
	super(nom);
	this.setType(type);
}
public double Calculer_prix(){
	return(getPrix());
	
}
public int nb_calories()
{
	return(getNb_calories());
}
public String getMarque() {
	return marque;
}
public void setMarque(String marque) {
	this.marque = marque;
}
public Type_Boisson getType() {
	return type;
}
public void setType(Type_Boisson type) {
	this.type = type;
}

}

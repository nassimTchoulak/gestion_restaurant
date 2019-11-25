package application;

import code.Repas;
import code.Type_Repas;

public class choice2 extends Repas{
	private String affs;
	private double prix_to;
	
	public choice2(String nom, boolean disponibilite, int nb_calories, double prix,double real, Type_Repas type,String s) {
		super(nom, disponibilite, nb_calories, prix, type);
		prix_to=real;
		affs=s;
		
		// TODO Auto-generated constructor stub
	}

	public String getAffs() {
		return affs;
	}

	public void setAffs(String affs) {
		this.affs = affs;
	}

	public double getPrix_to() {
		return prix_to;
	}

	public void setPrix_to(double prix_to) {
		this.prix_to = prix_to;
	}

}

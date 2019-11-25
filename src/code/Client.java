package code;
import java.io.Serializable;

public class Client implements Reduction,Serializable{
	private String nom;
	private String prenom;
	private String numero;
	private boolean etudiant;
	private int nb_commande;
	public int getNb_commande() {
		return nb_commande;
	}
	public Client(String nom, String prenom, String numero, boolean etudiant) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.etudiant = etudiant;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getNumero() {
		return numero;
	}
	public boolean isEtudiant() {
		return etudiant;
	}
public double reduction(){
	if(etudiant){
		return(0.08);
	}
	else return(0);
}
public boolean equals(Client k ) {
	if((this.nom==k.getNom() )&&(this.prenom==k.getPrenom())&&(this.numero==k.getNumero())) {
		return true;
	}
	else {
		return false;
	}
}
public int hashCode() {
	return (nom+prenom+numero).hashCode();
}
public void incr_nbcommande() {
	nb_commande++;
	
}
public void set_nb_cmd(int a) {
	nb_commande=a;
}
public int get_nb_cmd() {
	return nb_commande;
}

}

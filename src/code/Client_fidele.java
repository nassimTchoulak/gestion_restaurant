package code;

import java.io.Serializable;
import java.util.HashSet;

public class Client_fidele extends Client implements Serializable{
private String code_fidelite;
public HashSet<String> adresse;

public Client_fidele(String nom, String prenom, String numero, boolean etudiant, String code_fidelite) {
	super(nom, prenom, numero, etudiant);
	this.code_fidelite = code_fidelite;
}
public void ajouter_adresse(String adresse){
	try{
		this.adresse.add(adresse);
	}
	catch( Exception e){
		
	}
	
}
public void supp_adresse (String adresse){
	try {
		this.adresse.remove(adresse);
	}
	catch(Exception e){
		
	}
	
}
public void afficher_info()
{
	System.out.println("Le nom:"+getNom());
	System.out.println("Le prenom:"+getPrenom());
	System.out.println("Le numero:"+getNumero());
	System.out.println("Le code de fidelite:"+code_fidelite);
	if (isEtudiant()){
	System.out.println("est un etudiant");}
	
}
public double reduction(){
	if(getNb_commande()>=2){
		if(isEtudiant()){
			return(0.13);
		}
		else return(0.05);
	}
	else return(0);
}
public String get_codefid() {
	return code_fidelite;
}
public int hashCode() {
	return code_fidelite.hashCode();
}
public boolean equals(Client_fidele f) {
	if( this.code_fidelite==f.get_codefid()) {
		return true;
	}
	else {
		return false;
	}
}


}

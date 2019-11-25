package code;
import java.util.ArrayList;
import java.util.HashSet;
import java.io.Serializable;
import java.util.*;
public class Repas extends Met implements Serializable {
	private ArrayList <String> ingredients;
	public Type_Repas type;
	private HashSet <Supplement> supplements;
    public Type_Repas getType() {
		return type;
	}
	public void setType(Type_Repas type) {
		this.type = type;
	}
	
    
     public Repas(String nom, boolean disponibilite, int nb_calories, double prix, Type_Repas type) {
		super(nom, disponibilite, nb_calories, prix);
		this.type = type;
		this.supplements = new HashSet <Supplement>();
	}
     public Repas(String nom, Type_Repas type) {
 		super(nom);
 		this.type = type;
 		supplements = new HashSet <Supplement>();
 	}
	public double Calculer_prix(){
		Iterator<Supplement>it  = supplements.iterator();
		double p=0;
		Supplement h;
		while( it.hasNext()){
			h=it.next();
			p= p+ h.getPrix();
			System.out.println(p);
		}
		
		return(p+getPrix());
     }
	
	public void setlist(HashSet<Supplement> k) {
		this.supplements=k;
	}
     public int nb_calories()
     { 	if(supplements.isEmpty()) {
    	 return this.getNb_calories();
     }
    	 Iterator<Supplement> it  = supplements.iterator();
		int p=0;
		Supplement h;
		while( it.hasNext()){
			h=it.next();
			p= p+ h.getNb_calories();
		}
		return(p+getNb_calories());
    	 
     }
	
	public void afficher_ingredients(){
		System.out.println("Ingredients:");
		Iterator<String>it  = ingredients.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	public void add_supplement(Supplement s) {
		supplements.add(s);
	}
	public void ajouter_supp(String nom, double prix, int nb_calories){
        Supplement supp = new Supplement(nom,prix,nb_calories);
        try{
		supplements.add(supp);
        }
        catch(Exception e){
        	
        }
	}
	public void supprimer_supp(String nom, double prix, int nb_calories){
		Supplement supp = new Supplement(nom,prix,nb_calories);
		try{
		supplements.remove(supp);
		}
		catch(Exception e){
			
		}
		
	}
	public void ajouter_ingrd(String nom){
       
        try{
        this.ingredients.add(nom);
        }
        catch(Exception e){
        	
        }
	}
	public void supprimer_ingrd(String nom){
		
		try{
		this.ingredients.remove(nom);
		}
		catch(Exception e){
			
		}
		
	}
     
}

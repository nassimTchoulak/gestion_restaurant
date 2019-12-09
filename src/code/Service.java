package code;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;


public abstract class Service implements Reduction,Serializable{
	//protected String temps;
	protected LocalDateTime date;
	private ArrayList<Met> menu;
	protected int nb_personne;
	
	
	public int get_nb() {
		return nb_personne;
	}
	
	public ArrayList<Met> get_list(){
		return menu;
	}

	public void remove_menu(Met s) {
		menu.remove(s);
	}
	public LocalDateTime get_real_date() {
		return this.date;
	}
	
	public void set_nb(int y) {
		nb_personne=y;
	}
	public double reduction() {
		return 0.0;
	}
	
	public String get_date() {
		return this.date.toString();
	}
	
	abstract public double sur_plus(double prix);
	abstract public void confirmer() throws Exception;
	
	public Service(LocalDateTime d,int nb) {
		date=d;
		nb_personne=nb;
		menu = new ArrayList<Met>();
	}
	public double calculer_prix(){
		Iterator<Met> it  = this.menu.iterator();
		double p=0;
		Met s;
		System.out.println();
		while( it.hasNext()){
			s=it.next();
			p=p+s.Calculer_prix();
			System.out.println(p);
		}
		return(sur_plus(p));/// calcule prix avec surplus direct

	}

	public boolean add(Met m){
		return this.menu.add(m);
	}



}

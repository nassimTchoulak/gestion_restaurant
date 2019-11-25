package code;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;


public abstract class Service implements Reduction,Serializable{
	//protected String temps;
	protected LocalDateTime date;
	protected ArrayList<Met> menu;
	protected int nb_personne;
	
	
	public int get_nb() {
		return nb_personne;
	}
	
	public ArrayList<Met> get_list(){
		return menu;
	}
	public void add_met(Met s) {
		menu.add(s);
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
}

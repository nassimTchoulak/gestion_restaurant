package code;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Evenement extends Service implements Reduction, Serializable {
	private String decor;
	private Events ev;
	
	public Evenement(LocalDateTime d,int nb,String deco,Events e) {
		super(d,nb);
		decor=deco;
		ev=e;
	}
	public String get_deco() {
		return decor;
	}
	public String get_event() {
		return ev.toString();
	}
	
	public double reduction(){
		if ( nb_personne >49) {
			return 0.1;
		}
		return 0.0	;
		}
	public double sur_plus(double prix) {
		return prix*nb_personne;
	}
	 public void confirmer() throws Exception{
		if(( nb_personne <30)|(nb_personne>80)){
			throw new Eventpersonneexception();
		}
		else {
			
		}
	}
}

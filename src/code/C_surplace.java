package code;
import java.io.Serializable;
import java.time.LocalDateTime;

public class C_surplace extends Service implements Reduction,Serializable {
	public Table table;
	private Place endroit; // to enum inter or exter
	
	
	public C_surplace(LocalDateTime d,int nb,Table t,Place r) {
		super( d, nb);
		table=t;
		endroit=r;
		
	}
	
	public double reduction(){
		if(this.nb_personne>3) {
			return 0.07;
		}
		
			
		return 0.0	;
		}
	public double sur_plus(double prix) {
		if(endroit.equals(Place.exter)) {
			return prix*(1.05);
		}
		return prix;
	}
	 public void confirmer() throws Exception{
		LocalDateTime h = LocalDateTime.now();
		h.plusHours(1);
		if (h.compareTo( this.date  )>0) {
			throw new Dateexception();
		}
		else {
			if(this.date.getHour()>22) {
				throw new Dateexception();
			}
			else {
				
				if(this.table.isclear(this.date)) {
					table.use(this.date);
				}
				else {
					throw new Tableexception();
				}
				
				
				
			}
		}
		
	}
}

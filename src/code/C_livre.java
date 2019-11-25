package code;
import java.io.Serializable;
import java.time.LocalDateTime;

public class C_livre extends Service implements Reduction, Serializable {
	/**
	 * 
	 */
	
	private int distance;
	private String adress;
	
	public C_livre(LocalDateTime d,int nb,int dis, String adr) {
		super(d,nb);
		distance=dis;
		setAdress(adr);
	}
	
	
	public double reduction(){
		
		return 0.0	;}
	
	public double sur_plus(double prix) {
		return  prix+20*this.distance;
	}
	 public void confirmer() throws Exception{
		if(distance>20) {
			throw new Placeexception();
		}
		else {
			LocalDateTime h =LocalDateTime.now();
			if (  h.plusMinutes(90).compareTo( this.date) >0  ) {
				throw new Dateexception();
				
			}
			else {
				if(this.date.getHour()<10) {
					throw new Dateexception();
				}
			}
		}
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}
}

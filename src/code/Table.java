package code;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.TreeSet;


public class Table implements Comparable<Table>, Serializable {
	private int nb_place;
	public TreeSet<LocalDateTime> his = new TreeSet<LocalDateTime>();
	private int id;
	
	
	
	public Table(int d,int a) {
		id=d;
		setNb_place(a);
		
		//lastuse = LocalDateTime.now();
	}
	public int get_id() {
		return id;
	}
	public int compareTo(Table o) {
		
		int a = (o.get_id());
		if(a==id) {
			return 0;
		}
		if(a<id) {
			return 1;
		}
		else {
			return -1;
		}
		
	}
	public boolean equals(Table o) {
		if(id==o.get_id()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isclear(LocalDateTime res) {
		Iterator<LocalDateTime> it = his.iterator();
		boolean possible=true;
		LocalDateTime g=null;
		LocalDateTime g2=null;
		LocalDateTime pos=null;
		pos=res.plusHours(2);
		while((it.hasNext())&&(possible)) {
			g=it.next();
			g2=g.plusHours(2);
			g=g.minusHours(2);
			if(( g.compareTo(res)<0)&&(g2.compareTo(res)>0)) {
				possible=false;
			}
			
			
		}
		
			return possible;
	}
	
	public void use(LocalDateTime t) {
		LocalDateTime g;
		LocalDateTime now = LocalDateTime.now();
		Iterator<LocalDateTime> it = his.iterator();
		while((it.hasNext())) {
			g=it.next();
			if (g.compareTo(now)<0) {
				his.remove(g);
			}
		
		}
		his.add(t);
	}
	public int getNb_place() {
		return nb_place;
	}
	public void setNb_place(int nb_place) {
		this.nb_place = nb_place;
	}

}

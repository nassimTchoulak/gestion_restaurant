package code;

import java.io.Serializable;

public class Mois_jour implements Comparable<Mois_jour>, Serializable {
	public int mois;
	public int jour;
	public Mois_jour(int a,int b) {
		mois=a;
		jour=b;
	}
	public boolean equals(Object o) {
		if ( ( ((Mois_jour)o).mois==this.mois )&& ( ((Mois_jour)o).jour==this.jour ) ) {
			return true;
		}
		else {
			return false;
		}
	}
	public int compareTo(Mois_jour o) {
		if(this.mois==o.mois) {
			if(o.jour==this.jour) {
				return 0;
			}
			else {
				if(this.jour>o.jour) {
					return 1;
				}
				else {
					return -1;
				}
			}
		}
		else {
			if(this.mois>o.mois) {
				return 1;
			}
			else {
				return -1;
			}
		}
	}
}

package it.polito.tdp.libretto;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti ;
	
	public Libretto() {
		this.voti = new ArrayList<Voto>() ;
	}
		
	public void add(Voto v) {
		voti.add(v);
	}
	
	public List<Voto> cercaVoti(int punti){
		List<Voto> result = new ArrayList<Voto>();
		for(Voto v : this.voti) {
			if(v.getPunti()==punti)
				result.add(v);
		}
		return result;
	}

	
}

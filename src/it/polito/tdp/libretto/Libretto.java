package it.polito.tdp.libretto;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti ;
	
	public Libretto() {
		this.voti = new ArrayList<Voto>() ;
	}
		
	public boolean add(Voto v) {
		if(!this.esisteGiaVoto(v) && !this.votoConflitto(v)) {
			voti.add(v);
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<Voto> cercaVoti(int punti){
		List<Voto> result = new ArrayList<Voto>();
		for(Voto v : this.voti) {
			if(v.getPunti()==punti)
				result.add(v);
		}
		return result;
	}
	
	public Voto cercaEsame(String nomeEsame) {
		Voto voto = new Voto(0, nomeEsame, null);
		int pos = this.voti.indexOf(voto);
		if(pos==-1)
			return null;
		else
			return this.voti.get(pos);
		
		
	}
	
	public boolean esisteGiaVoto(Voto v) {
		int pos = this.voti.indexOf(v);
		if(pos==-1)
			return false;
		else 
			return (v.getPunti() == this.voti.get(pos).getPunti());
		}

	public boolean votoConflitto(Voto v) {
		int pos = this.voti.indexOf(v);
		if(pos==-1)
			return false;
		else 
			return (v.getPunti() != this.voti.get(pos).getPunti());
	}
	
	public String toString() {
		return this.voti.toString();
	}
	
	public Libretto librettoMigliorato() {
		Libretto nuovo = new Libretto();
		for(Voto v : this.voti) {
			nuovo.add(v.clone());
		}
		for(Voto v : nuovo.voti) {
			int punti = v.getPunti();
			if(punti<24)
				punti += 1;
			else if(punti <28)
				punti += 2;
			
			v.setPunti(punti);
		}
		
		return nuovo;
	}
	
	public void cancellaVotiScarsi() {
		List<Voto> cancellare = new ArrayList<Voto>();
		for(Voto v : this.voti) {
			if(v.getPunti()<24)
				cancellare.add(v);
		}
		
		this.voti.removeAll(cancellare);
	}
	
	
}

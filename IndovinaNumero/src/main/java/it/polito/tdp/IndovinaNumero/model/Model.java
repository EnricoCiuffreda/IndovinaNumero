package it.polito.tdp.IndovinaNumero.model;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Model {

	private int NMAX=100;
	private int TMAX=8;
	private int segreto;
	private int tentativiFatti;
	private boolean inGioco=false;
	private int numerominimo=0;
	private int numeromassimo;
	TreeMap <Integer,Integer> numeriinseriti= new TreeMap <Integer,Integer>();
	private Set <Integer> tentativi;
	
	public Model() {
		this.tentativiFatti = 0;
		this.inGioco = false;
	}
	
	public void nuovaPartita() {
		this.segreto =(int) (Math.random()*NMAX)+1;
    	this.tentativiFatti=0;
    	this.inGioco=true;
    	this.tentativi=new HashSet <Integer>();
    	
	}
	
	public int tentativo(int tentativo) {
		//controllo se la partita è in corso
		if(!inGioco) {
			throw new IllegalStateException("la partita è già terminata\n");
		}
		//controllo input
		if(!tentativoValido(tentativo)) {
			throw new InvalidParameterException("Devi inserire un numero che non hai ancora utilizzato tra 1 e " + NMAX + "\n");
		}
		//il tentativo è valido --> possiamo "provarlo"
		
		this.tentativiFatti++;
		this.tentativi.add(tentativo);
		
		if(this.tentativiFatti ==TMAX) {
			this.inGioco=false;
		}
		
		if(tentativo==this.segreto)
		{
			this.inGioco=false;
			return 0;
		}
		if(tentativo<this.segreto)
		{
			return -1;
		}
		else 
			return 1;
		
	}
	
	
	private boolean tentativoValido(int tentativo) {
		if(tentativo <1 || tentativo > NMAX ) {
				return false;
			}
			else {
				if(this.tentativi.contains(tentativo)) {
					return false;
				}
				return true;
			}
		}

	public int getSegreto() {
		return segreto;
	}

	public void setSegreto(int segreto) {
		this.segreto = segreto;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}

	public void setTentativiFatti(int tentativiFatti) {
		this.tentativiFatti = tentativiFatti;
	}

	public int getTMAX() {
		return TMAX;
	}

	public void setTMAX(int tMAX) {
		TMAX = tMAX;
	}
	
		
	
	
	
}


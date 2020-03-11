package it.polito.tdp.IndovinaNumero;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {
	private int NMAX;
	private int TMAX;
	private int segreto;
	private int tentativiFatti;
	private boolean inGioco=false;
	private int numerominimo=0;
	private int numeromassimo;
	TreeMap <Integer,Integer> numeriinseriti= new TreeMap <Integer,Integer>();


	
    @FXML
    private TextField txtminimo;

    @FXML
    private TextField txtmassimo;

    @FXML
    private HBox boxdifficolta;

    @FXML
    private Button btnfacile;

    @FXML
    private Button btnmedio;

    @FXML
    private Button btndifficile;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtrisultato;

    @FXML
    private Button btnnuova;

    @FXML
    private TextField txtrimasti;

    @FXML
    private HBox layoutTentativo;

    @FXML
    private TextField txttentativi;

    @FXML
    private Button btnprova;
    
    @FXML
    private ProgressBar brprg;
    

    @FXML
    private Button btnabbandona;

    @FXML
    void doNuova(ActionEvent event) {
    	//gestione inizio nuova partita
    	this.tentativiFatti=0;
    	this.inGioco=true;
    	txtrisultato.clear();
    	brprg.setProgress(0);
    	txttentativi.clear();
    	boxdifficolta.setDisable(false);
    }
    
    
    
    @FXML
    void doTentativo(ActionEvent event) {
    	int tentativo;
    	String tmp=txttentativi.getText();
    	try {
    	tentativo=Integer.parseInt(tmp);
    	} catch (NumberFormatException e) {
    		txtrisultato.appendText("Devi inserire un numero!\n");
    		return;
    	}
    	if(numeriinseriti.containsKey(tentativo)) {
    		txtrisultato.appendText("NON PUOI INSERIRE LO STESSO NUMERO DUE VOLTE\n");
    		return;
    	}
    	tentativiFatti++;
    	if(tentativo==this.segreto)
    	{
    		txtrisultato.appendText("HAI VINTO!!!HAI UTILIZZATO "+this.tentativiFatti+" tentativi!");
    		layoutTentativo.setDisable(true);
    		this.inGioco=false;
    		brprg.setProgress(1);
    		btnnuova.setDisable(false);
    	 	txtminimo.clear();
        	txtmassimo.clear();
    		return;
    	}
    	if(tentativiFatti==TMAX) {
    		txtrisultato.appendText("HAI PERSO. IL NUMERO SEGRETO ERA: "+this.segreto);
    		layoutTentativo.setDisable(true);
    		this.inGioco=false;
    		btnnuova.setDisable(false);
    	 	txtminimo.clear();
        	txtmassimo.clear();
    		return;
    	}
    	//informare utente se tentativo è troppo alto o troppo basso
    	if(tentativo<this.segreto) {
    		if(tentativo<=numeromassimo && tentativo>=numerominimo) {
    		txtminimo.setText(Integer.toString(numerominimo));
    		numerominimo=tentativo;
    		}
    		txtrisultato.appendText("tentativo troppo basso\n");
    	}
    		
    	else {
    		if(tentativo<=numeromassimo && tentativo>=numerominimo)
    		{
    		numeromassimo=tentativo;
    		txtmassimo.setText(Integer.toString(numeromassimo));
    		}
    		txtrisultato.appendText("tentativo troppo alto\n");
    		
    	}
    	txtrimasti.setText(Integer.toString(TMAX-tentativiFatti));
    	double percentuale=(double) 1/TMAX;
    	brprg.setProgress(percentuale*tentativiFatti);
    	numeriinseriti.put(tentativo, tentativo);
    
    }
    
    
    @FXML
    void dodifficile(ActionEvent event) {
    	NMAX=1000;
    	TMAX=10;
    	numerominimo=0;
    	numeromassimo=NMAX;
    	txtrimasti.setText(Integer.toString(TMAX));
    	this.segreto =(int) (Math.random()*NMAX)+1;
    	this.tentativiFatti=0;
    	this.inGioco=true;
    	layoutTentativo.setDisable(false);
    	brprg.setDisable(false);
    	
    	txtrisultato.clear();
    	txtrimasti.setText(Integer.toString(TMAX));
    	brprg.setProgress(0);
    	txttentativi.clear();
    	boxdifficolta.setDisable(true);
    	btnnuova.setDisable(true);
    	txtminimo.setText(Integer.toString(numerominimo));
    	txtmassimo.setText(Integer.toString(numeromassimo));

    }

    @FXML
    void dofacile(ActionEvent event) {
    	NMAX=10;
    	TMAX=4;
    	numerominimo=0;
    	numeromassimo=NMAX;
    	txtrimasti.setText(Integer.toString(TMAX));
    	this.segreto =(int) (Math.random()*NMAX)+1;
    	this.tentativiFatti=0;
    	this.inGioco=true;
    	layoutTentativo.setDisable(false);
    	brprg.setDisable(false);
    	
    	txtrisultato.clear();
    	txtrimasti.setText(Integer.toString(TMAX));
    	brprg.setProgress(0);
    	txttentativi.clear();
    	boxdifficolta.setDisable(true);
    	btnnuova.setDisable(true);
    	txtminimo.setText(Integer.toString(numerominimo));
    	txtmassimo.setText(Integer.toString(numeromassimo));
    }

    @FXML
    void domedio(ActionEvent event) {
    	NMAX=100;
    	TMAX=7;
    	numerominimo=0;
    	numeromassimo=NMAX;
    	txtrimasti.setText(Integer.toString(TMAX));
    	this.segreto =(int) (Math.random()*NMAX)+1;
    	this.tentativiFatti=0;
    	this.inGioco=true;
    	layoutTentativo.setDisable(false);
    	brprg.setDisable(false);
    	
    	txtrisultato.clear();
    	txtrimasti.setText(Integer.toString(TMAX));
    	brprg.setProgress(0);
    	txttentativi.clear();
    	boxdifficolta.setDisable(true);
    	btnnuova.setDisable(true);
    	txtminimo.setText(Integer.toString(numerominimo));
    	txtmassimo.setText(Integer.toString(numeromassimo));
    	}
    
    @FXML
    void doabbandona(ActionEvent event) {
    	txtrisultato.clear();
    	txtrimasti.clear();
    	txttentativi.clear();
    	brprg.setProgress(0);
    	layoutTentativo.setDisable(true);
    	brprg.setDisable(true);
    	btnnuova.setDisable(false);
    	txtminimo.clear();
    	txtmassimo.clear();
    	
    }

    @FXML
    void initialize() {
        assert txtrisultato != null : "fx:id=\"txtrisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnnuova != null : "fx:id=\"btnnuova\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtrimasti != null : "fx:id=\"txtrimasti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert layoutTentativo != null : "fx:id=\"layoutTentativo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txttentativi != null : "fx:id=\"txttentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnprova != null : "fx:id=\"btnprova\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

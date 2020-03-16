package it.polito.tdp.IndovinaNumero;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ResourceBundle;
import java.util.TreeMap;

import it.polito.tdp.IndovinaNumero.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {
	private Model model;
	

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
    void doNuova(ActionEvent event) {
    	//comunico inizio nuova partita
    	this.model.nuovaPartita();
    	txtrisultato.clear();
    	txttentativi.clear();
    	layoutTentativo.setDisable(false);
    	txtrimasti.setText(Integer.toString(this.model.getTMAX()-this.model.getTentativiFatti()));
    }
    
    
    
    @FXML
    void doTentativo(ActionEvent event) {
    	String ts=txttentativi.getText();
    	int tentativo;
    	try {
    		tentativo= Integer.parseInt(ts);
    	} catch(NumberFormatException e) {
    		txtrisultato.appendText("Devi inserire un numero!\n");
    		return;
    	}
    	int risultato=-1;
    	try {
    	   risultato= this.model.tentativo(tentativo);
    	} catch(IllegalStateException se) {
    		txtrisultato.appendText(se.getMessage());
    		return;
    		
    	} catch(InvalidParameterException pe){
    		txtrisultato.appendText(pe.getMessage());
    		return;
    	}
    	
    	if(risultato==0) {
    		txtrisultato.appendText("HAI VINTO con " + this.model.getTentativiFatti() +"tentativi\n");
    	}
    	else if(risultato==-1) {
    		txtrisultato.appendText("TENTATIVO TROPPO BASSO\n");
    	}
    	else {
    		txtrisultato.appendText("TENTATIVO TROPPO ALTO\n");
    	}
    	txtrimasti.setText(Integer.toString(this.model.getTMAX()-this.model.getTentativiFatti()));
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
    
    public void setModel(Model model) {
    	this.model=model;
    }
}

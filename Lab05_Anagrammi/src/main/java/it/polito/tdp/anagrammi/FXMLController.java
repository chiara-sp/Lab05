package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorrette;

    @FXML
    private TextArea txtSbagliate;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {

      txtCorrette.clear();
      txtSbagliate.clear();
      
      String input=txtInput.getText();
      if(input.length()<2) {
    	  txtCorrette.setText("inserire una parola più lunga");
      }else {
    	  Set<String> totAnagrammi= model.calcolaAnagrammi(input);
    	  for(String s: totAnagrammi) {
    		  if(model.isCorretto(s))
    			  txtCorrette.appendText(s+"\n");
    		  else
    			  txtSbagliate.appendText(s+"\n");
    	  }
      }
    }

    @FXML
    void doReset(ActionEvent event) {

    	txtCorrette.clear();
    	txtSbagliate.clear();
    	txtInput.clear();
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorrette != null : "fx:id=\"txtCorrette\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtSbagliate != null : "fx:id=\"txtSbagliate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
		
	}
}

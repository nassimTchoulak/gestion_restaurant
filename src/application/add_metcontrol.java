package application;

import code.ESImeal;
import code.IEsiMeal;
import code.Type_Boisson;
import code.Type_Repas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class add_metcontrol {

	
	private IEsiMeal me;
	
	public void set_all(IEsiMeal s) {
		me=s;
	}
	
    @FXML
    private TextField supp_nom;

    @FXML
    private TextField supp_calori;

    @FXML
    private TextField supp_prix;

    @FXML
    private TextField rep_name;

    @FXML
    private TextField rep_type;

    @FXML
    private TextField rep_prix;

    @FXML
    private TextField bosi_nom;

    @FXML
    private TextField bois_marqu;

    @FXML
    private TextField bois_prix;

    @FXML
    private TextField bois_calori;

    @FXML
    private TextField bois_type;

    @FXML
    private Button add_rep;

    @FXML
    private Button bois_add;

    @FXML
    private Button add_supp;

    @FXML
    void add_repas(ActionEvent event) {
    	me.add_repas(this.rep_name.getText(),true,100,Double.parseDouble(this.rep_prix.getText()),Type_Repas.valueOf(this.rep_type.getText()), 25);
    }

    @FXML
    void ajouter_boisson(ActionEvent event) {
    	me.add_boisson(this.bosi_nom.getText(),Integer.parseInt(this.bois_calori.getText()), Double.parseDouble(this.bois_prix.getText()),"good",this.bois_marqu.getText(),Type_Boisson.valueOf(this.bois_type.getText()), 25);
    }

    @FXML
    void ajouter_supp(ActionEvent event) {
    	System.out.println("supplement ajoute");
    	me.add_supp(this.supp_nom.getText(),Double.parseDouble(this.supp_prix.getText()),Integer.parseInt(this.supp_calori.getText()));
    }

}

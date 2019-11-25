package application;

import java.io.IOException;
import java.net.URL;

import javafx.collections.ObservableList;
import java.util.ResourceBundle;

import code.Client;
import code.Client_fidele;
import code.ESImeal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class connectcontrol implements Initializable {

	
		private ESImeal data;

	    @FXML
	    private Button connect_cf;

	    @FXML
	    private TextField name;

	    @FXML
	    private TextField prename;

	    @FXML
	    private TextField codef;

	    @FXML
	    private TextField num;

	    @FXML
	    private RadioButton radio;

	    @FXML
	    private Button inscrire;

	    @FXML
	    private Button connect1;

	    @FXML
	    void connection_f(ActionEvent event) {
	    	Client_fidele t ;
	    	t=this.data.cliens.get(this.codef.getText());
	    	if(t==null) {
	    		this.repss.setText("compte non valide");
	    	}
	    	else {
	    		try {
					commandes cs = new commandes(data,t);
					this.t.close();
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					
				}
	    	
	    	}
	    	
	    }

	    @FXML
	    private Label repss;
	    @FXML
	    void connection_n(ActionEvent event)  {
	    	Client t ;
	    	t=this.data.cliens_normal.get(this.name.getText()+this.prename.getText()+this.num.getText());
	    	if(t==null) {
	    		this.repss.setText("compte non valide");
	    	}
	    	else {
	    		try {
					commandes cs = new commandes(data,t);
					this.t.close();
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					
				}
	    	}
	    }

	    @FXML
	    void firstconnect(ActionEvent event) {
	    		if((!this.name.getText().isEmpty())&&(!this.prename.getText().isEmpty())&&(!this.num.getText().isEmpty())){
	    			
	    			if(this.data.cliens_normal.get(name.getText()+prename.getText()+num.getText())==null) {
	    				Client you;
	    				you=new Client(name.getText(), prename.getText(),num.getText(),this.radio.isSelected());
	    				this.data.cliens_normal.put(name.getText()+prename.getText()+num.getText(), you);
	    				try {
							commandes fr =new commandes(this.data,you);
							this.t.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	    			}
	    			else{
	    				this.repss.setText("compte existant");
	    			}
	    			
	    		}
	    		
	    		
	    }
	    
	    
	    private connect t;
	    public void set_all(ESImeal s,connect t) {
	    	this.data=s;
	    	this.t=t;
	    }
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.repss.setText("  ");
	}

}

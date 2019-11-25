package application;

import java.io.IOException;

import code.Client;
import code.ESImeal;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class commandes extends Stage {
	Parent root ;
	public commandes(ESImeal me,Client c) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("commandes.fxml"));
		//Parent root = (Parent) FXMLLoader.load(getClass().getResource("commandes.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		
		//FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("commandes.fxml")); 
	 	commandecontrol controller = fxmlLoader.<commandecontrol>getController();
		//controller.set_all(me, c);
	 	controller.set_all(me, c);
		Scene sene = new Scene(root);
	//	controller.set_all(me, c);
		this.setScene(sene);
		this.setTitle("adding forum");
		this.show();
		//commandecontrol controller = 
		
		//controller.set_all(me, c);
		
	}
}

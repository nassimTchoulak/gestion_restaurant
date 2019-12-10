package application;

import java.io.IOException;

import code.ESImeal;
import code.IEsiMeal;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class add_met extends Stage{
	Parent root ;
	public add_met(IEsiMeal c) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add_met.fxml"));
		//Parent root = (Parent) FXMLLoader.load(getClass().getResource("commandes.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		
		//FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("commandes.fxml")); 
	 	add_metcontrol controller = fxmlLoader.<add_metcontrol>getController();
		//controller.set_all(me, c);
	 	controller.set_all(c);
		Scene sene = new Scene(root);
	//	controller.set_all(me, c);
		this.setScene(sene);
		this.setTitle("connection");
		this.show();
}
}

package application;

import code.Boisson;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;

public class choice4 extends choice3 {
	private Button press;
	private TableView<choice3> ty;
	public choice4(Boisson b,TableView<choice3> t) {
		super(b);
		ty=t;
		press= new Button("ajouter");
		press.setOnMouseClicked((MouseEvent e) -> {
			ty.getItems().add(this);
			
		// raisin table event 
			 Event.fireEvent(ty, new MouseEvent(MouseEvent.MOUSE_CLICKED,
		               0, 0, 0, 0, MouseButton.PRIMARY, 1,
		               true, true, true, true, true, true, true, true, true, true, null));
			
			
	});
		// TODO Auto-generated constructor stub
	}
	public Button getPress() {
		return press;
	}
	public void setPress(Button press) {
		this.press = press;
	}

}

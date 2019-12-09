package application;

import java.util.Iterator;
import java.util.Map.Entry;


import org.controlsfx.control.CheckComboBox;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import code.ESImeal;
import code.Repas;
import code.Supplement;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.scene.input.MouseButton;

public class choice1 {
	
	private String nom;
	private double prix;
	private double init_prix ;
	public static AnchorPane val;
	private Button bt; 
	private TableView<choice1> vv;
	private TableView<choice2> to;
	private ESImeal sss;
	
	
	public CheckComboBox<String> supps; 
	public String getNom() {
		return nom;
	}
	public Button getBt() {
		return bt;
	}
	public double getPrix() {
		return prix;
	}
	
	/*public Repas getVal() {
		return val;
	}
	public Button getBt() {
		return bt;
	} */
	public CheckComboBox<String> getSupps(){
		return supps;
	} 
	public choice1(Repas r,ESImeal s,TableView<choice1> v,TableView<choice2> ml) {
		/*val = new Repas(r.getNom(),true,r.nb_calories(),r.getPrix(),r.type);
		/**/
		vv=v;
		to=ml;
		sss=s;

		supps = new CheckComboBox<String>();
		//supps.getItems().addAll("gggg"); 
		for (Entry<String,Supplement> entry : s.getSupps().entrySet())
		{	 	 
					supps.getItems().add(entry.getKey()) ; 
					
	
		}
		nom= r.getNom();
		bt = new Button();
		bt.setText("ajouter");
		prix = r.getPrix();
		init_prix=prix;
		
		
	
		supps.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
		     public void onChanged(ListChangeListener.Change<? extends String> c) {
		         ObservableList<String> ls = supps.getCheckModel().getCheckedItems();
		         Iterator it = ls.iterator();
		         //prix=init_prix;
		         prix = init_prix;
		         
		         System.out.println(supps.getCheckModel().getCheckedItems()); 
		         while(it.hasNext()) {
		        	prix=prix+(sss.getSupps().get(it.next())).getPrix();
		         }
		         
		         
		         Event.fireEvent(vv, new MouseEvent(MouseEvent.MOUSE_CLICKED,
			               0, 0, 0, 0, MouseButton.PRIMARY, 1,
			               true, true, true, true, true, true, true, true, true, true, null));
		     }
		 });
		
		
		bt.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				System.out.println("submitted");
				
				System.out.println(prix);
				
				
				choice2 at = new choice2(nom,true,15,(sss.getMenu().get(nom)).getPrix(),prix, (sss.getMenu().get(nom)).type,(supps.getCheckModel().getCheckedItems()).toString());
				
				
				ObservableList<String> ls = supps.getCheckModel().getCheckedItems();
		         Iterator<String> it = ls.iterator();
		         //prix=init_prix;
		         
		         String ss;
		         System.out.println(supps.getCheckModel().getCheckedItems()); 
		         while(it.hasNext()) {
		        	 ss= it.next();
		        	at.ajouter_supp(ss,(sss.getSupps().get(ss)).getPrix(), (sss.getSupps().get(ss)).getNb_calories());
		         }
		         ml.getItems().add(at);
		         Event.fireEvent(vv, new MouseEvent(MouseEvent.MOUSE_CLICKED,
			               0, 0, 0, 0, MouseButton.PRIMARY, 1,
			               true, true, true, true, true, true, true, true, true, true, null));
			}
		});
		
	
	}
	
	
	
	
	
	
	
}
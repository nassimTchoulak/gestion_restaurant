package application;



import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import code.C_surplace;
import code.Client;
import code.Commande;
import code.ESImeal;
import code.Evenement;
import code.Met;
import code.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class listofcontrol implements Initializable {

    @FXML
    private AnchorPane mybase;
    private ESImeal me;
    private Client cc;

    private TableView<choice5> pt;
    
    
    public void set_all(ESImeal s,Client c) {
    	me=s;
    	cc=c;
    	pt.getItems().addAll(this.get_data());
    	
    }
    
    public ObservableList<choice5> get_data(){
    	ObservableList<choice5> ls = FXCollections.observableArrayList();
    	Iterator<Commande> it = me.getCom().iterator();
    	Commande verif;
    	while(it.hasNext()) {
    		verif =it.next();
    		if( verif.getClient().equals(this.cc))
    		ls.add( new choice5(verif));
    	}
    	
		
		return ls;
    }
    
    public class choice5 {
    	private String type;
    	private String date;
    	private String mets;
    	private double price;
    	
    	public choice5(Commande now) {
    		Service s =now.getService();
    		setDate(s.get_date());
    		this.setPrice(now.prix_a_payer(now.getClient()));
    		String ss="";
    		Iterator<Met> it = s.get_list().iterator();
    		while(it.hasNext()) {
    			ss=ss+" "+it.next().getNom();
    		}
    		this.mets=ss;
    		if(s instanceof Evenement) {
    			setType("evenement");
    		}
    		else {
    			if(s instanceof C_surplace) {
    				setType("sur place");
    			}
    			else {
    				setType("livr�");
    			}
    		}
    		
    	}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getMets() {
			return mets;
		}

		public void setMets(String mets) {
			this.mets = mets;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		TableColumn<choice5,String> c1 = new TableColumn<>("type");
		c1.setMinWidth(150);
		c1.setCellValueFactory(new PropertyValueFactory("type"));
		
		TableColumn<choice5,String> c2 = new TableColumn<>("date");
		c2.setMinWidth(150);
		c2.setCellValueFactory(new PropertyValueFactory("date"));
		
		TableColumn<choice5,String> c3 = new TableColumn<>("mets");
		c3.setMinWidth(150);
		c3.setCellValueFactory(new PropertyValueFactory("mets"));
		
		TableColumn<choice5,Double> c4 = new TableColumn<>("prix");
		c4.setMinWidth(150);
		c4.setCellValueFactory(new PropertyValueFactory("price"));
		this.pt = new TableView<>();
		
		pt.getColumns().addAll(c1,c2,c3,c4);
		
		this.mybase.getChildren().add(pt);
		
		
	}
    
    
    
    
    
}

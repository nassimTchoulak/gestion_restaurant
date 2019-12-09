package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import code.C_surplace;
import code.Client;
import code.Client_fidele;
import code.Commande;
import code.ESImeal;
import code.Evenement;
import code.Met;
import code.Service;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class homecontrol implements Initializable{
	
	public ESImeal esi = new ESImeal();
	
	TableView<choice6> info ;
	
	private ObservableList<Client> ll = FXCollections.observableArrayList();
	
    @FXML
    private AnchorPane cliens;
    
    @FXML
    private Button new_cmd;

    @FXML
    private AnchorPane commandes;
    
    @FXML
    private ComboBox<String> filter;

    @FXML
    void new_click(ActionEvent event) throws IOException {
    	connect fg = new connect(esi);
    	//commandes hh = new commandes(esi , new Client("me", "tchoulak"," 0158", false));
    	
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		esi.set_all_fortest();		
		info = new TableView<choice6>();
		this.cliens.getChildren().add(info);
		TableColumn<choice6,String> c1 = new TableColumn<>("date");
		c1.setMinWidth(100);
		c1.setCellValueFactory(new PropertyValueFactory("date"));
		
		TableColumn<choice6,String> c2 = new TableColumn<>("type");
		c2.setMinWidth(100);
		c2.setCellValueFactory(new PropertyValueFactory("type"));
		
		TableColumn<choice6,String> c3 = new TableColumn<>("client");
		c3.setMinWidth(100);
		c3.setCellValueFactory(new PropertyValueFactory("client"));
		
		TableColumn<choice6,String> c4 = new TableColumn<>("menu");
		c4.setMinWidth(100);
		c4.setCellValueFactory(new PropertyValueFactory("mets"));
		

		TableColumn<choice6,Double> c5 = new TableColumn<>("prix");
		c5.setMinWidth(100);
		c5.setCellValueFactory(new PropertyValueFactory("price"));
		
		filter.getItems().add("tout");
		filter.getItems().add("en attente");
		filter.getItems().add("effectu�es");
		//("tout","en attente","effectu�es");
		filter.setValue("tout");
		
		
		info.setItems( this.get_cmd(filter.getSelectionModel().getSelectedItem()) );
		
		
		info.getColumns().addAll(c1,c2,c3,c4,c5);
	}

	public ObservableList<Client> get_date(){
		Client ssl;
		ObservableList<Client> ls = FXCollections.observableArrayList();
		for (Entry<String, Client_fidele> entry : esi.getCliens().entrySet())
		{	 	 
					ssl = entry.getValue();  
					ls.add(ssl);
					
	
		}
		return ls;
	}
	public ObservableList<choice6> get_cmd(String s){
    	ObservableList<choice6> ls = FXCollections.observableArrayList();
    	Iterator<Commande> it = this.esi.getCom().iterator();
    	Commande verif;
    	LocalDateTime now = LocalDateTime.now();
    	if( s=="tout") {
    		while(it.hasNext()) {
        		verif =it.next();
        		
        		ls.add( new choice6(verif));
        	}
    	}
    	else {
    		if(s=="en attente") {
    			while(it.hasNext()) {
    	    		verif =it.next();
    	    		if(now.compareTo(verif.getService().get_real_date())<0)
    	    		ls.add( new choice6(verif));
    	    	}
    		}
    		else {
    			while(it.hasNext()) {
    	    		verif =it.next();
    	    		if(now.compareTo(verif.getService().get_real_date())>0)
    	    		ls.add( new choice6(verif));
    	    	}
    		}
    	}
    	
    	
		
		return ls;
    }
	
	
	 @FXML
	    void ichanged(ActionEvent event) {
		 this.info.getItems().clear();
		 	this.info.getItems().addAll(this.get_cmd(this.filter.getSelectionModel().getSelectedItem()));
	    }
	
	
	 @FXML
	    private Button save;

	    @FXML
	    private Button load;

	    @FXML
	    void load_on(ActionEvent event) {
	    	esi = esi.load_all();
;	    }

	    

	    @FXML
	    void save_on(ActionEvent event) {
	    	esi.save_all();
	    }
	    
	    public class choice6 {
	    	private String type;
	    	private String date;
	    	private String mets;
	    	private double price;
	    	private String client;
	    	
	    	public choice6(Commande now) {
	    		client = now.getClient().getNom();
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

			public String getClient() {
				return client;
			}

			public void setClient(String client) {
				this.client = client;
			}

			
	    }
	    @FXML
	    private Button add_some;

	    @FXML
	    void add_some(ActionEvent event) {
	    	try {
				add_met rty = new add_met(this.esi);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    

}




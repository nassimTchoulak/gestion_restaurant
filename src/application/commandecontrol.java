package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.ResourceBundle;
import java.util.Set;

import org.controlsfx.control.CheckComboBox;

import code.Boisson;
import code.Client;
import code.Client_fidele;
import code.Commande;
import code.ESImeal;
import code.Events;
import code.Met;
import code.Repas;
import code.Service;
import code.Supplement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class commandecontrol implements Initializable{


    @FXML
    private TextField date;

    

    @FXML
    private TextField nbpers;

    

    @FXML
    private Label psr;

    

    @FXML
    private Label r;



    @FXML
    private Label ap;

    

    @FXML
    private TabPane tabcontrol;

    @FXML
    private Tab evenement;

    @FXML
    private TextField dec;

    @FXML
    private ComboBox<String> occ;

    @FXML
    private AnchorPane place;

    @FXML
    private ComboBox<String> table_int;

    @FXML
    private ComboBox<String> inter;

    @FXML
    private Tab livre;

    @FXML
    private TextField dis;

    @FXML
    private ComboBox<String> adr;

    

    @FXML
    private Button but_valid;

    @FXML
    private Label my_answer;

    @FXML
    private Label lbl_client;
	
	
	
	
	/// olds

    @FXML
    private AnchorPane comma;
    @FXML
    private AnchorPane location15;

    @FXML
    private AnchorPane destination;
    
    @FXML
    private AnchorPane boissondes;

    @FXML
    private AnchorPane bois_source;
    
    @FXML
    private Button del_rep;

    @FXML
    private Button del_bt;
    @FXML
    private Button calc_fact;
    private  TableView<choice3> in;
    
    private TableView<choice4> sel;
    
    
    private TableView<choice1> tt;
    
    private TableView<choice2> rt;

    public ESImeal esi = new ESImeal();
    
    public Client you;
    public Service now;
    public Commande cmdnow;
    
    
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		 tt  = new TableView<>();
		 rt = new TableView<>();
		 sel  = new TableView<>();
		 in = new TableView<>();
		 
		 esi.set_all_fortest();
		 //del_bt= new Button();
		 //del_rep = new Button();
		// this.lbl_client.setText(this.you.getNom());
		 		
		 
		 TableColumn<choice3,String> t1= new TableColumn<>("nom");
		 t1.setMinWidth(150);
		 t1.setCellValueFactory(new PropertyValueFactory("nom"));
		 
		 TableColumn<choice3,String> t2= new TableColumn<>("marque");
		 t2.setMinWidth(050);
		 t2.setCellValueFactory(new PropertyValueFactory("marque"));
		 
		 TableColumn<choice3,String> t3= new TableColumn<>("prix");
		 t3.setMinWidth(50);
		 t3.setCellValueFactory(new PropertyValueFactory("prix_i"));
		 
		 
		 TableColumn<choice3,String> t4= new TableColumn<>("type");
		 t4.setMinWidth(50);
		 t4.setCellValueFactory(new PropertyValueFactory("type"));
		 
		 
		 TableColumn<choice4,String> ts1= new TableColumn<>("nom");
		 ts1.setMinWidth(100);
		 ts1.setCellValueFactory(new PropertyValueFactory("nom"));
		 
		 TableColumn<choice4,String> ts2= new TableColumn<>("marque");
		 ts2.setMinWidth(100);
		 ts2.setCellValueFactory(new PropertyValueFactory("marque"));
		 
		 TableColumn<choice4,String> ts3= new TableColumn<>("prix");
		 ts3.setMinWidth(50);
		 ts3.setCellValueFactory(new PropertyValueFactory("prix_i"));
		 
		 
		 TableColumn<choice4,String> ts4= new TableColumn<>("type");
		 ts4.setMinWidth(100);
		 ts4.setCellValueFactory(new PropertyValueFactory("type"));
		 
		 
		 TableColumn<choice4,Button> ts5 = new TableColumn<>("add");
		 ts5.setMinWidth(100);
		 ts5.setCellValueFactory(new PropertyValueFactory("press"));
		 
		 
		 
		 
		 
		 
		TableColumn<choice1,String> c1= new TableColumn<>("Nom");
		 c1.setMinWidth(100);
		 c1.setCellValueFactory(new PropertyValueFactory("nom"));
		 
		 TableColumn<choice1,Button> c2= new TableColumn<>("commander");
		 c2.setMinWidth(50);
		 c2.setCellValueFactory(new PropertyValueFactory("bt"));
		 
		 TableColumn<choice1,CheckComboBox<String>> c3= new TableColumn<>("supplements");
		 c3.setMinWidth(150);
		 c3.setCellValueFactory(new PropertyValueFactory("supps"));
		 
		 TableColumn<choice1,Double> c4= new TableColumn<>("prix");
		 c4.setMinWidth(100);
		 c4.setCellValueFactory(new PropertyValueFactory("prix"));
		 
		 
		 TableColumn<choice2,String> cs1= new TableColumn<>("nom");
		 cs1.setMinWidth(120);
		 cs1.setCellValueFactory(new PropertyValueFactory("nom"));
		 
		 TableColumn<choice2,String> cs2= new TableColumn<>("supplements");
		 cs2.setMinWidth(170);
		 cs2.setCellValueFactory(new PropertyValueFactory("affs"));
		 
		 TableColumn<choice2,Double> cs3= new TableColumn<>("prix");
		 cs3.setMinWidth(50);
		 cs3.setCellValueFactory(new PropertyValueFactory("prix_to"));
		 
		 
		 
		 
		 rt.getColumns().addAll(cs1,cs2,cs3);
		 
		 tt.setItems( get_repas() ); 
		 sel.setItems(get_bois());
		 sel.getColumns().addAll(ts1,ts2,ts3,ts4,ts5);
		 in.getColumns().addAll(t4,t1,t2,t3);
		 System.out.println("gggg");
		 
	//	 rt.getColumns().addAll(cs1,cs2,cs3,cs4);
		 
		 tt.getColumns().addAll(c1,c3,c4,c2);
		 this.location15.getChildren().add(0, tt);;
		 this.destination.getChildren().add(rt);
		 this.bois_source.getChildren().add(sel);
		 this.boissondes.getChildren().add(in);
		 
		 tt.setMinWidth(400);
		 tt.setMaxHeight(250);
		 
		 rt.setMinWidth(400);
		 rt.setMaxHeight(250);
		 in.setMinWidth(400);
		 in.setMaxHeight(250);
		 sel.setMinWidth(400);
		 sel.setMaxHeight(250);
		 
		 
		 
		 
		 
		 in.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					
					in.getColumns().get(0).setVisible(false);
					in.getColumns().get(0).setVisible(true);
					in.getColumns().get(1).setVisible(false);
					in.getColumns().get(1).setVisible(true);
					in.getColumns().get(2).setVisible(false);
					in.getColumns().get(2).setVisible(true);
					
					e.consume();
					
				}
			}); 
		 
		 
		tt.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					System.out.println("hello world");
					tt.getColumns().get(0).setVisible(false);
					tt.getColumns().get(0).setVisible(true);
					tt.getColumns().get(1).setVisible(false);
					tt.getColumns().get(1).setVisible(true);
					tt.getColumns().get(2).setVisible(false);
					tt.getColumns().get(2).setVisible(true);
					e.consume();
				}
			});
		
	}
	
	public ObservableList<choice1> get_repas(){
		Repas ssl;
		
		ObservableList<choice1> ls = FXCollections.observableArrayList();
		for (Entry<String,Repas> entry : esi.menu.entrySet())
		{	 	 
					ssl = entry.getValue();  
					ls.add( new choice1(ssl,esi,tt,rt));
					System.out.println("1111");
	
		}
		return ls;
	}
	public ObservableList<choice4> get_bois(){
       Boisson ssl;
		
		ObservableList<choice4> ls = FXCollections.observableArrayList();
		for (Entry<String, Boisson> entry : esi.bois_v.entrySet())
		{	 	 
					ssl = entry.getValue();  
					ls.add( new choice4(ssl,in));
					
	
		}
		return ls;
		
		
		
	}
	@FXML
	public void del_rep(ActionEvent event) {
		if(!rt.getSelectionModel().getSelectedIndices().isEmpty()) {
			System.out.println("mmmmmm");
			ObservableList<choice2> ls = rt.getItems();
			ObservableList<choice2> ls2 = rt.getSelectionModel().getSelectedItems();
			
			ls.removeAll(ls2);
			rt.setItems(ls);
			Event.fireEvent(rt, new MouseEvent(MouseEvent.MOUSE_CLICKED,
		               0, 0, 0, 0, MouseButton.PRIMARY, 1,
		               true, true, true, true, true, true, true, true, true, true, null));
		}
		System.out.println("ttttttt");
		
	}
	@FXML
	public void del_boi(ActionEvent event) {
		if(!in.getSelectionModel().getSelectedIndices().isEmpty()) {
			System.out.println("uuuuuu");
			ObservableList<choice3> ls = in.getItems();
			ObservableList<choice3> ls2 = in.getSelectionModel().getSelectedItems();
			
			ls.removeAll(ls2);
			in.setItems(ls);
			Event.fireEvent(in, new MouseEvent(MouseEvent.MOUSE_CLICKED,
		               0, 0, 0, 0, MouseButton.PRIMARY, 1,
		               true, true, true, true, true, true, true, true, true, true, null));
		}
		System.out.println("ttttttt");
	}
	
	//private ArrayList<Met> men = new ArrayList<Met>();
	private boolean cando = false;
    @FXML
    void calculer_facture(ActionEvent event) {

    	String[] tab ;
    	ArrayList<Met> men = new ArrayList<Met>();
    	men.clear();
    	for (choice3 c1 : in.getItems()) {
    	    // do something with c
    		System.out.println(c1.getNom());
    		men.add(esi.bois_v.get(c1.getNom()));
    	}
    	Repas rrt;
    	
    	for (choice2 c : rt.getItems()) {
    		HashSet<Supplement> todo = new HashSet<Supplement>();
    	    // do something with c
    		rrt =new Repas(c.getNom(),true, esi.menu.get(c.getNom()).getNb_calories(), esi.menu.get(c.getNom()).getPrix(),esi.menu.get(c.getNom()).getType());
    		System.out.println(c.getNom()+" "+c.getAffs().substring(1,c.getAffs().length()-1));
    		todo.clear();
    		tab = c.getAffs().substring(1,c.getAffs().length()-1).split(Pattern.quote(","));
    		for(int i=0;i<tab.length;i++) {
    			tab[i]=tab[i].replace(" ","");
    			System.out.println("/"+tab[i]+"/");
    			//System.out.println(this.esi.supps.get(tab[i]).getNom());
    			if(!tab[i].isEmpty()) {
    				System.out.println(tab[i]);
    				todo.add(this.esi.supps.get(tab[i]));
    			}
    			//rrt.add_supplement(this.esi.supps.get(tab[i]));
    			//todo.add(this.esi.supps.get(tab[i]));
    			//System.out.println(tab[i]);
    			
    		}
    		rrt.setlist(todo);
    		men.add(rrt);
    	}
    	Service ee;
    	if(this.tabcontrol.getSelectionModel().getSelectedIndex()==0) {
    		
    		
    		 
    		ee = this.esi.com_event(this.date.getText(),Integer.parseInt(this.nbpers.getText()),this.dec.getText(),Events.valueOf(this.occ.getSelectionModel().getSelectedItem()));
    		
    		
    	} 
    	else {
    		if(this.tabcontrol.getSelectionModel().getSelectedIndex()==1) {
    			if(this.inter.getSelectionModel().getSelectedIndex()==0) {
    				ee=this.esi.com_C_surplace(this.date.getText(),Integer.parseInt(this.nbpers.getText()),Integer.parseInt(this.table_int.getSelectionModel().getSelectedItem()),"inter");
    	    		
    			}
    			else {
    				ee=this.esi.com_C_surplace(this.date.getText(),Integer.parseInt(this.nbpers.getText()),Integer.parseInt(this.table_int.getSelectionModel().getSelectedItem()),"exter");
    	    		
    			}
    		}
    		else {//(this.inter.getSelectionModel().getSelectedItem()).substring(0,4)
    			System.out.println("cmd");
    			ee=this.esi.com_C_livre(this.date.getText(),Integer.parseInt(this.nbpers.getText()),Integer.parseInt(this.dis.getText()),this.adr.getSelectionModel().getSelectedItem());
    		}
    		
    	}
    	
    	ee.get_list().addAll(men);
    	
    	System.out.println(this.date.getText());
    	Iterator<Met> iy = ee.get_list().iterator();
    	Met var;
    	while(iy.hasNext()) {
    		var = iy.next();
    		System.out.print(var.getNom()+"+");
    		System.out.println(var.Calculer_prix());
    	}
    	
    	this.cmdnow = new Commande(esi.nbcmd,you,ee);
    	esi.nbcmd++;
    	//System.out.println(cmdnow.calculer_prix());
     	this.r.setText( String.valueOf(cmdnow.calculer_reduction(you))); 
    	this.ap.setText(String.valueOf(cmdnow.prix_a_payer(you)));
    	this.psr.setText(String.valueOf(cmdnow.calculer_prix()));
    	this.my_answer.setText("veuillez entrez votre commande");
    
    
    }
    @FXML
    void check_out(ActionEvent event) {
    	this.calculer_facture(null);
    	
    	my_answer.setText(esi.confirmation_msg(cmdnow.getid(),you,cmdnow.getService()));
    }
    
    public void set_all(ESImeal u,Client r) {
    	this.esi=u;
    	you=r;
    	
    	//this.esi.save_all();
    	
    	//this.esi = esi.load_all();
    	
    	this.lbl_client.setText("bonjour"+"  "+r.getNom()+"   "+ r.getPrenom());
    	this.occ.getItems().addAll("anniversaire","diplome","mariage","retraite");
    	this.inter.getItems().addAll("interieur","exterieur");
    	this.my_answer.setText("veuillez introduir votre commande");;
    	Iterator<String> it;
    	try{ it=((Client_fidele)r).adresse.iterator();
    		while(it.hasNext()) {
    			this.adr.getItems().add(it.next());
    		}
    	}
    	catch(Exception e) {
    		
    	}
    	//this.adr.getItems()
    	System.out.println("done here");
     	Set s = esi.tab.keySet();
    	Iterator<Integer> it4 = s.iterator();
    	while(it4.hasNext()) {
    		this.table_int.getItems().add(it4.next().toString());
    	}   
    }
   
    @FXML
    private Button inscrire;

    @FXML
    private TextField registration;
    
    @FXML
    private Button visualcmd;
    @FXML
    void sinscrire(ActionEvent event) {
    	String s =this.registration.getText();
    	if(this.esi.sincrire(you,you.getNom(), you.getPrenom(), you.getNumero(), you.isEtudiant(), s)){
    		this.my_answer.setText("vous etes maintenant un client fidele");
    		you = esi.cliens.get(s);
    	}
    }
    @FXML
    void allcmd(ActionEvent event) {
    	try {
			listof ty = new listof(this.esi,this.you);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}

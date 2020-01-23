package code;


import java.util.*;


 public interface IEsiMeal {


     void add_repas(String nom, boolean disponibilite, int nb_calories, double prix, Type_Repas type,int quant );

     void add_boisson(String nom, int nb_calories, double prix, String gout, String marque,Type_Boisson type,int quant);

     void add_supp(String nom, double prix, int nb_calories);

     boolean sincrire(Client r,String nom, String prenom, String numero, boolean etudiant, String code_fidelite);



     Service com_event(String d,int nb,String deco,Events e);


     Service com_C_surplace(String d,int nb,int t,String r);

     Service com_C_livre(String d,int nb,int dis, String adr);

    ///connexion to enter
     Client connexion(String nom, String prenom, String numero, boolean etudiant);

     Client_fidele connect_get_client_fid(String code);
    /// reponse sur la confirmation

     String confirmation_msg(int id,Client cll,Service s);

     void save_in_files_cliens_fidele();

     void load_out_files_cliens_fidele();

     void save_all();

     IEsiMeal load_all();


     void save_in_files_cliens_n();

     void load_out_files_cliens_n();

     double mnt_reduction(); // total stat

    ;
     int nb_cmd();

     double montant_tot(); // total stat

     double mnt_reduction_fidele();; // total stat
     double mnt_reduction_Etudiant();// total stat


     String getClientLePlusCommande (); //total_stat

     String getClientLePlusred ();

     String getClientLeMoinsCommande (); //total_stat

     void set_all_fortest(); // init method

     ArrayList<Repas> get_repass();

     TreeSet<Commande> getCom();

     void setCom(TreeSet<Commande> com);

     TreeSet<Mois_jour> getEventdates();

     void setEventdates(TreeSet<Mois_jour> eventdates);

     int getNbcmd();

     void setNbcmd(int nbcmd);

     HashMap<String, Client_fidele> getCliens();

     void setCliens(HashMap<String, Client_fidele> cliens);

     HashMap<String, Client> getCliens_normal();

     void setCliens_normal(HashMap<String, Client> cliens_normal);

     HashMap<String, Repas> getMenu();

     void setMenu(HashMap<String, Repas> menu);

     HashMap<String, Boisson> getBois_v();

     void setBois_v(HashMap<String, Boisson> bois_v);

     HashMap<String, Supplement> getSupps();

     void setSupps(HashMap<String, Supplement> supps);

     HashMap<String, Integer> getQuant_menu();

     void setQuant_menu(HashMap<String, Integer> quant_menu);

     HashMap<String, Integer> getQuant_bois();

     void setQuant_bois(HashMap<String, Integer> quant_bois);

     HashMap<String, Events> getEvents();

     void setEvents(HashMap<String, Events> events);

     HashMap<String, Type_Boisson> getBois();

     void setBois(HashMap<String, Type_Boisson> bois);

     HashMap<String, Type_Repas> getReps();

     void setReps(HashMap<String, Type_Repas> reps);

     HashMap<String, Place> getPlace();

     void setPlace(HashMap<String, Place> place);

     TreeMap<Integer, Table> getTab();

     void setTab(TreeMap<Integer, Table> tab);
}



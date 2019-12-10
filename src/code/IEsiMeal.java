package code;


import java.util.*;


public interface IEsiMeal {

    // valueof used here
    public void add_repas(String nom, boolean disponibilite, int nb_calories, double prix, Type_Repas type,int quant );

    public void add_boisson(String nom, int nb_calories, double prix, String gout, String marque,Type_Boisson type,int quant);

    public void add_supp(String nom, double prix, int nb_calories);

    public boolean sincrire(Client r,String nom, String prenom, String numero, boolean etudiant, String code_fidelite);


    /// making services
    public Service com_event(String d,int nb,String deco,Events e);


    public Service com_C_surplace(String d,int nb,int t,String r);

    public Service com_C_livre(String d,int nb,int dis, String adr);

    ///connexion to enter
    public Client connexion(String nom, String prenom, String numero, boolean etudiant);

    public Client_fidele connect_get_client_fid(String code);
    /// reponse sur la confirmation

    public String confirmation_msg(int id,Client cll,Service s);

    public void save_in_files_cliens_fidele();

    public void load_out_files_cliens_fidele();

    public void save_all();

    public ESImeal load_all();


    public void save_in_files_cliens_n();

    public void load_out_files_cliens_n();

    public double mnt_reduction();

    ;
    public int nb_cmd();

    public double montant_tot();

    public double mnt_reduction_fidele();;
    public double mnt_reduction_Etudiant();;


    public String getClientLePlusCommande ();

    public String getClientLePlusred ();

    public String getClientLeMoinsCommande ();

    public void set_all_fortest(); // init method

    public ArrayList<Repas> get_repass();

    public TreeSet<Commande> getCom();

    public void setCom(TreeSet<Commande> com);

    public TreeSet<Mois_jour> getEventdates();

    public void setEventdates(TreeSet<Mois_jour> eventdates);

    public int getNbcmd();

    public void setNbcmd(int nbcmd);

    public HashMap<String, Client_fidele> getCliens();

    public void setCliens(HashMap<String, Client_fidele> cliens);

    public HashMap<String, Client> getCliens_normal();

    public void setCliens_normal(HashMap<String, Client> cliens_normal);

    public HashMap<String, Repas> getMenu();

    public void setMenu(HashMap<String, Repas> menu);

    public HashMap<String, Boisson> getBois_v();

    public void setBois_v(HashMap<String, Boisson> bois_v);

    public HashMap<String, Supplement> getSupps();

    public void setSupps(HashMap<String, Supplement> supps);

    public HashMap<String, Integer> getQuant_menu();

    public void setQuant_menu(HashMap<String, Integer> quant_menu);

    public HashMap<String, Integer> getQuant_bois();

    public void setQuant_bois(HashMap<String, Integer> quant_bois);

    public HashMap<String, Events> getEvents();

    public void setEvents(HashMap<String, Events> events);

    public HashMap<String, Type_Boisson> getBois();

    public void setBois(HashMap<String, Type_Boisson> bois);

    public HashMap<String, Type_Repas> getReps();

    public void setReps(HashMap<String, Type_Repas> reps);

    public HashMap<String, Place> getPlace();

    public void setPlace(HashMap<String, Place> place);

    public TreeMap<Integer, Table> getTab();

    public void setTab(TreeMap<Integer, Table> tab);
}



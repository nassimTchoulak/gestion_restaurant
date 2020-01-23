package code;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class EsiLoader_Serial implements IEsi_loader {

    public void save_in_files_cliens_fidele(IEsiMeal ssl1) {
        BufferedWriter out =null;
        String ss="";
        String cl;
        Iterator it ;
        int i;
        Client_fidele ssl;

        try {
            out= new BufferedWriter(new FileWriter("cliens.txt"));
            for (Map.Entry<String, Client_fidele> entry : ssl1.getCliens().entrySet())
            {	 	 cl = entry.getKey();
                ssl = entry.getValue();

                ss= ssl.getNom()+ "-"+ssl.getPrenom() +"-"+ssl.getNumero() +"-"+ssl.isEtudiant() +"-"+ssl.getNb_commande()+"-"+ssl.get_codefid() +"|";
                it = ssl.adresse.iterator();
                while(it.hasNext()) {
                    ss=ss+it.next()+"*";
                }
                out.write(ss);
                out.newLine();

            }
            out.flush();
            out.close();

        } catch (IOException e) {


            //e.printStackTrace();
        }

    }

    public void load_out_files_cliens_fidele(IEsiMeal ssl) {
        try {
            String ss;
            String[] grad;
            String[] object;
            String[] adr;
            Client_fidele kf;
            int i;
            ArrayList<String> ls = new ArrayList<String>();
            BufferedReader in = new BufferedReader(new FileReader("cliens.txt"));
            ssl.getCliens().clear();
            ss=in.readLine();
            while(ss!=null) {
                grad=ss.split(Pattern.quote("|"));
                object=grad[0].split(Pattern.quote("-"));
                ls.clear();
                try {
                    adr=grad[1].split(Pattern.quote("*"));
                    for(i=0;i<adr.length;i++) {
                        ls.add(adr[i]);
                    }

                }
                catch(Exception e) {

                }
                kf= new Client_fidele(object[0],object[1],object[2],Boolean.parseBoolean(object[3]),object[5]) ;
                kf.adresse.addAll(ls);
                kf.set_nb_cmd(Integer.parseInt(object[4]));
                ssl.getCliens().put(object[4],kf );


                ss=in.readLine();
            }



        }
        catch(Exception e) {

        }
    }

    public void save_all(IEsiMeal ssl) {


        ObjectOutputStream out;
        try {
            out= new ObjectOutputStream( new BufferedOutputStream(new FileOutputStream (new File("esimeal.txt") )));

            out.writeObject(ssl);
            out.flush();
            out.close();

        } catch (IOException e) {


            //e.printStackTrace();
        }
    }
    public IEsiMeal load_all(IEsiMeal ssl) {

        ObjectInputStream in;


        ssl.getCliens_normal().clear();
        try {
            in = new ObjectInputStream( new BufferedInputStream(new FileInputStream (new File("esimeal.txt") )));

            ssl=((ESImeal)in.readObject());

            return (ssl);





        }
        catch(Exception e) {
            return null;
        }





    }











    public void save_in_files_cliens_n(IEsiMeal ssl1) {

        String ss="";
        String cl;

        int i;
        Client ssl;
        ObjectOutputStream out;
        try {
            out= new ObjectOutputStream( new BufferedOutputStream(new FileOutputStream (new File("client_normal.txt") )));

            for (Map.Entry<String, Client> entry : ssl1.getCliens_normal().entrySet())
            {	 	 cl = entry.getKey();
                ssl = entry.getValue();
                out.writeObject(ssl);


            }
            out.flush();
            out.close();

        } catch (IOException e) {


            //e.printStackTrace();
        }

    }

    public void load_out_files_cliens_n(IEsiMeal ssl1) {
        ObjectInputStream in;
        Client ssl;
        String key;
        ssl1.getCliens_normal().clear();
        try {
            in = new ObjectInputStream( new BufferedInputStream(new FileInputStream (new File("client_normal.txt") )));
            while(true) {
                ssl=((Client)in.readObject());
                ssl1.getCliens_normal().put(ssl.getNom()+ssl.getPrenom()+ssl.getNumero(), ssl);
            }




        }
        catch(Exception e) {

        }
    }

}

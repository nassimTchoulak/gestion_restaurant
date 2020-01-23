package code;

public interface IEsi_loader {
     void save_in_files_cliens_fidele(IEsiMeal ssl) ;
     void load_out_files_cliens_fidele(IEsiMeal ssl) ;
     void save_all(IEsiMeal ssl);
    IEsiMeal load_all(IEsiMeal ssl);
     void save_in_files_cliens_n(IEsiMeal ssl);
    void load_out_files_cliens_n(IEsiMeal ssl);
}

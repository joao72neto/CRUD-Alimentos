import java.sql.SQLException;

import entidades.Alimentos;
import entidades.Estilo;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Estilo.l();
        System.out.printf("%12sCRUD de Alimentos\n", "");
        Estilo.l();

        Alimentos prod = new Alimentos("Maçã", "fruta", 100, 2.3, "12-12-2030", "12-12-2024",
                                        3, "apple", "Brasil","23423423423");
        
        
                                        
       prod.cadastrar(prod);
      
       
    }
}
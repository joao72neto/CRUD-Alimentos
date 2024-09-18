import java.sql.SQLException;

import entidade.Alimentos;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Alimentos prod = new Alimentos("Maçã", "fruta", 100, 2.3, "12-12-2030", "12-12-2024",
                                        3, "apple", "Brasil","23423423423");


        prod.confirmarDados();
        prod.cadastrar();
        
    
    }
}
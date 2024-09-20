import java.sql.SQLException;

import java.sql.Date;
import entidades.Alimentos;
import entidades.Estilo;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Estilo.l();
        System.out.printf("%12sCRUD de Alimentos\n", "");
        Estilo.l();

        //Guardando as datas
        Date fabriacao = Date.valueOf("2030-12-12");
        Date validade = Date.valueOf("2024-12-12");

        //Inserindo os dados para a tabela de alimentos
        Alimentos prod = new Alimentos("Maçã", 
                                       "fruta", 
                                        100, 
                                        2.3, 
                                        validade, 
                                        fabriacao,
                                        3, 
                                        "apple", 
                                        "Brasil",
                                        "23423423423");
        

        //Cadastrando os dados inseridos
        prod.cadastrar(prod);

        //Visualizando os dados cadastrados
        prod.visualizar();
      
       
    }
}
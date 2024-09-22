import java.sql.SQLException;

import java.sql.Date;
import entidades.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Estilo.l(129);
        System.out.printf("%55sCRUD de Alimentos\n", "");
        Estilo.l(129);

        //Guardando as datas
        Date fabriacao = Date.valueOf("2035-08-12");
        Date validade = Date.valueOf("2024-01-20");

        //Criando uma tabela de alimentos
        Alimentos prod = new Alimentos();

        //Inserindo os dados na tabela
        prod.setAlm_nome("Melão");
        prod.setAlm_categoria("Fruta");
        prod.setAlm_codigo_barras("123124124124");
        prod.setAlm_data_validade(validade);
        prod.setAlm_data_fabricacao(fabriacao);
        prod.setAlm_pais_origem("Brasil");
        prod.setAlm_peso_por_unidade(5);
        prod.setAlm_quantidade_estoque(20);
        prod.setAlm_marca("Do jão");
        prod.setAlm_preco(1.2);

        //Instanciando o CRUD
        Crud c = new Crud();

    
        //Cadastrando a tabela de alimentos no banco de dados
        c.visualizar(prod);
        //c.atualizar(prod, "alm_nome", "Banana", 3);
             
       
    }
}
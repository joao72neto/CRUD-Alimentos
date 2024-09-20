package entidades;

import java.sql.*;
import java.util.ArrayList;

import oracle.jdbc.internal.ResultSetCache;

public class Conexao {

    //Atributos
    protected ArrayList<String> columnNames;


    //Método que estabelece conexão com o banco de dados
    public Connection getConexao() throws ClassNotFoundException, SQLException{

        //Constantes para a conexão
        final String  DRIVER = "oracle.jdbc.driver.OracleDriver";
        final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        final String USER = "C##JAVA";
        final String PASSWORD = "123";

        //Carregando a classe do driver da oracle
        Class.forName(DRIVER);

        //Conetando com o banco de dados
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

        //Retornando a conexão
        return con;
    }

    public ArrayList<String> getColunas(){
        
        //Alocando memória para o ArrayList
        columnNames = new ArrayList<>();

        //Pegando os dados do banco de dados
        DatabaseMetaData metaData = getConexao().getMetaData();

        //Pegando os nomes das colunas
        try(ResultSet rs = metaData.getColumns(null, null, |"alimentos", null)){

            while(rs.next()){
                String columnName = rs.getString("COLUMN_NAME");
                columnNames.add(columnName);
            }
        }

        //Retornano o nomes das colunas
        return columnNames;

    }
}

package entidades;

import java.sql.*;

public class Conexao {

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

}

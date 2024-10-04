package entidades;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Tabelas extends Conexao {

    //Métodos a serem implementados
    public abstract String getNomeTabela();
    

    //Método que pega todos os valores das colunas de uma tabela
    public ArrayList<Object> getValorColunas(Object obj) {

        ArrayList<Object> valorColunas = new ArrayList<>();

        //Guardando os atributos declarados
        Field[] campos = obj.getClass().getDeclaredFields();
        for (Field campo : campos){
            campo.setAccessible(true);
            try{
                valorColunas.add(campo.get(obj));
            }catch(IllegalAccessException e){
                System.out.println("Erro: " + e.toString());
            }  
        }

        return valorColunas;
    }

    //Método que retorna todos os nomes das colunas de uma tabela
    public ArrayList<String> getNomeColunas(Object obj) {
        
        ArrayList<String> nomeColunas = new ArrayList<>();

        //Guardando os atributos declarados
        Field[] campos = obj.getClass().getDeclaredFields();
        for (Field campo : campos){
            campo.setAccessible(true);
            nomeColunas.add(campo.getName());
        }
        
        return nomeColunas;
    }

    //Função que retorna todos os ids do banco de dados
    public ArrayList<Integer> getIds(Tabelas tabela) throws ClassNotFoundException, SQLException{
        
        //Objetos
        ArrayList<Integer> ids = new ArrayList<>();
        Connection con = getConexao();

        //Preparando o comando SQL
        String nome_col_id = tabela.getNomeColunas(tabela).get(0);

        String sql = "select " + nome_col_id + " from " + tabela.getNomeTabela();
        PreparedStatement comando = con.prepareStatement(sql);

        //Capturando todos os resultados
        ResultSet resultado = comando.executeQuery();

        while (resultado.next()) {
            ids.add(resultado.getInt(1));
        }

        //Retornando um array de ids
        return ids;
    }
}

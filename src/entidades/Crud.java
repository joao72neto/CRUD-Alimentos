package entidades;

import java.sql.*;
import java.util.ArrayList;

public class Crud extends Conexao{
    

    //Atributos da classe
    public void cadastrar(Tabelas tabela) throws ClassNotFoundException, SQLException{
        //Realizando a conexão com o banco de dados
        Connection con = getConexao();
        
        //Pegando iformações sobre a tabela
        //ArrayList<String> nomeColunas = getNomeColunas(tabela);
        ArrayList<Object> valorColunas = tabela.getValorColunas(tabela);
        String nomeTabela = tabela.getNomeTabela();

        //Inserindo dados de forma dinâmica
        StringBuilder insert = new StringBuilder("insert into " + nomeTabela + " values (");

        /*//Colocando o nome das colunas
        for(int i=0; i < nomeColunas.size(); i++){
            insert.append(nomeColunas.get(i));

            if(i < nomeColunas.size()-1){
                insert.append(", ");
            }
        }*/

        //adicionando os valores a serem inseridos
        for(int i=0; i < valorColunas.size(); i++){

            //Adicionando os valores
            if(valorColunas.get(i) instanceof Date){
                insert.append("to_date('" + valorColunas.get(i) + "', 'YYYY-MM-DD')");

            }else if(valorColunas.get(i) instanceof Double || valorColunas.get(i) instanceof Integer){
                insert.append(valorColunas.get(i));

            }else{
                insert.append("'" + valorColunas.get(i) + "'");
            }

            //Adicionando a vírgula que separa os valores
            if(i < valorColunas.size()-1){
                insert.append(", ");
            }
        }

        //Fechando o insert
        insert.append(")");

        //Guardando a SQL gerado
        String sql = insert.toString();

        PreparedStatement comando = con.prepareStatement(sql);


        //Executando a instruções SQL
        comando.execute();

        //Fechando as conexões
        comando.close();
        con.close();

    }

    //Métodos capaz de visualizar os dados da tabela
    public void visualizar(Tabelas tabela) throws ClassNotFoundException, SQLException{

        Connection con = getConexao();

        //Preparando o comando SQL
        String sql = "select * from " + tabela.getNomeTabela();
        PreparedStatement comando = con.prepareStatement(sql);

        //Capturando todos os resultados
        ResultSet resultado = comando.executeQuery();
        
        //Variáveis necessárias para mostrar os dados
        ArrayList<ArrayList<Object>> dados = new ArrayList<>();
        ArrayList<String> nomeColunas = tabela.getNomeColunas(tabela);

        //Organizando os dados em uma matriz
        while (resultado.next()) {
            
            ArrayList<Object> linha = new ArrayList<>();

            for(int i=1; i <= nomeColunas.size(); i++){

                Object valor = resultado.getObject(i);

                if (valor instanceof java.util.Date){
                    Timestamp timestamp = (Timestamp) valor;
                    valor = timestamp.toLocalDateTime().toLocalDate().toString();
                }


                linha.add(valor);
            }

            dados.add(linha);

        }

        /* 
        //Exibindo o título
        for(String nome : nomeColunas){
            System.out.printf("%-10s | ", nome);
        }*/

        //Exibindo todos os dados
        for(ArrayList<Object> l : dados){

            for(Object d : l){
                System.out.printf("%-10s | ", d);
            }
            
            System.out.println();
        }


        //Fechando as conexões
        comando.close();
        resultado.close();
        con.close();


    }

    //Sobrecarga do método visulizar, caso o usuário queira filtrar por id
    public void visualizar(Tabelas tabela, int id) throws ClassNotFoundException, SQLException{

        Connection con = getConexao();

        //Preparando o comando SQL
        String sql = "select * from " + tabela.getNomeTabela() + " where " + tabela.getNomeColunas(tabela).get(0) + " = " + id;
        PreparedStatement comando = con.prepareStatement(sql);

        //Capturando todos os resultados
        ResultSet resultado = comando.executeQuery();
        
        //Variáveis necessárias para mostrar os dados
        ArrayList<ArrayList<Object>> dados = new ArrayList<>();
        ArrayList<String> nomeColunas = tabela.getNomeColunas(tabela);

        //Organizando os dados em uma matriz
        while (resultado.next()) {
            
            ArrayList<Object> linha = new ArrayList<>();

            for(int i=1; i <= nomeColunas.size(); i++){

                Object valor = resultado.getObject(i);

                if (valor instanceof java.util.Date){
                    Timestamp timestamp = (Timestamp) valor;
                    valor = timestamp.toLocalDateTime().toLocalDate().toString();
                }


                linha.add(valor);
            }

            dados.add(linha);

        }

        /* 
        //Exibindo o título
        for(String nome : nomeColunas){
            System.out.printf("%-10s | ", nome);
        }*/

        //Exibindo todos os dados
        for(ArrayList<Object> l : dados){

            for(Object d : l){
                System.out.printf("%-10s | ", d);
            }
            
            System.out.println();
        }


        //Fechando as conexões
        comando.close();
        resultado.close();
        con.close();
    }

    //Modificar um dado existente
    public void atualizar(Tabelas tabela, int coluna, Object valor, int id) throws ClassNotFoundException, SQLException{

       Connection con = getConexao();

        //Preparando o comando SQL
        String sql = String.format("update %s set %s = '%s' where %s = %d", 
                                    tabela.getNomeTabela(),
                                    tabela.getNomeColunas(tabela).get(coluna), 
                                    valor,
                                    tabela.getNomeColunas(tabela).get(0), 
                                    id);

        PreparedStatement comando = con.prepareStatement(sql);


        //Executando a instruções SQL
        comando.execute();

        //Fechando as conexões
        comando.close();
        con.close();

    }

    //Deletar um dados específico
    public void deletar(Tabelas tabela, int id) throws ClassNotFoundException, SQLException{

        //Estabelecendo a conexão com o BD
        Connection con = getConexao();

        //Preparando o comando SQL
        String sql = String.format("delete from %s where %s = %d",tabela.getNomeTabela() ,tabela.getNomeColunas(tabela).get(0), id);

        //Preparando o comando SQL
        PreparedStatement comando = con.prepareStatement(sql);

        //Executando a instruções SQL
        comando.execute();

        //Fechando as conexões
        comando.close();
        con.close();
    
    }
}

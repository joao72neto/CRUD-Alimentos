package entidades;

import java.sql.*;
import java.util.ArrayList;

public class Crud extends Conexao{
    

    //Atributos da classe
    public void cadastrar(Tabelas tabela) throws ClassNotFoundException, SQLException{
        //Realizando a conexão com o banco de dados
        Connection con = getConexao();
        
        //Pegando iformações sobre a tabela
        ArrayList<String> nomeColunas = getNomeColunas();
        ArrayList<Object> valorColunas = tabela.getValorColunas();
        String nomeTabela = tabela.getNomeTabela();

        //Inserindo dados de forma dinâmica
        StringBuilder insert = new StringBuilder("insert into " + nomeTabela + " (");

        //Colocando o nome das colunas
        for(int i=1; i < nomeColunas.size(); i++){
            insert.append(nomeColunas.get(i));

            if(i < nomeColunas.size()-1){
                insert.append(", ");
            }
        }

        //adicionando os valores a serem inseridos
        insert.append(") values (");

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

        /* 
        //Inserindo os dados
        int i=1;
        for(Object ele : colunas){
        
            if (ele instanceof String){
                comando.setString(i, (String) ele);

            }else if (ele instanceof Double){
                comando.setDouble(i, (Double) ele);
                
            }else if (ele instanceof Integer){
                comando.setInt(i, (Integer) ele);

            }else if (ele instanceof Date){
                comando.setDate(i, null);
            }else{
                throw new IllegalArgumentException("Tipo de dado inválido" + ele.getClass());
            }
            
            i++;
        }
        */

        //Executando a instruções SQL
        comando.execute();

        //Fechando as conexões
        comando.close();
        con.close();

    }

    //Métodos capaz de visualizar os dados da tabela
    public void visualizar() throws ClassNotFoundException, SQLException{

        /*Connection con = getConexao();

        //Preparando o comando SQL
        String sql = "select * from " + tabela;
        PreparedStatement comando = con.prepareStatement(sql);

        //Capturando todos os resultados
        ResultSet resultado = comando.executeQuery();

        while (resultado.next()) {
            alm_id = resultado.getInt("alm_id");
            String alm_nome = resultado.getString("alm_nome");
            String alm_categoria = resultado.getString("alm_categoria");
            double alm_quantidade_estoque = resultado.getDouble("alm_quantidade_estoque");
            double alm_preco = resultado.getDouble("alm_preco");
            Date alm_data_validade = resultado.getDate("alm_data_validade");
            Date alm_data_fabricacao = resultado.getDate("alm_data_fabricacao");
            double alm_peso_por_unidade = resultado.getDouble("alm_peso_por_unidade");
            String alm_marca = resultado.getString("alm_marca");
            String alm_pais_origem = resultado.getString("alm_pais_origem");
            String alm_codigo_barrar = resultado.getString("alm_codigo_barras");

            //Mostrando o resultado
            System.out.println("\nID: " + alm_id + 
                               "\nNOME: " + alm_nome + 
                               "\nCATEGORIA: " + alm_categoria + 
                               "\nQTD ESTOQUE: " + alm_quantidade_estoque + 
                               "\nPREÇO: " + alm_preco + 
                               "\nDATA VALIDADE: " + alm_data_validade + 
                               "\nDATA FABRICAÇÃO: " + alm_data_fabricacao + 
                               "\nPESO/u: " + alm_peso_por_unidade + 
                               "\nMARCA: " + alm_marca + 
                               "\nPAÍS DE ORIGEM: " + alm_pais_origem + 
                               "\nCÓDIGO DE BARRAS: " + alm_codigo_barrar);

        }


        //Fechando as conexões
        comando.close();
        resultado.close();
        con.close();*/


    }

    //Modificar um dado existente
    public void atualizar(String coluna, Object valor, int id) throws ClassNotFoundException, SQLException{

       /* Connection con = getConexao();

        //Preparando o comando SQL
        String sql = String.format("update %s set %s = %s where %s = %d", 
                                    tabela,
                                    coluna, 
                                    valor,
                                    tbl_id, 
                                    id);

        PreparedStatement comando = con.prepareStatement(sql);


        //Executando a instruções SQL
        comando.execute();

        //Fechando as conexões
        comando.close();
        con.close();*/

    }

    //Deletar um dados específico
    public void deletar(int id) throws ClassNotFoundException, SQLException{

       /*Connection con = getConexao();

        //Preparando o comando SQL
        String sql = String.format("delete from %s where %s = %d", tabela, tbl_id, id);
        PreparedStatement comando = con.prepareStatement(sql);

        //Executando a instruções SQL
        comando.execute();

        //Fechando as conexões
        comando.close();
        con.close();*/
    
    }
}

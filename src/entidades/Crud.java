package entidades;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Crud extends Conexao{
    
    protected ArrayList<Object> colunas;
    protected String tabela;
    protected String tbl_id;
    protected Boolean vazio = false;

    //Atributos da classe
    public void cadastrar(Object tabela) throws ClassNotFoundException, SQLException{
        
        Connection con = getConexao();
        

        //Preparando o comando SQL
        String sql = "INSERT INTO ALIMENTOS (alm_nome, alm_categoria, alm_quantidade_estoque, alm_preco, alm_data_validade, alm_data_fabricacao, alm_peso_por_unidade, alm_marca, alm_pais_origem, alm_codigo_barras) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement comando = con.prepareStatement(sql);

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

        //Executando a instruções SQL
        comando.execute();


        //Fechando as conexões
        comando.close();
        con.close();

    }

    //Métodos capaz de visualizar os dados da tabela
    public void visualizar() throws ClassNotFoundException, SQLException{

        Connection con = getConexao();

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
        con.close();


    }

    //Modificar um dado existente
    public void atualizar(String coluna, Object valor, int id) throws ClassNotFoundException, SQLException{

        Connection con = getConexao();

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
        con.close();

    }

    //Deletar um dados específico
    public void deletar(int id) throws ClassNotFoundException, SQLException{

        Connection con = getConexao();

        //Preparando o comando SQL
        String sql = String.format("delete from %s where %s = %d", tabela, tbl_id, id);
        PreparedStatement comando = con.prepareStatement(sql);

        //Executando a instruções SQL
        comando.execute();

        //Fechando as conexões
        comando.close();
        con.close();
    
    }
}

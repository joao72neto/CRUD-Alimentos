package entidade;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import banco.Conexao;

public class Crud extends Conexao{
    
    protected ArrayList<Object> colunas;

    //Atributos da classe
    public void cadastrar() throws ClassNotFoundException, SQLException{
        
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

        //Fechando a conexão
        comando.close();

    }

}

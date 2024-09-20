package entidades;

import java.util.ArrayList;
import java.sql.Date;

public class Alimentos extends Crud implements Tabelas{

    //Atributos
    private ArrayList<Object> valorColunas;

    //Construtores da classe    
    public Alimentos(String alm_nome, String alm_categoria, 
                    double alm_quantidade_estoque, double alm_preco,
                    String alm_data_validade, String alm_data_fabricacao, 
                    double alm_peso_por_unidade, String alm_marca,
                    String alm_pais_origem, String alm_codigo_barras) {

        valorColunas.add(alm_nome);
        valorColunas.add(alm_categoria);
        valorColunas.add(alm_quantidade_estoque);
        valorColunas.add(alm_preco);
        valorColunas.add(alm_data_validade);
        valorColunas.add(alm_data_fabricacao);
        valorColunas.add(alm_peso_por_unidade);
        valorColunas.add(alm_marca);
        valorColunas.add(alm_pais_origem);
        valorColunas.add(alm_codigo_barras);
    }

    
    //Implementando a interface
    @Override
    public ArrayList<Object> getValorColunas() {
        return valorColunas;
    }

    @Override
    public String getNomeTabela() {
        return "alimentos";
    }

    //Getters e Setter
    public void setAlm_nome(String alm_nome) {
       valorColunas.set(0, alm_nome);
    }
    public String getAlm_nome() {
        return (String) valorColunas.get(0);
    }
    public void setAlm_categoria(String alm_categoria) {
        valorColunas.set(1, alm_categoria);
    }
    public String getAlm_categoria() {
        return (String) valorColunas.get(1);
    }
    public void setAlm_quantidade_estoque(double alm_quantidade_estoque) {
        valorColunas.set(2, alm_quantidade_estoque);
    }
    public double getAlm_quantidade_estoque() {
        return (double) valorColunas.get(2);
    }
    public void setAlm_preco(double alm_preco) {
        valorColunas.set(3, alm_preco);
    }
    public double getAlm_preco() {
        return (double) valorColunas.get(3);
    }
    public void setAlm_data_validade(Date alm_data_validade) {
        valorColunas.set(4, alm_data_validade);
    }
    public Date getAlm_data_validade() {
        return (Date) valorColunas.get(4);
    }
    public void setAlm_data_fabricacao(Date alm_data_fabricacao) {
        valorColunas.set(5, alm_data_fabricacao);
    }
    public Date getAlm_data_fabricacao() {
        return (Date) valorColunas.get(5);
    }
    public void setAlm_peso_por_unidade(double alm_peso_por_unidade) {
        valorColunas.set(6, alm_peso_por_unidade);
    }
    public double getAlm_peso_por_unidade() {
        return (double) valorColunas.get(6);
    }
    public void setAlm_marca(String alm_marca) {
        valorColunas.set(7, alm_marca);
    }
    public String getAlm_marca() {
        return (String) valorColunas.get(7);
    }
    public void setAlm_pais_origem(String alm_pais_origem) {
        valorColunas.set(8, alm_pais_origem);
    }
    public String getAlm_pais_origem() {
        return (String) valorColunas.get(8);
    }
    public void setAlm_codigo_barras(String alm_codigo_barras) {
        valorColunas.set(9, alm_codigo_barras);
    }
    public String getAlm_codigo_barras() {
        return (String) valorColunas.get(9);
    }

}


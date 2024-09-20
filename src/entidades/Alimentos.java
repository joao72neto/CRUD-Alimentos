package entidades;

import java.util.ArrayList;
import java.sql.Date;

public class Alimentos {

    //Atributos
    private ArrayList<Object> colunas;

    //Construtores da classe    
    public Alimentos(String alm_nome, String alm_categoria, 
                    double alm_quantidade_estoque, double alm_preco,
                    String alm_data_validade, String alm_data_fabricacao, 
                    double alm_peso_por_unidade, String alm_marca,
                    String alm_pais_origem, String alm_codigo_barras) {

        colunas.add(alm_nome);
        colunas.add(alm_categoria);
        colunas.add(alm_quantidade_estoque);
        colunas.add(alm_preco);
        colunas.add(alm_data_validade);
        colunas.add(alm_data_fabricacao);
        colunas.add(alm_peso_por_unidade);
        colunas.add(alm_marca);
        colunas.add(alm_pais_origem);
        colunas.add(alm_codigo_barras);
    }

    
    //Getters e Setter
    public void setAlm_nome(String alm_nome) {
       colunas.set(0, alm_nome);
    }
    public String getAlm_nome() {
        return (String) colunas.get(0);
    }
    public void setAlm_categoria(String alm_categoria) {
        colunas.set(1, alm_categoria);
    }
    public String getAlm_categoria() {
        return (String) colunas.get(1);
    }
    public void setAlm_quantidade_estoque(double alm_quantidade_estoque) {
        colunas.set(2, alm_quantidade_estoque);
    }
    public double getAlm_quantidade_estoque() {
        return (double) colunas.get(2);
    }
    public void setAlm_preco(double alm_preco) {
        colunas.set(3, alm_preco);
    }
    public double getAlm_preco() {
        return (double) colunas.get(3);
    }
    public void setAlm_data_validade(Date alm_data_validade) {
        colunas.set(4, alm_data_validade);
    }
    public Date getAlm_data_validade() {
        return (Date) colunas.get(4);
    }
    public void setAlm_data_fabricacao(Date alm_data_fabricacao) {
        colunas.set(5, alm_data_fabricacao);
    }
    public Date getAlm_data_fabricacao() {
        return (Date) colunas.get(5);
    }
    public void setAlm_peso_por_unidade(double alm_peso_por_unidade) {
        colunas.set(6, alm_peso_por_unidade);
    }
    public double getAlm_peso_por_unidade() {
        return (double) colunas.get(6);
    }
    public void setAlm_marca(String alm_marca) {
        colunas.set(7, alm_marca);
    }
    public String getAlm_marca() {
        return (String) colunas.get(7);
    }
    public void setAlm_pais_origem(String alm_pais_origem) {
        colunas.set(8, alm_pais_origem);
    }
    public String getAlm_pais_origem() {
        return (String) colunas.get(8);
    }
    public void setAlm_codigo_barras(String alm_codigo_barras) {
        colunas.set(9, alm_codigo_barras);
    }
    public String getAlm_codigo_barras() {
        return (String) colunas.get(9);
    }

}


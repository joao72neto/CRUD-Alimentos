package entidades;

import java.sql.Date;

public class Alimentos implements Tabelas{

    //Atributos
    private int alm_id;
    private String alm_nome;
    private String alm_categoria;
    private double alm_quantidade_estoque;
    private double alm_preco;
    private Date alm_data_validade;
    private Date alm_data_fabricacao;
    private double alm_peso_por_unidade;
    private String alm_marca;
    private String alm_pais_origem;
    private String alm_codigo_barras;

    //Construtores da classe    
    public Alimentos(){
        
    }


    public Alimentos(int alm_id, String alm_nome, String alm_categoria, 
                    double alm_quantidade_estoque, double alm_preco,
                    Date alm_data_validade, Date alm_data_fabricacao, 
                    double alm_peso_por_unidade, String alm_marca,
                    String alm_pais_origem, String alm_codigo_barras) {
        
        this.alm_id = alm_id;
        this.alm_nome = alm_nome;
        this.alm_categoria = alm_categoria;
        this.alm_quantidade_estoque = alm_quantidade_estoque;
        this.alm_preco = alm_preco;
        this.alm_data_validade = alm_data_validade;
        this.alm_data_fabricacao = alm_data_fabricacao;
        this.alm_peso_por_unidade = alm_peso_por_unidade;
        this.alm_marca = alm_marca;
        this.alm_pais_origem = alm_pais_origem;
        this.alm_codigo_barras = alm_codigo_barras;
        
        
    }

    
    //Implementando dos métodos da interface
    @Override
    public String getNomeTabela() {
        return "alimentos";
    }

    
    //Getters and Setters
    public void setAlm_id(int alm_id) {
        this.alm_id = alm_id;
    }

    
    public int getAlm_id() {
        return alm_id;
    }


    public String getAlm_nome() {
        return alm_nome;
    }


    public void setAlm_nome(String alm_nome) {
        this.alm_nome = alm_nome;
    }


    public String getAlm_categoria() {
        return alm_categoria;
    }


    public void setAlm_categoria(String alm_categoria) {
        this.alm_categoria = alm_categoria;
    }


    public double getAlm_quantidade_estoque() {
        return alm_quantidade_estoque;
    }


    public void setAlm_quantidade_estoque(double alm_quantidade_estoque) {
        this.alm_quantidade_estoque = alm_quantidade_estoque;
    }


    public double getAlm_preco() {
        return alm_preco;
    }


    public void setAlm_preco(double alm_preco) {
        this.alm_preco = alm_preco;
    }


    public Date getAlm_data_validade() {
        return alm_data_validade;
    }


    public void setAlm_data_validade(Date alm_data_validade) {
        this.alm_data_validade = alm_data_validade;
    }


    public Date getAlm_data_fabricacao() {
        return alm_data_fabricacao;
    }


    public void setAlm_data_fabricacao(Date alm_data_fabricacao) {
        this.alm_data_fabricacao = alm_data_fabricacao;
    }


    public double getAlm_peso_por_unidade() {
        return alm_peso_por_unidade;
    }


    public void setAlm_peso_por_unidade(double alm_peso_por_unidade) {
        this.alm_peso_por_unidade = alm_peso_por_unidade;
    }


    public String getAlm_marca() {
        return alm_marca;
    }


    public void setAlm_marca(String alm_marca) {
        this.alm_marca = alm_marca;
    }


    public String getAlm_pais_origem() {
        return alm_pais_origem;
    }


    public void setAlm_pais_origem(String alm_pais_origem) {
        this.alm_pais_origem = alm_pais_origem;
    }


    public String getAlm_codigo_barras() {
        return alm_codigo_barras;
    }


    public void setAlm_codigo_barras(String alm_codigo_barras) {
        this.alm_codigo_barras = alm_codigo_barras;
    }
  
}


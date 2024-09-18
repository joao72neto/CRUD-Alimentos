package entidade;

import java.util.ArrayList;

public class Alimentos extends Crud {

    //Atributos
    private String alm_nome;
    private String alm_categoria;
    private double alm_quantidade_estoque;
    private double alm_preco;
    private String alm_data_validade;
    private String alm_data_fabricacao;
    private double alm_peso_por_unidade;
    private String alm_marca;
    private String alm_pais_origem;
    private String alm_codigo_barras; 

    //Contantes
    private final int QTDATRIBUTOS = 10;


    //Construtores da classe
    public Alimentos(){
       
    }

    
    public Alimentos(String alm_nome, String alm_categoria, 
                    double alm_quantidade_estoque, double alm_preco,
                    String alm_data_validade, String alm_data_fabricacao, 
                    double alm_peso_por_unidade, String alm_marca,
                    String alm_pais_origem, String alm_codigo_barras) {

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



    //Métodos para mexer no CRUD
    public void confirmarDados(){

        colunas = new ArrayList<>();
        updateCrud();

        if (colunas.size() != QTDATRIBUTOS){
            System.out.println((QTDATRIBUTOS - colunas.size()) + " Atributo(s) restante(s)");
            return;
        }
        
        System.out.println("Você pode realizar as operações do CRUD");
    }

    private void updateCrud(){
        addNotNull(colunas, alm_nome);
        addNotNull(colunas, alm_categoria);
        addNotNull(colunas, alm_quantidade_estoque);
        addNotNull(colunas, alm_preco);
        addNotNull(colunas, alm_data_validade);
        addNotNull(colunas, alm_data_fabricacao);
        addNotNull(colunas, alm_peso_por_unidade);
        addNotNull(colunas, alm_marca);
        addNotNull(colunas, alm_pais_origem);
        addNotNull(colunas, alm_codigo_barras);
    }

    private void addNotNull(ArrayList<Object> colunas, Object coluna){

        if(coluna != null){
            colunas.add(coluna);
        }else{
            
        }
    }

    
    //Getters e Setter
    public void setAlm_categoria(String alm_categoria) {
        this.alm_categoria = alm_categoria;
    }
    public String getAlm_categoria() {
        return alm_categoria;
    }
    public void setAlm_codigo_barras(String alm_codigo_barras) {
        this.alm_codigo_barras = alm_codigo_barras;
    }
    public String getAlm_codigo_barras() {
        return alm_codigo_barras;
    }
    public void setAlm_data_fabricacao(String alm_data_fabricacao) {
        this.alm_data_fabricacao = alm_data_fabricacao;
    }
    public String getAlm_data_fabricacao() {
        return alm_data_fabricacao;
    }
    public void setAlm_data_validade(String alm_data_validade) {
        this.alm_data_validade = alm_data_validade;
    }
    public String getAlm_data_validade() {
        return alm_data_validade;
    }
    public void setAlm_marca(String alm_marca) {
        this.alm_marca = alm_marca;
    }
    public String getAlm_marca() {
        return alm_marca;
    }
    public void setAlm_nome(String alm_nome) {
        this.alm_nome = alm_nome;
    }
    public String getAlm_nome() {
        return alm_nome;
    }
    public void setAlm_pais_origem(String alm_pais_origem) {
        this.alm_pais_origem = alm_pais_origem;
    }
    public String getAlm_pais_origem() {
        return alm_pais_origem;
    }
    public void setAlm_peso_por_unidade(double alm_peso_por_unidade) {
        this.alm_peso_por_unidade = alm_peso_por_unidade;
    }
    public double getAlm_peso_por_unidade() {
        return alm_peso_por_unidade;
    }
    public void setAlm_preco(double alm_preco) {
        this.alm_preco = alm_preco;
    }
    public double getAlm_preco() {
        return alm_preco;
    }
    public void setAlm_quantidade_estoque(double alm_quantidade_estoque) {
        this.alm_quantidade_estoque = alm_quantidade_estoque;
    }
    public double getAlm_quantidade_estoque() {
        return alm_quantidade_estoque;
    }
    
}


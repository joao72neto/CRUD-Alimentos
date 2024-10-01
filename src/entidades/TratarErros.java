package entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;

public class TratarErros {
    
    //Atributos
    private static int TAM = 40;
    private static Scanner sc = new Scanner(System.in);


    //Função que exibe uma msg de valor inválido
    public static void valorInvalido(String msg, Scanner sc, int TAM){
            
            Estilo.limpaTela();
            Estilo.l(TAM);
            System.out.println(Estilo.centralizar(msg, TAM));
            Estilo.l(TAM);
            System.out.print("Pressione 'Enter' para continuar...");
            sc.nextLine();
            
    }

    //Função que lê apenas valores inteiros
    public static int pegarInteiro(String valor){
        try {
            int v = Integer.parseInt(valor);
            return v;

        } catch (NumberFormatException e) {
            valorInvalido("O Valor não é inteiro", sc, TAM);
            return 0;
        }
    }

    //Função que lê apenas valores inteiros dentro de um intervalo
    public static int pegarInteiro(String valor, int inicio, int fim){
        
        try {
            int v = Integer.parseInt(valor);

            if (v >= inicio && v <= fim){
                return v;
            }

            valorInvalido("Valor fora do intervalo", sc, TAM);
            return 0;

        } catch (NumberFormatException e) {
            valorInvalido("O Valor não é inteiro", sc, TAM);
            return 0;
        }
    }

    //Função que lê apenas valores double
    public static double pegarDouble(String valor){
        try {
            double v = Double.parseDouble(valor);
            return v;

        } catch (NumberFormatException e) {
            valorInvalido("O valor não é double", sc, TAM);
            return 0;
        }
    }


    //Função que le datas no formato yyyy-mm-dd
    public static Date pegarData(String valor){
       
        //padrão de formatação
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        //Tentando converter para data
        try {
            LocalDate ld = LocalDate.parse(valor, formato);
            return Date.valueOf(ld);
        } catch (Exception e) {
            valorInvalido("O valor não é uma data", sc, TAM);
            return null;
        }
    }

    //Mostra todos os dados que já foram inseridos para cadastro
    public static void dados_inseridos(ArrayList<Object> valores_inseridos, ArrayList<String> nomes_colunas, int TAM, Boolean limpar){
        //Mostrando valores já adicionados
        if (limpar){
            Estilo.limpaTela();
        }

        Estilo.l(TAM);

        int i=0;

        for(Object valor : valores_inseridos){
            System.out.println(nomes_colunas.get(i) + ": " + valor);
            i++;
        }
    }

    //Função que pega todos os dados para cadastrar um alimento
    public static void pegar_dados_cadastrar(Alimentos al, Scanner sc){
        
        ArrayList<Object> valores_inseridos = new ArrayList<>();
        ArrayList<String> nomes_colunas = new ArrayList<>();

        //Pegando todos os nomes de colunas personalizados
        nomes_colunas = Estilo.nomes_personalizados_colunas(false);


        int TAM = 30;
        
        //Consistido o ID
        while (true){

            //Pegando os dados do usuário
            Estilo.l(TAM);
            System.out.print("ID: ");
            int id_tabela = pegarInteiro(sc.nextLine());
            

            if (id_tabela == 0){
                Estilo.limpaTela();
                continue;
            }

            al.setAlm_id(id_tabela);
            valores_inseridos.add(id_tabela);

            break;
        }

        //Consistindo o nome
        while (true) {
            System.out.print("NOME: ");
            String nome = sc.nextLine();

            if (nome.isEmpty()){

                valorInvalido("Espaços não são válidos", sc, 40);
                dados_inseridos(valores_inseridos, nomes_colunas, TAM, true);

                continue;
            }

            al.setAlm_nome(nome);
            valores_inseridos.add(nome);

            break;
        }
        
        //Consistendo a categoria
        while (true) {
            System.out.print("CATEGORIA: ");
            String cat = sc.nextLine();
            
            if (cat.isEmpty()){

                valorInvalido("Espaços não são válidos", sc, 40);
                dados_inseridos(valores_inseridos, nomes_colunas, TAM, true);

                continue;
            }
            
            al.setAlm_categoria(cat);
            valores_inseridos.add(cat);

            break;
        }

        //Consistindo a qtd no estoque
        while (true) {
            System.out.print("QUANTIDADE ESTOQUE:");
            int qtd_estoque = pegarInteiro(sc.nextLine());

            if (qtd_estoque == 0){

                //Exibindo os valores que já foram adicionados
                dados_inseridos(valores_inseridos, nomes_colunas, TAM, true);

                continue;
            }

            al.setAlm_quantidade_estoque(qtd_estoque); 
            valores_inseridos.add(qtd_estoque);

            break;

        }

        //Consistindo o preço
        while (true) {
            System.out.print("PREÇO: ");
            double preco = pegarDouble(sc.nextLine());

            if (preco == 0){

                //Mostrando valores já adicionados
                dados_inseridos(valores_inseridos, nomes_colunas, TAM, true);

                continue;
            }

            al.setAlm_preco(preco);
            valores_inseridos.add(preco);

            break;
        
        }

        //Consistindo a data de validade
        while (true){
            System.out.print("DATA DE VALIDADE: ");
            Date data = pegarData(sc.nextLine());

            if (data == null){

                //Mostrando valores já adicionados
                dados_inseridos(valores_inseridos, nomes_colunas, TAM, true);

                continue;
            }

            al.setAlm_data_validade(data);
            valores_inseridos.add(data);

            break;
        }

        //Consistindo a data de fabricação            
        while (true) {
            System.out.print("DATA DE FABRICAÇÃO: ");
            Date data = pegarData(sc.nextLine());

            if(data == null){

                //Mostrando valores já adicionados
                dados_inseridos(valores_inseridos, nomes_colunas, TAM, true);

                continue;
            }

            al.setAlm_data_fabricacao(data);
            valores_inseridos.add(data);

            break;
        }


        //Consistindo o peso por unidade
        while (true) {
            System.out.print("PESO POR UNIDADE: ");
            double peso_por_unidade = pegarDouble(sc.nextLine());

            if(peso_por_unidade == 0){

                //Mostrando valores já adicionados
                dados_inseridos(valores_inseridos, nomes_colunas, TAM, true);

                continue;
            }

            al.setAlm_peso_por_unidade(peso_por_unidade);
            valores_inseridos.add(peso_por_unidade);

            break;
       
        }

        //Consistindo a marca
        while (true) {
            System.out.print("MARCA: ");
            String marca = sc.nextLine();

            if (marca.isEmpty()){

                valorInvalido("Espaços não são válidos", sc, 40);
                dados_inseridos(valores_inseridos, nomes_colunas, TAM, true);

                continue;
            }
            
            al.setAlm_marca(marca);
            valores_inseridos.add(marca);

            break;
        }

        //Consistindo o país de orígem
        while (true) {
            System.out.print("PAÍS ORIGEM: ");
            String pais_origem = sc.nextLine();

            if (pais_origem.isEmpty()){

                valorInvalido("Espaços não são válidos", sc, 40);
                dados_inseridos(valores_inseridos, nomes_colunas, TAM, true);

                continue;
            }

            al.setAlm_pais_origem(pais_origem);
            valores_inseridos.add(pais_origem);

            break;
        }

        //Consistindo o código de barras
        while (true) {
            System.out.print("CÓDIGO DE BARRAS: ");
            String codigo_barras = sc.nextLine();

            if (codigo_barras.isEmpty()){

                valorInvalido("Espaços não são válidos", sc, 40);
                dados_inseridos(valores_inseridos, nomes_colunas, TAM, true);

                continue;
            }
            
            al.setAlm_codigo_barras(codigo_barras);

            break;
        }

    }
}

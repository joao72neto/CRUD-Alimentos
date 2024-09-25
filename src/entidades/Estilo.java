package entidades;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import oracle.sql.BOOLEAN;
import oracle.sql.BlobDBAccess;

public class Estilo {
    
    //Funções que printam uma linha na tela
    public static void l(){
        System.out.println("-".repeat(40));
    }

    public static void l(int TAM){
        System.out.println("-".repeat(TAM));
    }

    //Função que centraliza um string
    public static String centralizar(String msg, int TAM){

        int lateral = (TAM - msg.length()) / 2;
        return " ".repeat(lateral) + msg;

    }

    //Função que limpa a tela
    public static void limapTela(){

        try{
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else{  
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.toString());
        }
        
    }

    //Cabeçalho personalizado criado para exibição dos dados
    public static void cabecalho(Boolean indice){

        int TAM = 142;

        Estilo.limapTela();

        //Personalianco o cabeçalho
        Estilo.l(TAM);
        System.out.println(Estilo.centralizar("Alimentos", TAM));
        Estilo.l(TAM);

        ArrayList<String> nomes = new ArrayList<>();
        nomes = nomes_personalizados_colunas(indice);

        //Exibindo o título
        for(String nome : nomes){
            System.out.printf("%-10s | ", nome);
        }
        System.out.println();

        Estilo.l(TAM);
    }

    //Função que define os nomes personalizados para as colunas
    public static ArrayList<String> nomes_personalizados_colunas(Boolean indice){
        
        ArrayList<String> nomes = new ArrayList<>();

        if (indice){
            nomes.add("ID");
            nomes.add("(1) NOME");
            nomes.add("(2) CAT");
            nomes.add("(3) ESTOQ");
            nomes.add("(4) PREÇO");
            nomes.add("(5) VALI");
            nomes.add("(6) FABRI");
            nomes.add("(7) PESO");
            nomes.add("(8) MARCA");
            nomes.add("(9) PAÍS");
            nomes.add("(10) CÓD");

        return nomes;

        }else{
            nomes.add("ID");
            nomes.add("NOME");
            nomes.add("CATEGORIA");
            nomes.add("ESTOQUE");
            nomes.add("PREÇO");
            nomes.add("VALIDADE");
            nomes.add("FABRICAÇÃO");
            nomes.add("PESO");
            nomes.add("MARCA");
            nomes.add("PAÍS");
            nomes.add("CÓD BARRAS");

            return nomes;
        }  
    }

    //Função que retorna um feedback para o usuário
    public static void feedback(String msg, Scanner sc, Alimentos al, Crud c){
        
        int TAM = 40;
        Estilo.limapTela();
        Estilo.l(TAM);
        System.out.println(Estilo.centralizar(msg, TAM));
        Estilo.l(TAM);

        System.out.print("Pressione 'Enter' ver os dados...");
        sc.nextLine();

        TAM = 142;
        Estilo.limapTela();
        cabecalho(false);
        
        try{
            c.visualizar(al);
        }catch(ClassNotFoundException e){
            System.out.println("Erro: " + e.toString());
        }catch(SQLException e){
            System.out.println("Erro: " + e.toString());
        }
        
        Estilo.l(TAM);

        System.out.print("Pressione 'Enter' para voltar...");
        sc.nextLine();
    }
}   

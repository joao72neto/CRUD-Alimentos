package entidades;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

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
    public static void cabecalho(){

        int TAM = 142;

        Estilo.limapTela();

        //Personalianco o cabeçalho
        Estilo.l(TAM);
        System.out.println(Estilo.centralizar("Alimentos", TAM));
        Estilo.l(TAM);

        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("ID");
        nomes.add("NOME");
        nomes.add("CATEGORIA");
        nomes.add("ESTOQUE");
        nomes.add("PREÇO");
        nomes.add("VALIDADE");
        nomes.add("FABRICAÇÃO");
        nomes.add("PESO/U");
        nomes.add("MARCA");
        nomes.add("PAÍS");
        nomes.add("CÓD BARRAS");

        //Exibindo o título
        for(String nome : nomes){
            System.out.printf("%-10s | ", nome);
        }
        System.out.println();

        Estilo.l(TAM);
    }

    //Função que retorna um feedback para o usuário
    public static void feedback(String msg, Scanner sc, Alimentos al, Crud c){
        
        int TAM = 40;
        Estilo.limapTela();
        Estilo.l(TAM);
        System.out.println(Estilo.centralizar("Dado deletado com sucesso!", TAM));
        Estilo.l(TAM);

        System.out.print("Pressione qualque tecla ver os dados...");
        sc.nextLine();

        TAM = 142;
        Estilo.limapTela();
        cabecalho();
        
        try{
            c.visualizar(al);
        }catch(ClassNotFoundException e){
            System.out.println("Erro: " + e.toString());
        }catch(SQLException e){
            System.out.println("Erro: " + e.toString());
        }
        
        Estilo.l(TAM);

        System.out.print("Pressione qualque tecla para voltar...");
        sc.nextLine();
    }
}   

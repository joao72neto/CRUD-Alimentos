package entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TratarErros {
    
    //Atributos
    private static int TAM = 40;
    private static Scanner sc = new Scanner(System.in);


    //Função que exibe uma msg de valor inválido
    public static void valorInvalido(String msg, Scanner sc, int TAM){
            
            Estilo.limapTela();
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
}

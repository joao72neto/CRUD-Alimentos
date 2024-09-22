package entidades;

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
}   

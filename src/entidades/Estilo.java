package entidades;

public class Estilo {
    
    //Funções que printam uma linha na tela
    public static void l(){
        for (int i=0; i < 40; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void l(int TAM){
        for (int i=0; i < TAM; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}

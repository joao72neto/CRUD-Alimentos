import java.sql.SQLException;
import java.util.Scanner;
import entidades.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //Variáveis que permite sair do loop while
        boolean rodar = true; 

        //Variáveis para ler os inputs do usuário
        Scanner sc = new Scanner(System.in);

        //tabela de alimentos
        Alimentos al = new Alimentos();

        //Tamanho que as strings precisam estar centralizadas
        int TAM = 0;

        while (rodar){

            //Redefinindo o tamanho de centralização das strings e das linhas
            TAM = 40;

            //Variável que armazena a escolha do usuário para o menu principal
            int escolha = 0;

            while(true){
                //Título
                Estilo.limpaTela();
                Estilo.l(TAM);
                System.out.println(Estilo.centralizar("CRUD de Alimentos", TAM));
                Estilo.l(TAM);

                //Menu
                System.out.println("1 - Cadastrar");
                System.out.println("2 - Visualizar");
                System.out.println("3 - Atualizar");
                System.out.println("4 - Deletar");
                System.out.println("5 - Sair");
                Estilo.l(TAM);
                System.out.print("Sua escolha: ");

                //Pegando a escolha do usuário            
                escolha = TratarErros.pegarInteiro(sc.nextLine(), 1, 5);

                if (escolha == 0){
                    continue;
                }

                break;
            }

            //Instanciando o crud
            Crud c = new Crud();

            switch (escolha) {
                case 1: //Cadastrar 

                    //Limpando a tela com as opções do menu
                    Estilo.limpaTela();

                    //Pegando os valores para cadastro
                    TratarErros.pegar_dados_cadastrar(al, sc);

                    //Limpando a tela com os dados inseridos para cadastro
                    Estilo.limpaTela();

                    //Cadastrando no banco de dados
                    c.cadastrar(al);

                    //Feedback para o usuário
                    TAM = 40;
                    Estilo.l(TAM);
                    System.out.println(Estilo.centralizar("Alimento cadastrado com sucesso!", TAM));
                    Estilo.l(TAM);
                    System.out.print("Pressione 'Enter' para voltar...");
                    sc.nextLine();
                    break;

                case 2:// Visualizar

                    TAM = 40;

                    int resp_visualizar = 0;

                    while (true){
                        //Submenu
                        Estilo.limpaTela();
                        Estilo.l(TAM);
                        System.out.println("1 - Por id");
                        System.out.println("2 - Tudo");
                        Estilo.l(TAM);
                        System.out.print("Sua escolha: ");

                        //Pegando a escolha do usuário
                        resp_visualizar = TratarErros.pegarInteiro(sc.nextLine(), 1, 2);

                        if (resp_visualizar == 0){
                            continue;
                        }   

                        break;
                    }

                    //Verificando a escolha do usuário
                    if(resp_visualizar == 1){

                        int id_busca = 0;
                        
                        while(true){
                            Estilo.limpaTela();
                            Estilo.l(TAM);
                            System.out.print("ID: ");
                            id_busca = TratarErros.pegarInteiro(sc.nextLine(), al.getIds(al));

                            if (id_busca == 0){
                                continue;
                            }

                            break;
                        }

                        //Chamando o cabeçalho personalizado
                        Estilo.cabecalho(false);

                        c.visualizar(al, id_busca);
                        Estilo.l(142);
                        System.out.print("Pressione 'Enter' para voltar...");
                        sc.nextLine();
                        break;
                    }

                    //Chamando o cabeçalho personalizado
                    Estilo.cabecalho(false);
                    
                    c.visualizar(al);
                    Estilo.l(142);
                    System.out.print("Pressione 'Enter' para voltar...");
                    sc.nextLine();
                    break;
            
                case 3: //Atualizar
                
                    //valores inseridos
                    ArrayList<Object> valores_inseridos = new ArrayList<>();
                    ArrayList<String> nomes = new ArrayList<>();

                    //Definindo os nomes
                    nomes.add("COLUNA");
                    nomes.add("ID");
                    nomes.add("NOVO VALOR");

                    TAM = 142;

                    //Chamando o cabeçalho personalizado
                    Estilo.cabecalho(true);
                    c.visualizar(al);

                    //Variaveis usadas para o cadastro
                    int col, id_atualizar;
                    Object valor;

                    //Consistindo o valor da coluna
                    Estilo.l(TAM);
                    while (true) {
                        
                        System.out.print("COLUNA: ");
                        col = TratarErros.pegarInteiro(sc.nextLine(), 1, 10);

                        if (col == 0){

                            //Chamando o cabeçalho personalizado
                            Estilo.cabecalho(true);
                            c.visualizar(al);
                            TratarErros.dados_inseridos(valores_inseridos, nomes, TAM, false);

                            continue;
                        }

                        valores_inseridos.add(col);

                        break;
                    }

                    //Consistindo o ID
                    while (true) {
                        System.out.print("ID: ");
                        id_atualizar = TratarErros.pegarInteiro(sc.nextLine(), al.getIds(al));

                        if (id_atualizar == 0){
                            
                            Estilo.cabecalho(true);
                            c.visualizar(al);
                            TratarErros.dados_inseridos(valores_inseridos, nomes, TAM, false);
                            
                            continue;
                        }

                        break;
                    }
                    
                    //Consistindo o novo valor
                    while (true) {
                        System.out.print("NOVO VALOR: ");
                        valor = sc.nextLine();
                        String valor_string  = (String) valor;


                        if (valor_string.isEmpty()) {

                            TratarErros.valorInvalido("Dados nulos não são válidos", sc, 40);
                            Estilo.cabecalho(true);
                            c.visualizar(al);
                            TratarErros.dados_inseridos(valores_inseridos, nomes, TAM, false);
                            continue;
                        }

                        valores_inseridos.add(valor);

                        break;
                    }
                    
                    //Atualizando os dados
                    c.atualizar(al, col, valor, id_atualizar);

                    //Fedback para o usuário
                    Estilo.feedback("Dado atualizado com sucesso!", sc, al, c);

                    break;

                case 4: //Deletar

                    int id_deletar;

                    //Consistendo o valor do id
                    while (true) {
                        
                   
                        TAM = 142;

                        //Chamando o cabeçalho personalizado
                        Estilo.cabecalho(false);
                        c.visualizar(al);

                        //Pedindo informações necessárias para a atualização dos dados
                        Estilo.l(TAM);

                        System.out.print("ID: ");
                        id_deletar = TratarErros.pegarInteiro(sc.nextLine(), al.getIds(al));

                        if (id_deletar == 0){
                            continue;
                        }

                        break;
                    }

                    //Atualizando os dados
                    c.deletar(al, id_deletar);

                    //Fedback para o usuário
                    Estilo.feedback("Dado deletado com sucesso!", sc, al, c);

                    break;

                case 5:
                    rodar = false;
                    break;

                default:

                    TAM = 40;

                    Estilo.limpaTela();
                    Estilo.l(TAM);
                    System.out.println(Estilo.centralizar("Opção inválida", TAM));
                    Estilo.l(TAM);
                    System.out.print("Pressione 'Enter' para voltar...");
                    sc.nextLine();
                    break;
            }
        }  

        Estilo.limpaTela();
        Estilo.l(TAM);
        System.out.println(Estilo.centralizar("Fim do CRUD", TAM));
        Estilo.l(TAM);
    }

}
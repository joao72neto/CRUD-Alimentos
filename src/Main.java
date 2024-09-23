import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.Date;
import entidades.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //Variáveis que permite sair do loop while
        boolean rodar = true; 

        //Variáveis para ler os inputs do usuário
        Scanner sc = new Scanner(System.in);

        //tabela de alimentos
        Alimentos al = new Alimentos();

        //Tmanho que as strings precisam estar centralizadas
        int TAM = 0;

        while (rodar){

            TAM = 40;

            //Título
            Estilo.limapTela();
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

            //Variáveis para pegar a escolha do usuário  
            int escolha = 0;

            //Pegando a escolha do usuário
            try {
                escolha = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Tipo Iválido " + e.toString());
            } 

            //Limpando o buffer 
            sc.nextLine();

            //Instanciando o crud
            Crud c = new Crud();
            
            //Verificando a escolha do usuário
            int id=0;

            switch (escolha) {
                case 1: //Cadastrar 

                    //Limpando a tela do terminal
                    Estilo.limapTela();

                    //Pegando os dados do usuário
                    TAM = 30;
                    Estilo.l(TAM);
                    System.out.print("ID: ");
                    al.setAlm_id(sc.nextInt());
                    sc.nextLine();

                    System.out.print("NOME: ");
                    al.setAlm_nome(sc.nextLine());

                    System.out.print("CATEGORIA: ");
                    al.setAlm_categoria(sc.nextLine());

                    System.out.print("QUANTIDADE ESTOQUE:");
                    al.setAlm_quantidade_estoque(sc.nextDouble()); 

                    System.out.print("PREÇO: ");
                    al.setAlm_preco(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("DATA DE VALIDADE: ");
                    String validade = sc.nextLine();
                    Date validade_formatada = Date.valueOf(validade);
                    al.setAlm_data_validade(validade_formatada);


                    System.out.print("DATA DE FABRICAÇÃO: ");
                    String fabricacao = sc.nextLine();
                    Date fabricacao_formatada = Date.valueOf(fabricacao);
                    al.setAlm_data_fabricacao(fabricacao_formatada);

                    System.out.print("PESO POR UNIDADE: ");
                    al.setAlm_peso_por_unidade(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("MARCA: ");
                    al.setAlm_marca(sc.nextLine());

                    System.out.print("PAÍS ORIGEM: ");
                    al.setAlm_pais_origem(sc.nextLine());

                    System.out.print("CÓDIGO DE BARRAS: ");
                    al.setAlm_codigo_barras(sc.nextLine());


                    Estilo.limapTela();
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
                    TAM = 142;

                    //Chamando o cabeçalho personalizado
                    Estilo.cabecalho();

                    c.visualizar(al);
                    Estilo.l(TAM);
                    System.out.print("Pressione 'Enter' para voltar...");
                    sc.nextLine();
                    break;
            
                case 3: //Atualizar
                
                    TAM = 142;

                    //Chamando o cabeçalho personalizado
                    Estilo.cabecalho();
                    c.visualizar(al);

                    //Pedindo informações necessárias para a atualização dos dados
                    Estilo.l(TAM);
                    System.out.print("COLUNA: ");
                    String col = sc.nextLine();

                    System.out.print("NOVO VALOR: ");
                    Object valor = sc.nextLine();

                    System.out.print("ID: ");
                    id = sc.nextInt(); sc.nextLine();

                    //Atualizando os dados
                    c.atualizar(al, col, valor, id);

                    //Fedback para o usuário
                    Estilo.feedback("Dado atualizado com sucesso!", sc, al, c);
                    sc.nextLine();
                    break;

                case 4: //Deletar

                    //Consistendo o valor do id
                    while (true) {
                        
                   
                        TAM = 142;

                        //Chamando o cabeçalho personalizado
                        Estilo.cabecalho();
                        c.visualizar(al);

                        //Pedindo informações necessárias para a atualização dos dados
                        Estilo.l(TAM);

                        System.out.print("ID: ");
                        id = TratarErros.pegarInteiro(sc.nextLine());

                        if (id == 0){
                            continue;
                        }

                        break;
                    }

                    //Atualizando os dados
                    c.deletar(al, id);

                    //Fedback para o usuário
                    Estilo.feedback("Dado deletado com sucesso!", sc, al, c);

                    break;

                case 5:
                    rodar = false;
                    break;

                default:

                    TAM = 40;

                    Estilo.limapTela();
                    Estilo.l(TAM);
                    System.out.println(Estilo.centralizar("Opção inválida", TAM));
                    Estilo.l(TAM);
                    System.out.print("Pressione 'Enter' para voltar...");
                    sc.nextLine();
                    break;
            }
        }  

        Estilo.limapTela();
        Estilo.l(TAM);
        System.out.println(Estilo.centralizar("Fim do CRUD", TAM));
        Estilo.l(TAM);
    }
}
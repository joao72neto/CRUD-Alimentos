import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.Date;
import entidades.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //Variáveis
        int TAM = 57;

        //Título
        Estilo.l(TAM);
        System.out.println(Estilo.centralizar("CRUD de Alimentos", TAM));
        Estilo.l(TAM);


        //Pedindo para o usuário inseriri os valores na tabela alimentos (apresentação)
        Scanner sc = new Scanner(System.in);
        Alimentos al = new Alimentos();


       /*System.out.print("Pressione qualquer tecla para adicionar dados a tabela...");
        sc.nextLine();

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
        al.setAlm_codigo_barras(sc.nextLine());*/
        
        //Variáveis que permite sair do loop while
        boolean rodar = true; 

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

            //Isntanciando o crud e a tabela
            Crud c = new Crud();
            
            //Verificando a escolha do usuário
            switch (escolha) {
                case 1: //Cadastrar 

                    Estilo.limapTela();
                    c.cadastrar(al);

                    //Feedback para o usuário
                    Estilo.l(TAM);
                    System.out.println(Estilo.centralizar("Alimento cadastrado com sucesso!", TAM));
                    Estilo.l(TAM);
                    System.out.print("Pressione qualque tecla para voltar...");
                    sc.nextLine();
                    break;

                case 2:// Visualizar

                    //Chamando o cabeçalho personalizado
                    cabecalho();

                    c.visualizar(al);
                    Estilo.l(TAM);
                    System.out.print("Pressione qualque tecla para voltar...");
                    sc.nextLine();
                    break;
            
                case 3: //Atualizar
                
                    //Chamando o cabeçalho personalizado
                    cabecalho();
                    c.visualizar(al);

                    //Pedindo informações necessárias para a atualização dos dados
                    Estilo.l(142);
                    System.out.print("COLUNA: ");
                    String col = sc.nextLine();

                    System.out.print("NOVO VALOR: ");
                    Object valor = sc.nextLine();

                    System.out.print("ID: ");
                    int id = sc.nextInt(); sc.nextLine();

                    //Atualizando os dados
                    c.atualizar(al, col, valor, id);

                    //Fedback para o usuário
                    Estilo.limapTela();
                    Estilo.l(TAM);
                    System.out.println(Estilo.centralizar("Dados atualizados com sucesso!", TAM));
                    Estilo.l(TAM);

                    System.out.print("Pressione qualque tecla ver os dados...");
                    sc.nextLine();

                    Estilo.limapTela();
                    cabecalho();
                    c.visualizar(al);
                    Estilo.l(142);

                    System.out.print("Pressione qualque tecla para voltar...");
                    sc.nextLine();
                    break;

                case 4: //Deletar

                    //Chamando o cabeçalho personalizado
                    cabecalho();

                    System.out.println("Nada aqui");
                    System.out.print("Pressione qualque tecla para voltar...");
                    sc.nextLine();
                    break;

                case 5:
                    rodar = false;
                    break;

                default:
                    Estilo.limapTela();
                    Estilo.l(TAM);
                    System.out.println(Estilo.centralizar("Opção inválida", TAM));
                    Estilo.l(TAM);
                    System.out.print("Pressione qualque tecla para voltar...");
                    sc.nextLine();
                    break;
            }
        }  

        Estilo.limapTela();
        Estilo.l(TAM);
        System.out.println(Estilo.centralizar("Fim do CRUD", TAM));
        Estilo.l(TAM);
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
}
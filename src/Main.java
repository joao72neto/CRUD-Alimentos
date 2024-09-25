import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.Date;
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

                    //Pegando os valores para cadastro
                    pegar_dados_cadastrar(al, sc);

                    //Limpando a tela do terminal
                    Estilo.limapTela();

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

    //Função que pega todos os dados para cadastrar um alimento
    public static void pegar_dados_cadastrar(Alimentos al, Scanner sc){
        
        ArrayList<Object> valores_inseridos = new ArrayList<>();
        ArrayList<String> nomes_colunas = new ArrayList<>();

        //Pegando todos os nomes de colunas personalizados
        nomes_colunas = Estilo.nomes_personalizados_colunas();


        int TAM = 30;
        
        //Consistido o ID
        while (true){

            //Pegando os dados do usuário
            Estilo.l(TAM);
            System.out.print("ID: ");
            int id_tabela = TratarErros.pegarInteiro(sc.nextLine());
            

            if (id_tabela == 0){
                Estilo.limapTela();
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

                TratarErros.valorInvalido("Espaços não são válidos", sc, 40);
                dados_inseridos(valores_inseridos, nomes_colunas);

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

                TratarErros.valorInvalido("Espaços não são válidos", sc, 40);
                dados_inseridos(valores_inseridos, nomes_colunas);

                continue;
            }
            
            al.setAlm_categoria(cat);
            valores_inseridos.add(cat);

            break;
        }

        //Consistindo a qtd no estoque
        while (true) {
            System.out.print("QUANTIDADE ESTOQUE:");
            int qtd_estoque = TratarErros.pegarInteiro(sc.nextLine());

            if (qtd_estoque == 0){

                //Exibindo os valores que já foram adicionados
                dados_inseridos(valores_inseridos, nomes_colunas);

                continue;
            }

            al.setAlm_quantidade_estoque(qtd_estoque); 
            valores_inseridos.add(qtd_estoque);

            break;

        }

        //Consistindo o preço
        while (true) {
            System.out.print("PREÇO: ");
            double preco = TratarErros.pegarDouble(sc.nextLine());

            if (preco == 0){

                //Mostrando valores já adicionados
                dados_inseridos(valores_inseridos, nomes_colunas);

                continue;
            }

            al.setAlm_preco(preco);
            valores_inseridos.add(preco);

            break;
        
        }

        //Consistindo a data de validade
        while (true){
            System.out.print("DATA DE VALIDADE: ");
            Date data = TratarErros.pegarData(sc.nextLine());

            if (data == null){

                //Mostrando valores já adicionados
                dados_inseridos(valores_inseridos, nomes_colunas);

                continue;
            }

            al.setAlm_data_validade(data);
            valores_inseridos.add(data);

            break;
        }

        //Consistindo a data de fabricação            
        while (true) {
            System.out.print("DATA DE FABRICAÇÃO: ");
            Date data = TratarErros.pegarData(sc.nextLine());

            if(data == null){

                //Mostrando valores já adicionados
                dados_inseridos(valores_inseridos, nomes_colunas);

                continue;
            }

            al.setAlm_data_fabricacao(data);
            valores_inseridos.add(data);

            break;
        }


        //Consistindo o peso por unidade
        while (true) {
            System.out.print("PESO POR UNIDADE: ");
            double peso_por_unidade = TratarErros.pegarDouble(sc.nextLine());

            if(peso_por_unidade == 0){

                //Mostrando valores já adicionados
                dados_inseridos(valores_inseridos, nomes_colunas);

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

                TratarErros.valorInvalido("Espaços não são válidos", sc, 40);
                dados_inseridos(valores_inseridos, nomes_colunas);

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

                TratarErros.valorInvalido("Espaços não são válidos", sc, 40);
                dados_inseridos(valores_inseridos, nomes_colunas);

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

                TratarErros.valorInvalido("Espaços não são válidos", sc, 40);
                dados_inseridos(valores_inseridos, nomes_colunas);

                continue;
            }
            
            al.setAlm_codigo_barras(codigo_barras);
            valores_inseridos.add(codigo_barras);

            break;
        }

    }

    //Mostra todos os dados que já foram inseridos para cadastro
    public static void dados_inseridos(ArrayList<Object> valores_inseridos, ArrayList<String> nomes_colunas){
        //Mostrando valores já adicionados
        Estilo.limapTela();
        Estilo.l(30);

        int i=0;

        for(Object valor : valores_inseridos){
            System.out.println(nomes_colunas.get(i) + ": " + valor);
            i++;
        }
    }

}
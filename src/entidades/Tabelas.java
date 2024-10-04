package entidades;

import java.lang.reflect.Field;
import java.util.ArrayList;

public abstract class Tabelas {

    //Métodos a serem implementados
    public abstract String getNomeTabela();
    

    //Método que pega todos os valores das colunas de uma tabela
    public ArrayList<Object> getValorColunas(Object obj) {

        ArrayList<Object> valorColunas = new ArrayList<>();

        //Guardando os atributos declarados
        Field[] campos = obj.getClass().getDeclaredFields();
        for (Field campo : campos){
            campo.setAccessible(true);
            try{
                valorColunas.add(campo.get(obj));
            }catch(IllegalAccessException e){
                System.out.println("Erro: " + e.toString());
            }  
        }

        return valorColunas;
    }

    //Método que retorna todos os nomes das colunas de uma tabela
    public ArrayList<String> getNomeColunas(Object obj) {
        
        ArrayList<String> nomeColunas = new ArrayList<>();

        //Guardando os atributos declarados
        Field[] campos = obj.getClass().getDeclaredFields();
        for (Field campo : campos){
            campo.setAccessible(true);
            nomeColunas.add(campo.getName());
        }
        
        return nomeColunas;
    }
}

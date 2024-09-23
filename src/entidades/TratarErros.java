package entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TratarErros {
    
    //Função que lê apenas valores inteiros
    public int pegarInteiro(Object valor){
        if(valor instanceof Integer){
            return (int) valor;
        }else{
            return 0;
        }
    }

    //Função que lê apenas valores double
    public double pegarDouble(Object valor){
        if(valor instanceof Double){
            return (double) valor;
        }else{
            return 0;
        }
    }


    //Função que le datas no formato yyyy-mm-dd
    public Date pegarData(Object valor){
        String data = (String) valor;
        
        //padrão de formatação
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        //Tentando converter para data
        try {
            LocalDate ld = LocalDate.parse(data, formato);
            return Date.valueOf(ld);
        } catch (Exception e) {
            System.out.println("Formato de data inváldo");
            return null;
        }
    }
}

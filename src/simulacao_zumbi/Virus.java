/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacao_zumbi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Victor
 */
public class Virus {

    private  Integer segundos;
    private  Integer minutos;
    
    
    // Logica para o tempo de 15 segunos, é setado os valores do minuto e segundos da criação do objeto
    public Virus() {
         LocalDateTime primeiro = LocalDateTime.now();
         segundos = primeiro.getSecond();
         minutos = primeiro.getMinute();
    }
    
    
    // O método getTime tem como objetivo verificar o tempo de criaçãp do objeto que utiliza a Classe virus
    // Caso o tempo seja maior que 15s é retornado true, caso seja menor que 15s é retornado false
    public boolean getTime(){
        LocalDateTime segundo = LocalDateTime.now();
        int segundos_atual = segundo.getSecond();
        int minutos_atual = segundo.getMinute();
        
        if(minutos_atual > this.minutos && this.segundos <= 45){
            return true;
        }
        else if(minutos == minutos_atual && ((segundos_atual - this.segundos)>=15)){
            return true;
        }
        else if(minutos_atual> this.minutos && this.segundos>45){
            if(((60-this.segundos)+segundos_atual)>=15){
                return true;
            }else{
                return false;
            }
        }else
            return false;
    }
   
}

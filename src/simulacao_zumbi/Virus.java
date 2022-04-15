/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacao_zumbi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Victor
 */
public class Virus {

    private Integer segundos;

    public Virus() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("ss");
        Integer horaFormatada = Integer.parseInt(formatterHora.format(agora));
        this.segundos = horaFormatada;
    }
    
    // Colocar o temporizador nesa calsse
    public Integer getTime(){
        
       return this.segundos;
    }
   
}

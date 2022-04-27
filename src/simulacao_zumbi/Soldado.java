/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacao_zumbi;

import java.util.Random;

/**
 *
 * @author Victor
 */
public class Soldado extends Pessoa implements IMovable {
    
    public Soldado(Integer x, Integer y){
        super(x,y,6);
    }
    
    
    // Método para realizar a movimentação dos soldados
    @Override
    public void mover() {
        Random gerador = new Random();
        
        int rd = gerador.nextInt(4);
        
        if(rd == 2){
        if(this.getX()==28){
              this.setX(1);
           }else
           this.setX(this.getX() +1);
        }
        else if (rd ==3){
            if(this.getX()==1){
                this.setX(28);
            }else
            this.setX(this.getX()-1);
        }
        else if (rd == 0){
            if(this.getY()==88){
                this.setY(1);
            }else
            this.setY(this.getY() +1);
        }
        else if (rd ==1){
            if(this.getY()==1){
                this.setY(88);
            }else
            this.setY(this.getY()-1);
        }
    }
    
}

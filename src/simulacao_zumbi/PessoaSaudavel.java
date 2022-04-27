
package simulacao_zumbi;

import java.util.Random;

/**
 *
 * @author Victor
 */
public class PessoaSaudavel extends Pessoa implements IMovable{

    public PessoaSaudavel(Integer x, Integer y) {
        super(x, y, 3);
    }
    
    
    // Método para realizar a movimentação das Pessoas Saúdaveis
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

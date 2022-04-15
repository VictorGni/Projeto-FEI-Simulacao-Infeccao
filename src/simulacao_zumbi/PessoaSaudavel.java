
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

    @Override
    public void mover() {
        Random gerador = new Random();
        
        int rd = gerador.nextInt(4);
        
        if(rd == 0){
           this.setX(this.getX() +1);
        }
        else if (rd ==1){
            this.setX(this.getX()-1);
        }
        else if (rd == 2){
            this.setY(this.getY() +1);
        }
        else if (rd ==3){
            this.setY(this.getY()-1);
        }
    }
    
    
}

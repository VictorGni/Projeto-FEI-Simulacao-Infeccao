
package simulacao_zumbi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Victor
 */
public class PessoaDoente extends Pessoa implements IMovable {

    private Virus virus;
    
    public PessoaDoente(Integer x, Integer y) {
        super(x, y, 4);
        this.virus = new Virus();
    }
    
    public PessoaDoente(Integer x, Integer y, Integer cor){
        super(x,y,cor);
    }

   
    public Integer time(){
        return virus.getTime();
    }
    
    @Override
    public void mover() {
        
    }
    
}

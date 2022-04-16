
package simulacao_zumbi;

/**
 *
 * @author Victor
 */
public class Simulacao_Jumbi {


    public static void main(String[] args) throws InterruptedException{
       
       
        Mundo md = new Mundo();
        PessoaDoente pd = new PessoaDoente(2,2);
        
        
        
        //Teste imprimir mundo
        int i=0;
        while(i<5){
            
            //System.out.println(pd.getTime());
            md.desenhaMundo();
            Thread.sleep(4000);
            i++;
        }
            

        
    }
    
}

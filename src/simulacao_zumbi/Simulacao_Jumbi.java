
package simulacao_zumbi;

/**
 *
 * @author Victor
 */
public class Simulacao_Jumbi {


    public static void main(String[] args){
       
       
        Mundo md = new Mundo();
        
        
        
        //Teste imprimir mundo
        while(true){
            System.out.println(md.quantidadePd());
            System.out.println(md.quantidadePs());
            System.out.println(md.quantidadeZb());
            md.desenhaMundo();
            md.mover();
            try{
                Thread.sleep(300);
            }
            catch(Exception e){
                System.out.print("");
            }
  
    }
    
}
}

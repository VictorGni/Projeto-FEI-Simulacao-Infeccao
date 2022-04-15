
package simulacao_zumbi;

/**
 *
 * @author Victor
 */
public class Simulacao_Jumbi {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
   
    public static void main(String[] args){
       
       
        Mundo md = new Mundo();
        
        
        // Teste imprimir mundo
        int i=0;
        while(i<3){
            md.desenhaMundo();
            i++;
        }
    }
    
}

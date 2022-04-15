
package simulacao_zumbi;

import java.io.IOException;

/**
 *
 * @author Victor
 */
public class Simulacao_Jumbi {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
   
    public static void main(String[] args) throws IOException, InterruptedException {
       
        PessoaDoente pd =  new PessoaDoente(3,4);
        Zumbi zb = new Zumbi(7,8);
        PessoaSaudavel ps = new PessoaSaudavel(25,50);
       
        Mundo md = new Mundo();
        int i=0;
        while(i<3){
        md.desenhaMundo();
          try
        {
            Runtime.getRuntime().exec("cmd /c limpa.bat");
        }
        catch(Exception e)
        {
            System.out.println("Erro");
        }
          
         i++; 
        }
    }
    
}

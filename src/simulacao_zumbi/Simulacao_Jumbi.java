
package simulacao_zumbi;

/**
 *
 * @author Victor
 */
public class Simulacao_Jumbi {


    public static void main(String[] args){
       
        int stop=0;
        Mundo md = new Mundo();
        
        
        
        //Teste imprimir mundo
        while(stop ==0){
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Quantidade de pessoas Saúdaveis: " + md.quantidadePessoaSaudavel());
            System.out.println("Quantidade de pessoas Doentes: " + md.quantidadePessoaDoente());
            System.out.println("Quantidade de Zumbis: " + md.quantidadeZumbi());
            md.desenhaMundo();
            md.mover();
            try{
                Thread.sleep(300);
            }
            catch(Exception e){
                System.out.print("");
            }
            
            if(md.quantidadeZumbi()==102){
                
                for(int x=0; x<10; x++){
                    System.out.println();
                }
                
                
                try{
                    System.out.println("OS SOLDADOS CHEGARAM PARA ELIMINAR OS ZUMBIS!!!");
                for(int x=0; x<10; x++){
                    System.out.println();
                }
                    Thread.sleep(2000);

                    
                }
                catch(Exception e){
                    System.out.print("");
                }
                
                
                while(true){
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("Quantidade de Zumbis: " + md.quantidadeZumbi());
                    md.solucaoSoldado();
                    md.mover();
                    try{
                        Thread.sleep(300);
                    }
                    catch(Exception e){
                        System.out.print("");
                    }
                    if(md.quantidadeZumbi()==0){
                        stop++;
                        break;
                    }
                }
                
            }
  
        }
        
        for(int x=0; x<10; x++){
           System.out.println();
        }
        System.out.println("FIM DA SIMULAÇÃO , OS SOLDADOS CONSEGUIRAM ELIMINAR TODOS OS ZUMBIS!!");
    
}
}

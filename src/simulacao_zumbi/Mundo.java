
package simulacao_zumbi;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Victor
 * Classe mundo utilizada para criação do mapda da simulação
 */


public class Mundo {

//Variaveis para alteração de cor de fundo e de texto
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String IDK_BACKGROUND = "\u001B[45m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_GREEN = "\u001B[32m";
 ///////////////////////////////////////////////////////////////////////
 
 // Valor statico para teste de criar 100 objetos com o For
    
    static int valor =0;
///////////////////////////////////////////////////////////////////////
 
    
// Variaveis utilizadas para criação do for do mapa do jogo
    
   final int  x_map = 30;
   final int y_map = 90;
/////////////////////////////////////////////////////////////////////// 
   
   
// Criação de um objeto pessoa saudavel, uma lista e a matriz para o mapa;
    private PessoaSaudavel p1;
    ArrayList<PessoaSaudavel> ps = new ArrayList();
    private Integer[][] mapa = new Integer[x_map][y_map];
    
    
    
    
//  Metodo para realizar logica e imprimir o mundo
    public void desenhaMundo(){
        
        // Teste de instaciar 100 objetos utilizando a variavei estatica "valor" para verificar se os mesmos ja 
        // aviam sidos criados
        if(valor ==0){
              for(Integer z=0; z<6; z++){
                Random gerador = new Random();
                int rdx = gerador.nextInt(31);
                int rdy = gerador.nextInt(91);

                p1 =  new PessoaSaudavel(rdx,rdy);
                ps.add(p1);
                valor++;
            }
        }
        
        // For para utilizar o metodo mover da pessoa saudavel
        for(PessoaSaudavel pp: ps){
            pp.mover();
        }
        
        
        
        // Logica para setor os valores na matriz
        for(int x =0; x<x_map; x++){
            for(int y=0; y<y_map; y++){
                
                if((x==0 || x== 29) ||(y==0 || y==89) ){
                    mapa[x][y]=1;
                }
                
                else if((x>5 && x<=10) && (y>10 && y<=30)){
                    mapa[x][y]=2;
                }
                
                else if((x>5 && x<=10) && (y>56 && y<=76)){
                    mapa[x][y]=2;
                }
                
                else if((x>18 && x<=23) && (y>32 && y<=52)){
                    mapa[x][y]=2;
                }
                
                else
                    mapa[x][y]=0;
                
                
                //For para verificar as posições dos objetos(x e y) e setar na matriz suas cores
                for(PessoaSaudavel pessoa : ps){
                    if(x == pessoa.getX() && y == pessoa.getY()){
                        mapa[x][y] = pessoa.getCor();
                    }
                }
            }
   
        }
        
        
        
        
        // For utilizado para imprimir a matriz com a logica de suas respectivas cores por valor
        // 1 - branco
        // 2 - verde
        // 3 - rosa
        for(int x =0; x<x_map; x++){
           for(int y=0; y<y_map; y++){
                if(mapa[x][y]==1){
                    System.out.print(ANSI_WHITE);
                    System.out.print(WHITE_BACKGROUND);
                    System.out.print(mapa[x][y]);
                    System.out.print(ANSI_RESET);
                }
                else if(mapa[x][y]==2){
                    System.out.print(ANSI_GREEN);
                    System.out.print(GREEN_BACKGROUND);
                    System.out.print(mapa[x][y]);
                    System.out.print(ANSI_RESET);
                }
                else if (mapa[x][y]== 3){
                    System.out.print(IDK_BACKGROUND);
                    System.out.print(mapa[x][y]);
                    System.out.print(ANSI_RESET);
                }
                else{
                    System.out.print(BLACK_BACKGROUND);
                    System.out.print(ANSI_BLACK);
                    System.out.print(mapa[x][y]);
                } 

            }
            System.out.println();
         }
        
        
        
    }
}

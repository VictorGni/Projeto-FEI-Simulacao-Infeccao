
package simulacao_zumbi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public static final String BLUE_BACKGROUND= "\u001B[44m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RED= "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
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
    ArrayList<PessoaSaudavel> ps = new ArrayList<>();
    private Integer[][] mapa = new Integer[x_map][y_map];
    
    private PessoaDoente pt1 = new PessoaDoente(15,45);
    private PessoaDoente pt2 = new PessoaDoente(18,40);
    ArrayList<PessoaDoente> pd = new ArrayList<>();
    
    ArrayList<Zumbi> zb= new ArrayList<>();
    
//  Metodo para realizar logica e imprimir o mundo
    public void desenhaMundo(){
        
        // Teste de instaciar 100 objetos utilizando a variavei estatica "valor" para verificar se os mesmos ja 
        // aviam sidos criados
        if(valor ==0){
            Random gerador = new Random();
              for(Integer z=0; z<100; z++){
                int rdx = gerador.nextInt(26)+1;
                int rdy = gerador.nextInt(86)+1;

                p1 =  new PessoaSaudavel(rdx,rdy);
                ps.add(p1);
                valor++;
            }
            pd.add(pt1);
            pd.add(pt2);
         
           
        }
        
        
        
        // For para utilizar o metodo mover da pessoa saudavel
        for(PessoaSaudavel pp: ps){
            pp.mover();
        }
        
        //For para pessoas doentes se moverem
        for(PessoaDoente pp: pd){
            pp.mover();
        }
        
        // Verifica se a lista não está vazia, caso não esteja utiliza a função mover
        if(zb!=null){
            for(Zumbi zumbi: zb){
                zumbi.mover();
            }
        }
        
        
        // Logica para contrução do mapa
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
            }
   
        }
        
        
         //For para verificar as posições dos objetos(x e y)das pessoas doentes e setar na matriz suas cores
        for(PessoaDoente pessoa: pd){
            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("ss");
            Integer horaFormatada = Integer.parseInt(formatterHora.format(agora));
            Integer tempo_final = horaFormatada - pessoa.getTime();
           if(tempo_final >= 15){
               Zumbi temp =  new Zumbi(pessoa.getX(),pessoa.getY());
               deletaObj(pessoa);
               //pd.remove(pessoa);
               //zb.add(temp);
               insereObj(temp);
               mapa[temp.getX()][temp.getY()] = temp.getCor();
               
           }else
                mapa[pessoa.getX()][pessoa.getY()] = pessoa.getCor();
        }

        //For para verificar as posições dos objetos(x e y)das pessoas saudaveis e setar na matriz suas cores
        for(PessoaSaudavel pessoa : ps){
            mapa[pessoa.getX()][pessoa.getY()] = pessoa.getCor();
//           if(mapa[pessoa.getX()][pessoa.getY()]==4){
//               PessoaDoente temp = new PessoaDoente(pessoa.getX(),pessoa.getY());
//               pd.add(new PessoaDoente(pessoa.getX(),pessoa.getY()));
//               ps.remove(pessoa);
//           }
//           else{
//               mapa[pessoa.getX()][pessoa.getY()] = pessoa.getCor();
//           }
                
        }
        
//        if(zb != null){
//            for(Zumbi zumbi: zb){
//                mapa[zumbi.getX()][zumbi.getY()] = zumbi.getCor();
//            }
//        }
                

            
        
        // For utilizado para imprimir a matriz com a logica de suas respectivas cores por valor
        // 1 - branco
        // 2 - verde
        // 3 - azul
        // 4 - amarelo
        // 5 - vermelho
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
                    System.out.print(BLUE_BACKGROUND);
                    System.out.print(ANSI_BLUE);
                    System.out.print(mapa[x][y]);
                    System.out.print(ANSI_RESET);
                }
                
                else if (mapa[x][y]== 4){
                    System.out.print(YELLOW_BACKGROUND);
                    System.out.print(ANSI_YELLOW);
                    System.out.print(mapa[x][y]);
                    System.out.print(ANSI_RESET);
                }
                
                else if (mapa[x][y]== 5){
                    System.out.print(RED_BACKGROUND);
                    System.out.print(ANSI_RED);
                    System.out.print(mapa[x][y]);
                    System.out.print(ANSI_RESET);
                }
                else{
                    System.out.print(BLACK_BACKGROUND);
                    System.out.print(ANSI_BLACK);
                    System.out.print(mapa[x][y]);
                    System.out.print(ANSI_RESET);
                } 

            }
            System.out.println();
         }
        
        
        
    }
    
    
    public void deletaObj(PessoaDoente doente){
        pd.remove(doente);
    }
    
    public void insereObj(Zumbi zumbi){
        zb.add(zumbi);
    }
}

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
    public static final String WHITE_BACKGROUND = "\033[47m \033[0m";
    public static final String GREEN_BACKGROUND = "\033[42m \033[0m";
    public static final String BLUE_BACKGROUND= "\033[44m \033[0m";
    public static final String YELLOW_BACKGROUND = "\033[43m \033[0m";
    public static final String RED_BACKGROUND = "\033[41m \033[0m";
 ///////////////////////////////////////////////////////////////////////
 
 // Valor statico para teste de criar 100 objetos com o For
    
    static int valor =0;
    static int valor_soldado =0;
///////////////////////////////////////////////////////////////////////
 
    
// Variaveis utilizadas para criação do for do mapa do jogo
    
   final int  x_map = 30;
   final int y_map = 90;
/////////////////////////////////////////////////////////////////////// 
   
   
// Criação de um objeto pessoa saudavel, uma lista e a matriz para o mapa;
    private ArrayList<PessoaSaudavel> ps = new ArrayList<>();
    private Integer[][] mapa = new Integer[x_map][y_map];
    private PessoaDoente pt1 = new PessoaDoente(15,5);
    private PessoaDoente pt2 = new PessoaDoente(18,65);
    private ArrayList<PessoaDoente> pd = new ArrayList<>();
    private ArrayList<Soldado> soldados = new ArrayList<>();
    
    private ArrayList<Zumbi> zb= new ArrayList<>();
    

    
//  Metodo para realizar logica e imprimir o mundo
    public void desenhaMundo(){
        
        // Teste de instaciar 100 objetos utilizando a variavei estatica "valor" para verificar se os mesmos ja 
        // aviam sidos criados
        if(valor ==0){
            Random gerador = new Random();
              for(Integer z=0; z<100; z++){
                int rdx = gerador.nextInt(27)+1;
                int rdy = gerador.nextInt(86)+1;

                ps.add(new PessoaSaudavel(rdx,rdy));
                valor++;
            }
            pd.add(pt1);
            pd.add(pt2);
         
           
        }
     
        
        
        // Logica para contrução do mapa
        for(int x =0; x<x_map; x++){
            for(int y=0; y<y_map; y++){
                
                if((x==0 || x== 29) ||(y==0 || y==89) ){
                    mapa[x][y]=1;
                }
                
                else if((x>5 && x<=8) && (y>10 && y<=20)){
                    mapa[x][y]=2;
                }
                
                else if((x>5 && x<=8) && (y>56 && y<=66)){
                    mapa[x][y]=2;
                }
                
                else if((x>18 && x<=21) && (y>32 && y<=42)){
                    mapa[x][y]=2;
                }
                
                else
                    mapa[x][y]=0;
            }
   
        }
        
        
        
        //Lista temporaria para realizar a lógica de instaciar pessoa doentes          
        ArrayList<PessoaDoente> pd_temp = new ArrayList<>();
        

        
        
        //Percorrer a lista de pessoa doente para verificar se há algum que virou zumbi
        for(PessoaDoente pessoa: pd){
              if(pessoa.getTime() && mapa[pessoa.getX()][pessoa.getY()]!=2){
                 Zumbi temp =  new Zumbi(pessoa.getX(),pessoa.getY());
                 zb.add(temp);
              }
              else if( pessoa.getTime()==false && mapa[pessoa.getX()][pessoa.getY()] == 2 ){
                  ps.add(new PessoaSaudavel(pessoa.getX(),pessoa.getY()));
              }
              else{
               pd_temp.add(pessoa);
           }
        }
        
        
        //Atualizando a lista principal
        pd.clear();
        pd = pd_temp;
        
       
        
        //For para setar as pessoas doentes no mapa
        for(PessoaDoente pessoa: pd){
            mapa[pessoa.getX()][pessoa.getY()] = pessoa.getCor();
        }
        
        //For para setar os zumbis na tela
        if(zb != null){
            for(Zumbi zumbi: zb){
                mapa[zumbi.getX()][zumbi.getY()] = zumbi.getCor();
            }
        }
        
        
        //Lista temporária para adicionar pessoas saudaveis
        ArrayList<PessoaSaudavel> ps_temp = new ArrayList<>();

        //For para verificar as posições dos objetos(x e y)das pessoas saudaveis e setar na matriz suas cores
        for(PessoaSaudavel pessoa : ps){
            if(mapa[pessoa.getX()][pessoa.getY()]== 4 || mapa[pessoa.getX()][pessoa.getY()]== 5 ){
                pd.add(new PessoaDoente(pessoa.getX(),pessoa.getY()));
            }
            else if (mapa[pessoa.getX() +1 ][pessoa.getY()]== 4 || mapa[pessoa.getX() +1 ][pessoa.getY()]== 5 ){
                pd.add(new PessoaDoente(pessoa.getX()+1,pessoa.getY()));
            }
            else if (mapa[pessoa.getX() -1 ][pessoa.getY()]== 4 || mapa[pessoa.getX() -1 ][pessoa.getY()]== 5){
                pd.add(new PessoaDoente(pessoa.getX()-1,pessoa.getY()));
            }
            else if (mapa[pessoa.getX()][pessoa.getY()+1]== 4 || mapa[pessoa.getX()][pessoa.getY()+1]== 5){
                pd.add(new PessoaDoente(pessoa.getX(),pessoa.getY()+1));
            }
             else if (mapa[pessoa.getX()][pessoa.getY()-1]== 4 || mapa[pessoa.getX()][pessoa.getY()-1]== 5){
                pd.add(new PessoaDoente(pessoa.getX(),pessoa.getY()-1));
            }
             else{
                 ps_temp.add(pessoa);
             }
                
        }
        
        
        //Atualiza a lista original
        ps.clear();
        ps = ps_temp;
        

        
        
        // For para setar as pessoas saudaveis
        for(PessoaSaudavel pessoa : ps){
         
           mapa[pessoa.getX()][pessoa.getY()] = pessoa.getCor();
        }

        
        
        //Lógica dos soldados (Solução dos problemas)
        if(this.quantidadeZb()==102 && valor_soldado==0){
            Random aleatorio = new Random();
            for(int x=0;x<10;x++){
               int rdx = aleatorio.nextInt(27)+1;
               int rdy = aleatorio.nextInt(86)+1;

               soldados.add(new Soldado(rdx,rdy)); 
            }
            valor_soldado++;
        }
        
        this.imprimirMapa();
        
     }
        
    public void imprimirMapa(){ 
        // For utilizado para imprimir a matriz com a logica de suas respectivas cores por valor
        // 1 - branco
        // 2 - verde
        // 3 - azul
        // 4 - amarelo
        // 5 - vermelho
        for(int x =0; x<x_map; x++){
           for(int y=0; y<y_map; y++){
                if(mapa[x][y]==1){
                    System.out.print(WHITE_BACKGROUND);
                    System.out.print(ANSI_RESET);
                }
                else if(mapa[x][y]==2){
                    System.out.print(GREEN_BACKGROUND);
                    System.out.print(ANSI_RESET);
                }
                else if (mapa[x][y]== 3){
                    System.out.print(BLUE_BACKGROUND);
                    System.out.print(ANSI_RESET);
                }
                
                else if (mapa[x][y]== 4){
                    System.out.print(YELLOW_BACKGROUND);
                    System.out.print(ANSI_RESET);
                }
                
                else if (mapa[x][y]== 5){
                    System.out.print(RED_BACKGROUND);
                    System.out.print(ANSI_RESET);
                }
                else{
                    System.out.print(" ");
                    System.out.print(ANSI_RESET);
                } 

            }
            System.out.println();
            
         }
  
 
    }
    
    
   public void mover(){
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
   }
   
   
   public int quantidadePs(){
       return ps.size();
   }
   
   public int quantidadePd(){
       return pd.size();
   }
   
   public int quantidadeZb(){
       return zb.size();
   }

   
   
   
   
   
   
   
}
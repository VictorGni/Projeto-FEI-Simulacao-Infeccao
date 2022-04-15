
package simulacao_zumbi;

/**
 *
 * @author Victor
 */
public class Mundo {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String IDK_BACKGROUND = "\u001B[45m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_GREEN = "\u001B[32m";
    
    
    int x_map = 30;
    int y_map = 90;
    PessoaSaudavel sd = new PessoaSaudavel(12,25);
    private Integer[][] mapa = new Integer[x_map][y_map];
    
   
    public void teste(){
        System.out.println(sd.getX() + " " + sd.getY() + " " + sd.getCor());
    }
    
    
    public void desenhaMundo(){
        sd.mover();
        for(int x =0; x<x_map; x++){
            for(int y=0; y<y_map; y++){
                
                if((x==0 || x== 29) ||(y==0 || y==89) ){
                    mapa[x][y]=1;
                }

                else if(x == (sd.getX())  && y == (sd.getY())){
                    mapa[x][y] = (sd.getCor());
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

import java.util.Scanner;

public class GameBoard {
    int boardSize;
    Player player1 ;
    Player player2 ;
    char[][] board;
    
    GameBoard(int boardSize , Player player1 , Player player2, char[][] board){
        this.boardSize = boardSize;
        this.player1 = player1;
        this.player2 = player2;
        this.board = new char[boardSize][boardSize];
    }
    
    void start(){

        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                board[i][j]=' ';
            }
        }
        
        boolean[][] vis = new boolean[boardSize][boardSize];
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                vis[i][j]=false;
            }
        }
        int chances = 0;
        while(true){
            if(chances == boardSize*boardSize){
                System.out.println("Match is drawn");
                break;
            }
            chances++;
            Scanner input1 = new Scanner(System.in);
            Scanner input2 = new Scanner(System.in);
            int row = input1.nextInt();
            int col = input2.nextInt();
            
            // Error Handling
            if(row>=boardSize || row<0 || col>=boardSize || col<0){
                chances--;
                System.out.println("Give input in the size of board " + boardSize);
                continue;
            }
            if(vis[row][col]==true){
                chances--;
                System.out.println("Position already filled, try some other space");
                printBoard();
                continue;
            }
            vis[row][col]=true;
            if(chances%2==0){
                board[row][col] = player1.playerSymbol;
            }
            else{
                board[row][col] = player2.playerSymbol;
            }
            printBoard();
            System.out.println("Board after Move");
            if(chances<=boardSize*boardSize && endGame(board,boardSize,row,col)){
                if(chances%2==0){
                    System.out.println(player1.name + " is winner");
                }
                else{
                    System.out.println(player2.name + " is winner");
                }
                input1.close();
                input2.close();
            }
            

        }



    }
    boolean endGame(char board[][], int boardSize,int row,int col){
        boolean flag=true;
        for(int i=0;i<boardSize;i++){
            if(board[i][col]!=board[row][col]){
                flag=false;
                break;
            }
        }
        if(flag){
            System.out.println("col");
            return true;
        }
        flag=true;
        for(int i=0;i<boardSize;i++){
            if(board[row][i]!=board[row][col]){
                flag=false;
                break;
            }
        }
        if(flag){
            System.out.println("row");
            return true;
        }
        
        if(row==col || row+col==boardSize-1){
            flag=true;
            //System.out.println("In condition");
            if((row<boardSize/2 && col<boardSize/2) || (row>boardSize/2 && col>boardSize/2)){
                for(int i=0;i<boardSize;i++){
                    if(board[i][i]!=board[row][col]){
                        flag=false;
                        break;
                    }
                }
            }
            else{
                for(int i=0;i<boardSize;i++){
                    if(board[i][boardSize-(1+i)]!=board[row][col]){
                        flag=false;
                        break;
                    }
                }
            }
            return flag;
        }
        else{
            return false;
        }
        

    }
    void printBoard(){
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println("");
        }
    }
    

}

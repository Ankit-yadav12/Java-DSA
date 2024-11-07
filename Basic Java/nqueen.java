public class nqueen {
    //check condition for adding queen
    public static Boolean isSafe(char chessBoard[][], int row, int column){
        //vertical up
        for(int i = row-1;i>=0;i--){
            if(chessBoard[i][column] == 'Q'){
                return false;
            }
        }

        //left diagonal
        for(int i = row-1, j = column-1; i>=0 && j>= 0;i--, j--){
            if(chessBoard[i][j] == 'Q'){
                return false;
            }
        }

        //right diagonal
        for(int i = row-1, j = column+1; i>=0 && j< chessBoard.length;i--, j++){
            if(chessBoard[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    //place queen
    public static void placeQueen(char chessBoard[][], int row){
        // base case
        if(row == chessBoard.length){
            print(chessBoard);
            return;
        }

        for(int j = 0;j<chessBoard.length;j++){
            if(isSafe(chessBoard, row, j)){
                chessBoard[row][j] = 'Q';
                placeQueen(chessBoard, row+1);
                chessBoard[row][j] = 'X';
            }
        }
    }

    //print array function
    public static void print(char chessBoard[][]){
        System.out.println("-------chess Board--------------");
        for(int i = 0;i<chessBoard.length;i++){
            for(int j = 0;j<chessBoard.length;j++){
                System.out.print(chessBoard[i][j] + " ");
            }System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char chessBoard[][] = new char[n][n];

        // filling the chess board
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                chessBoard[i][j] = 'X';
            }
        }

        placeQueen(chessBoard , 0);
    }
}

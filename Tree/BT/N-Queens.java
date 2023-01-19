import java.util.Scanner;
public class MyClass {
    public static void main(String args[]) 
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] board= new int[n][m];
    
        boolean[] col= new boolean[n];
        boolean[] ndiag=new boolean[2*n-1];
        boolean[] rdiag=new boolean[2*n-1];
        
        solution(board,0,col,ndiag,rdiag);
    }
    public static void solution(int[][] board,int row,boolean[] col,boolean[] ndiag,boolean[] rdiag)
    {
        if(row==board.length)
        {
           for(int i=0; i<board.length; i++)
           {
                for(int j=0; j<board.length; j++)
                {
                   System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }
        for(int column=0; column<board.length; column++)
        {
           if(col[column]==false && ndiag[row+column]==false && rdiag[row-column+board.length-1]==false)
           {
               board[row][column]=1;
               col[column]=true;
               ndiag[row+column]=true;
               rdiag[row-column+board.length-1]=true;
               solution(board,row+1,col,ndiag,rdiag);
               board[row][column]=0;
               col[column]=false;
               ndiag[row+column]=false;
               rdiag[row-column+board.length-1]=false;
           }
       }
    }
}
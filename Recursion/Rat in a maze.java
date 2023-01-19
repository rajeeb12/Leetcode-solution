// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static void solve(int i,int j , int[][] m, int n, ArrayList<String> res,String s,int[][] visited)
    {
        
        if(i == n-1 && j == n-1)
        {
            res.add(s);
            return;
        }
        if(i+1 <n && visited[i+1][j]==0 && m[i+1][j]==1)
        {
            visited[i][j]=1;
            solve(i+1 ,j , m , n , res , s+'D', visited);
            visited[i][j]=0;
        }
        if(j-1 >=0 && visited[i][j-1] == 0 && m[i][j-1]==1)
        {
            visited[i][j]=1;
            solve(i , j-1 , m , n , res , s+'L' , visited);
            visited[i][j]=0;
        }
        if(j+1 <n && visited[i][j+1] == 0 && m[i][j+1]==1)
        {
            visited[i][j]=1;
            solve(i , j+1 , m , n , res , s+'R' , visited);
            visited[i][j]=0;
        }
        if(i-1 >=0 && visited[i-1][j] == 0 && m[i-1][j]==1)
        {
            visited[i][j]=1;
            solve(i-1 , j , m , n , res , s+'U' , visited);
            visited[i][j]=0;
        }
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        int[][] visited= new int[n][n];
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            visited[i][j] = 0;
          }
        }
        if(m[0][0]==1)  
            solve(0,0,m,n,res,"",visited);
        return res;
    }
    
}
// used extra two array for calculating down left right up

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static void solve(int i,int j , int[][] m, int n, ArrayList<String> res,String s,int[][] visited,int[] di,int[] dj)
    {
        
        if(i == n-1 && j == n-1)
        {
            res.add(s);
            return;
        }
        String move= "DLRU";
        for(int start=0; start<4; start++)
        {
            int nexti = i + di[start];
            int nextj = j + dj[start];
            
            if(nexti >=0 && nextj>=0 && nexti<n && nextj<n && visited[nexti][nextj]==0 && m[nexti][nextj]==1)
            {
                visited[i][j]=1; 
                solve(nexti,nextj,m,n,res,s+move.charAt(start),visited,di,dj);
                visited[i][j]=0;
            }
        }
        
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        int[][] visited= new int[n][n];
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            visited[i][j] = 0;
          }
        }
        int[] di= {1,0,0,-1};
        int[] dj= {0,-1,1,0};
        if(m[0][0]==1)  
            solve(0,0,m,n,res,"",visited,di,dj);
        return res;
    }
}
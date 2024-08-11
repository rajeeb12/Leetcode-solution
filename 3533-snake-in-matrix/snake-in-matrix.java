class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int di[] = {1,-1,0,0};
        int dj[] = {0,0,1,-1};
        int arr[][] = new int[n][n];
        
        int num = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j]= num;
                num++;
            }
        }
        int i = 0, j = 0;
        for(String c: commands)
        {
            if(c.equals("UP")){
                i--;
            }else if(c.equals("DOWN")){
                i++;
            }else if(c.equals("LEFT")){
                j--;
            }else{
                j++;
            }
        }
        return arr[i][j];
    }
}
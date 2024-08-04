class neighborSum {
    int arr[][];
    int n, m;
    public neighborSum(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        arr = new int[n][m];
        for(int i = 0 ; i < n; i ++){
            for(int j = 0; j < m; j++){
                arr[i][j] = grid[i][j];
               
            }
        }
    }
    
    public int adjacentSum(int value) {
        
        int i = 0 , j = 0;
        boolean found = false;
        for(i = 0; i < n; i++){
            for(j = 0; j < m; j++){
                if(arr[i][j] == value){
                    found = true;
                    break;
                }
            }
            if(found) break;
        }
        
        int sum = 0;
        if(i - 1 >= 0)
        {
            sum += arr[i - 1][j];
        }
        if(i + 1 < n){
            sum += arr[i + 1][j];
        }
        if(j - 1 >= 0){
            sum += arr[i][j - 1];
        }
        if(j + 1 < m){
            sum += arr[i][j + 1];
        }
        return sum;
    }
    
    public int diagonalSum(int value) {
        int i = 0 , j = 0;
        boolean found = false;
        for(i = 0; i < n; i++){
            for(j = 0; j < n; j++){
                if(arr[i][j] == value){
                    found = true;
                    break;
                }
            }
            if(found) break;
        }
        int sum = 0;
        if(i - 1 >= 0 && j - 1 >= 0)
        {
            sum += arr[i - 1][j - 1];
        }
        if(i + 1 < n && j + 1 < m){
            sum += arr[i + 1][j + 1];
        }
        if(j + 1 < m && i - 1 >= 0){
            sum += arr[i - 1][j + 1];
        }
        if(j - 1 >= 0 && i + 1 < n){
            sum += arr[i + 1][j - 1];
        }
        return sum;
    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */
class SubrectangleQueries {
    int arr[][];
    public SubrectangleQueries(int[][] rectangle) {
        int n = rectangle.length;
        int m = rectangle[0].length;
        arr = new int[n][m];
        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                arr[i][j] = rectangle[i][j];
            }
        }
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        if(row1 == row2)
        {
            for(int j = col1 ; j <= col2; j++)
            {
                arr[row1][j] = newValue;
            }
        }else if(col1 == col2)
        {
            for(int j = row1 ; j <= row2; j++)
            {
                arr[j][col1] = newValue;
            }
        }
        else
        {
            for(int i = row1; i <= row2; i++)
            {
                for(int j = col1; j <= col2; j++)
                {
                    arr[i][j]= newValue;
                }
            }
        }
    }
    
    public int getValue(int row, int col) {
        return arr[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
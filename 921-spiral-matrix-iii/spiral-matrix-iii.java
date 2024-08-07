class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        List<int[]> temp = new ArrayList<>();
        int right = 1, down = 1, left = 2, up = 2;

        int totalElement = rows * cols;
        int ans[][]= new int[totalElement][2];
        int index = 0;
        ans[index][0] = rStart;
        ans[index][1] = cStart;
        index++;
        totalElement--;
        while(totalElement != 0){
            // right
            for(int r = 0; r < right; r++){
                cStart += 1;
                if( (rStart >= 0 &&  rStart < rows) &&  (cStart >= 0 && cStart < cols)){
                    ans[index][0] = rStart;
                    ans[index][1] = cStart;
                    index++;
                    totalElement--;
                } 
            }
            right += 2;
            // down
            for(int d = 0; d < down; d++){
                rStart += 1;
                if((rStart >= 0 &&  rStart < rows) &&  (cStart >= 0 && cStart < cols))
                {
                    ans[index][0] = rStart;
                    ans[index][1] = cStart;
                    index++;
                    totalElement--;
                } 
            }
            down += 2;
            // left
            for(int l = 0; l < left; l++){
                cStart -= 1;
                if((rStart >= 0 &&  rStart < rows) &&  (cStart >= 0 && cStart < cols)){
                    ans[index][0] = rStart;
                    ans[index][1] = cStart;
                    index++;
                    totalElement--;
                } 
            }
            left += 2;
            // down
            for(int u = 0; u < up; u++){
                rStart -= 1;
                if((rStart >= 0 &&  rStart < rows) &&  (cStart >= 0 && cStart < cols))
                {
                    ans[index][0] = rStart;
                    ans[index][1] = cStart;
                    index++;
                    totalElement--;
                } 
            }
            up += 2;
        }
        // int ans[][] = new int[temp.size()][2];
        // int index = 0;
        // for(int i[]: temp){
        //     ans[index][0] = i[0];
        //     ans[index][1] = i[1];
        //     index++;
        // } 
        return ans;
    }
}
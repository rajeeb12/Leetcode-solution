class rowData{
    int totalSoldiers;
    int row;
    public rowData(int _t,int _r){
        this.totalSoldiers = _t;
        this.row = _r;
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        rowData[] data = new rowData[mat.length];

        for(int i = 0 ; i < mat.length; i++)
        {
            int count = 0;
            for(int j = 0 ; j < mat[0].length; j++)
            {
                if(mat[i][j] == 1) count++;
            }
            data[i] = new rowData(count, i);
        }
        Arrays.sort(data, new Comparator<rowData>(){
            public int compare(rowData ts1, rowData ts2)
            {
                return ts1.totalSoldiers - ts2.totalSoldiers;
            }
        });
        int ans[] = new int[k];

        for(int i = 0 ; i < k ; i++)
        {
            ans[i] = data[i].row;
        }
        return ans;
    }
}
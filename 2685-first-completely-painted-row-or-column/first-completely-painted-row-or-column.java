class Pair{
    int i;
    int j;
    public Pair(int _i,int _j){
        this.i = _i;
        this.j = _j;
    }
}
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length, m = mat[0].length;
        HashMap<Integer, Pair> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map.put(mat[i][j], new Pair(i,j));
            }
        }

        int col[] = new int[m];
        int row[] = new int[n];

        for(int i = 0; i < arr.length; i++){
            Pair cordinate = map.get(arr[i]);
            col[cordinate.j]++;
            row[cordinate.i]++;

            if(col[cordinate.j] == n || row[cordinate.i] == m) return i;
        }
        return arr.length - 1;
    }
}
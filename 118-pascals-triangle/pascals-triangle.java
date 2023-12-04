class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int row = 0 ; row < numRows; row++)
        {
            List<Integer> temp = new ArrayList<>();
            for(int col = 0; col < row; col++)
            {
                temp.add(generatValueRowCol(row, col));
            }
            temp.add(1);
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
    public int generatValueRowCol(int r,int c)
    {
        int res = 1;
        for(int i = 0 ; i < c ; i++)
        {
            res = res * (r - i);
            res = res / (i + 1);
        }
        return res;
    }
}
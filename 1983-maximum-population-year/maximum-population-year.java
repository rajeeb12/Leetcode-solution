class Solution {
    public int maximumPopulation(int[][] logs) {
        int arr[]= new int[2051];

        for(int i[]: logs)
        {
            for(int year = i[0]; year < i[1] ; year++)
            {
                arr[year]++;
            }
        }
        int max = 0;
        int ansYear = 0;
        for(int i = 0 ; i < 2051; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
                ansYear = i;
            }
        }
        return ansYear;
    }
}
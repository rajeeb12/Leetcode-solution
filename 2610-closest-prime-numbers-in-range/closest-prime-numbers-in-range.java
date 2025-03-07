class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean isNotPrime[] = getSeive(right + 1);
        List<Integer> ls = new ArrayList<>();

        for(int i = left; i <= right; i++){
            if(isNotPrime[i]) continue;
            ls.add(i);
        }
        int min = (int)1e9, first = - 1 , second = -1;
        if(ls.size() == 1) return new int[]{-1,-1};
        
        for(int i = 0; i < ls.size() - 1; i++)
        {
            int diff = ls.get(i + 1) - ls.get(i);
            if(diff < min){
                first = ls.get(i);
                second = ls.get(i + 1);
                min = diff;
            } 
        }

        return new int[]{first, second};
    }
    public boolean[] getSeive(int n){
        boolean arr[] = new boolean[n];
        arr[1] = true;
        for(int i = 2; i < n; i++){
            if(arr[i]) continue;
            for(int j = i * 2; j < n; j += i){
                arr[j] = true;
            }
        }  
        return arr;
    }
}
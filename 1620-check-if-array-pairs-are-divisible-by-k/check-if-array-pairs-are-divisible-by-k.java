class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        int remainder[] = new int[k + 1];
        for(int i = 0; i < n; i++){
            int rem = arr[i] % k;
            if(rem < 0) rem += k;
            remainder[rem]++; 
        }

        if(remainder[0] % 2 != 0) return false;

        for(int i = 1; i < k; i++){
            if(2 * i == k)
            {
                if(remainder[i] % 2 != 0) return false;
            }
            else if(remainder[i] != remainder[k - i]) return false;
        }
        return true;
    }
}
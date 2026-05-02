class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;

        for(int i = 1; i <= n; i++){
            boolean hasChanged = false;
            int num = i;

            while(num > 0){
                int rem = (num % 10);

                if(rem == 2 || rem == 5 || rem == 6 || rem == 9){
                    hasChanged = true;
                }

                if(rem == 3 || rem == 4 || rem == 7){
                    hasChanged = false;
                    break;
                }
                num /= 10;
            }
            if(hasChanged) ans++;
        }
        return ans;
    }
}
class Solution {
    public int reverse(int x) {
        boolean neg = false;
        if(x < 0){
            neg = true;
            x = -x;
        }

        long ans = 0;

        while(x != 0){
            int rem = x % 10;
            ans = ans * 10 + rem;
            x /= 10;
        }

        if(neg){
            ans = -ans;
        }
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return 0;

        return (int) ans;
    }
}
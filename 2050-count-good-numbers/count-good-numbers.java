class Solution {
    int mod = (int)1e9 + 7;
    public int countGoodNumbers(long n) {
        long count = 1;
        if(n % 2 == 0){
            count = (count * pow(5, n /2)) % mod;
            
            count = (count * pow(4, n / 2)) % mod;
        }else{
            count = (count * pow(5, (n + 1) / 2)) % mod;
            count = (count * pow(4, n / 2)) % mod;
        }
        return (int) count;

    }
    public long pow(long num,long n){
        long ans = 1;
        double oriNum = num;

        if (num == 0 || num == 1) {
            return num;
        }

        // If 'n' is negative, make 'x' its
        // reciprocal and change 'n' to its
        // absolute value minus 1
        // if (n < 0) {
        //     x = 1 / x;
        //     n = -(n + 1);
        //     ans = ans * x;
        // }

        // Loop to compute the
        // result iteratively
        while (n > 0) {
            
            if (n % 2 == 1) {
                ans = (ans * num) % mod;
                n = n - 1;
            }
            // If 'n' is even, divide
            // 'n' by 2 and multiply
            // 'x' by itself
            else {
                n = n / 2;
                num = (num * num) % mod;
            }
        }
        return ans;
    }
    
}
// 5 * 4  * 5  * 4 = 100 * 5 = 500; 20 * 4 = 80 * 4 = 320
// 0 , 2, 4, 6, 8
// 2 , 3, 5, 7 
//1000 - 9999
// 1 - 5; 2 - 21,23,25,27,29, 41,43,45,47,49, 61,63,65,67,69, 81,83,85,87,89 
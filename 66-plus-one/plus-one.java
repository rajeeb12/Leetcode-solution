class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length ;
        int carry = 1;

        for(int i = n - 1; i >= 0; i--){
            int sum = digits[i] + carry;
            carry = sum / 10;
            int rem = sum % 10;
            digits[i] = rem;
        }

        if(carry > 0){
            int ans[] = new int[n + 1];
            ans[0] = carry;
            for(int i = 1; i < n; i++){
                ans[i] = digits[i - 1];
            }
            return ans;
        }
        return digits;
    }
}
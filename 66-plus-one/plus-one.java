class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int sum = digits[n - 1] + 1;
        int carry = sum / 10;
        digits[n - 1] = sum % 10;
        if(carry != 0){
            for(int i = n - 2; i >= 0; i--){
                sum = digits[i] + carry;
                carry = sum / 10;
                digits[i] = sum % 10;
                if(carry == 0) break;
            }
        }
        if(carry != 0){
            int ans[] = new int[digits.length + 1];
            ans[0] = carry;
            for(int i = 1; i < ans.length; i++){
                ans[i] = ans[i];
            }
            return ans;
        }
        return digits;
    }
}
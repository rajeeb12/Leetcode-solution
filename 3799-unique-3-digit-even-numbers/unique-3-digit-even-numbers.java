class Solution {
    public int totalNumbers(int[] digits) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < digits.length; i++){
            for(int j = 0; j < digits.length ; j++){
                if(i == j)  continue;
                for(int k = 0; k < digits.length; k++){
                    if(i == k || j == k) continue;
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    String s = num +"";
                    if(s.length() == 3 && num % 2 == 0) set.add(num);
                }
            }
        }
        return set.size();
        
    }
}
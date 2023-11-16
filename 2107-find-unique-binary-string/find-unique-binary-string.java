class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(String str : nums){
            set.add(Integer.parseInt(str, 2)); 
            // convert string  -> binary int , int -> decimal 
        }

        String result= "";
        for(int i = 0 ; i <= n; i++){
            if(!set.contains(i)){
                result = Integer.toBinaryString(i); //convert the int -> binary int, binary int -> string

                while(result.length() < n){
                    result = '0' + result;
                }
                return result;
            }
        }
        return "";
    }
}
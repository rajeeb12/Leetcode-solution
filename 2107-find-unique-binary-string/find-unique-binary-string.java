class Solution {
    public String findDifferentBinaryString(String[] nums) {
        if(nums.length == 0) return "";
        ArrayList<String> list = new ArrayList<>();
        int n = nums.length;
        generateStrings(n,"",list);
        String result ="";
        for(int i = 0 ; i < list.size() ; i++){
            String str = list.get(i);
            boolean exist = false;
            for(int j = 0 ; j < n ; j++){
                if(str.equals(nums[j])){
                    exist = true;
                }
            }
            if(!exist){
                result = str;
            }
        }
        return result;
    }
    public void generateStrings(int n,String str,ArrayList<String> list){
        if(n == str.length()){
            list.add(str);
            return;
        }

        generateStrings(n, str + '0', list);
        generateStrings(n, str + '1', list);
    }
}
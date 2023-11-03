class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();

        int stream = 1 , index = 0;

        while(index < target.length && stream <= n){
            ans.add("Push");
            if(stream != target[index]){
                ans.add("Pop");
                stream++;
            }else{
                stream++;
                index++;
            }
        } 
        return ans;
    }
}
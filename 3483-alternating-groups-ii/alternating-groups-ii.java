class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int ans = 0;
        int j = 0;
        for(int i = 0; i < n;){
            boolean flag = true;
            while((j - i + 1) < k){
                if(colors[j % n] == colors[(j + 1) % n]){
                    flag = false;
                    break;
                }
                j++;
            }
            if(!flag){ 
                i = j + 1;
                j++;
            }
            else{
                ans++;
                i++;
            }
        }   
        return ans;
    }
}
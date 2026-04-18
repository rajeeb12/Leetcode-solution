class Solution {
    public int compress(char[] chars) {
        int ans = 0, n = chars.length;
        char prevChar = chars[0];

        for(int i = 0; i < chars.length;){
            char letter = chars[i]; 
            int count = 0;
            while(i < n && chars[i] == letter){
                count++;
                i++;
            }
            chars[ans++] = letter;
            if(count > 1){
                String temp = count+"";
                for(char c: temp.toCharArray()){
                    chars[ans++] = c;
                }
            }
        }
        return ans;
    }
}
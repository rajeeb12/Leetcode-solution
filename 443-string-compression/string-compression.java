class Solution {
    public int compress(char[] chars) {
        int ans = 0; //pointer

        for(int i = 0 ;i < chars.length;)
        {
            char letter = chars[i];
            int count = 0;

            while(i < chars.length && letter == chars[i])
            {
                i++;
                count++;
            } 

            chars[ans++] = letter;

            if(count > 1)
            {
                String number = count+"";
                for(char ch: number.toCharArray())
                {
                    chars[ans++] = ch;
                }
            }
        }
        return ans;
    }
}
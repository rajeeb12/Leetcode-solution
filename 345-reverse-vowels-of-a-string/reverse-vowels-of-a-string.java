class Solution {
    public String reverseVowels(String s) {
        int size = s.length();
        int  right = size - 1;
        char arr[] = s.toCharArray();
        for(int left = 0; left < right ; left++)
        {
            if(isVowel(arr[left]))
            {
                boolean flag = false;
                while(right > left)
                {
                    if(isVowel(arr[right]))
                    {
                        flag = true;
                        break;
                    }
                    right--;
                }
                if(flag){
                    char ch = arr[left];
                    arr[left] = arr[right];
                    arr[right] = ch;
                    right--;
                }
            }
        }
        String res = new String(arr);
        return res;
    }
    public boolean isVowel(char ch )
    {
        if(ch == 'a' || ch == 'e' || ch == 'i' ||ch =='o' ||ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' ||ch =='O' ||ch == 'U') return true;
        return false;
    }
}
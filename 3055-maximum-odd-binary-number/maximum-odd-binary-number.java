class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int countOfOne = 0;
        for(char ch: s.toCharArray())
        {
            if(ch == '1') countOfOne++;
        }
        if(countOfOne == n) return s;
        char arr[] = new char[s.length()];
        Arrays.fill(arr, '0');
        arr[n - 1] = '1';
        countOfOne--;
        int index = 0;
        while(countOfOne > 0)
        {
            arr[index] = '1';
            countOfOne--;
            index++;
        }
        String ans = new String(arr);
        return ans;
    }
}
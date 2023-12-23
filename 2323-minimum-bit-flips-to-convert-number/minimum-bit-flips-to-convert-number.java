class Solution {
    public int minBitFlips(int start, int goal) {
        int temp = start ^ goal;
        int count = 0;
        while(temp != 0)
        {
            count++;
            temp = temp  & (temp - 1);
        }
        return count;
    }
}
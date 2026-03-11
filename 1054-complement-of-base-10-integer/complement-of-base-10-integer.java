class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        int mask = 1;
        int temp = n;
        int index = 0;
        while(mask < n){
            mask |= (1 << index);
            index++;
        }
        return n ^ mask;
    }
}
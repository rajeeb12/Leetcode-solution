class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i = low; i <= high; i++){
            String s = i+"";
            int front = 0;
            int back = 0;
            if(s.length() % 2 == 1 || i < 10) continue;

            for(int j = 0; j < s.length() / 2; j++){
                front += s.charAt(j) -'0';
                back += s.charAt(s.length() - j - 1) - '0';
            }
            count += (front == back ? 1: 0);
        }
        return count;
    }
}
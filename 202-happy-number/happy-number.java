class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n != 1){
            set.add(n);
            int temp = 0;

            while(n != 0){
                int rem = n % 10;
                temp = temp + rem * rem;
                n /= 10; 
            }

            n = temp;
            if(set.contains(n)) return false;
        }

        return true;
    }
}
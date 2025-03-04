class Solution {
    public boolean checkPowersOfThree(int n) {
        HashSet<Integer> set = new HashSet<>();

        while(n >= 0){
            int pow = 0;
            int num = 0;
            int prev = 0;
            for(int i = 0; i < n; i++){
                num =(int) Math.pow(3,i);
                if(num > n) break;
                prev = num;
                pow = i;
            }
            if(set.contains(pow)) return false;
            n -= (prev == 0 ? 1 : prev);
            if(n == 0 ) return true;
            set.add(pow);
        }
        return false;
    }
    
}
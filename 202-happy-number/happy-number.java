class Solution {
    public boolean isHappy(int n) {
        if(n == 1 || n == -1) return true;
        HashSet<Integer> set = new HashSet<>();
        int temp = n;
        int sum = 0;
        while(!set.contains(n))
        {
            set.add(n);
            n = getValue(n);

            if(n == 1) return true;
        }
        return false;
    }
    public int getValue(int n)
    {
        int sum = 0;

        while(n != 0)
        {
            int rem = n % 10;
            sum = sum + rem * rem;
            n /= 10;
        }
        return sum;
    }
}
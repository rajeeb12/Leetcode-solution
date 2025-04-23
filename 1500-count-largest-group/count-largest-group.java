class Solution {
    public int countLargestGroup(int n) {
        int temp[] = new int[10000001];
        int max = 0;

        for(int i = 1; i <= n; i++){
            int sum = 0;
            int num = i;
            while(num != 0){
                sum += num % 10;
                num /= 10;
            }
            temp[sum]++;
            max = Math.max(max, temp[sum]);
        }
        int count = 0;
        for(int i = 0; i < 38; i++){
            if(max == temp[i]) count++;
        }
        return count;
    }
}
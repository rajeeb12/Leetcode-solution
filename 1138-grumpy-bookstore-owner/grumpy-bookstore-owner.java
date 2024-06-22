class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;
        int n = grumpy.length;
        for(int i = 0; i < n; i++){
            if(grumpy[i] == 0){
                sum += customers[i];
            }
        }   
        int max = sum;
        for(int i = 0; i < n; i++){
            int add = i;
            int remove = i - minutes; 
            if(grumpy[add] == 1){
                sum += customers[add];
            }
            if(remove >= 0 && grumpy[remove] == 1){
                sum -= customers[remove];
            }
            max = Math.max(sum , max);
        }
        return max;
    }
}
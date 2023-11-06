class Solution {
    public int getWinner(int[] arr, int k) {

        int max = 0;
        for(int i : arr){
            max = Math.max(i, max);
        } 
        if( k >= arr.length) return max;

        int winner = arr[0];
        int streak = 0;

        for(int i = 1 ; i < arr.length ; i++){
            if(streak == k || winner == max){
                return winner;
            }
            else if(winner > arr[i]){
                streak++;
            }else{
                winner = arr[i];
                streak = 1;
            }
        }
        return max;
    }
}
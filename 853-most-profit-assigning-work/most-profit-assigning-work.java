class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        int n = difficulty.length;
        int arr[][] = new int[n][2];

        for(int i = 0; i < n; i++){
            arr[i][0] = difficulty[i];
            arr[i][1] = profit[i];
        }
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);
        int maxArr[] = new int[n];
        maxArr[0] = arr[0][1];

        for(int i = 1; i < n; i++){
            maxArr[i] = Math.max(maxArr[i - 1], arr[i][1]); 
        }

        int idf = n - 1;
        int maxProfit = 0;
        for(int i = worker.length - 1; i >= 0; i--){
            while(idf != -1 && worker[i] < arr[idf][0]){
                idf--;
            }
            if(idf == -1) break;
            // System.out.print(maxArr[idf]+" ");
            maxProfit += maxArr[idf];
        }
        return maxProfit;
    }
}
class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int arr[][] = new int[n][2];

        for(int r[]: roads){
            arr[r[0]][0] = r[0];
            arr[r[1]][0] = r[1];
            arr[r[0]][1]++;
            arr[r[1]][1]++;
        }

        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        int importance[] = new int[n];
        int value = 1;
        for(int i = 0; i < n; i++){
            importance[arr[i][0]] = value;
            value++;
        }
        long cal = 0;
        for(int r[]: roads){
            int a = r[0];
            int b = r[1];
            cal += (long) importance[a] + importance[b];
        }
        return cal;
    }
}
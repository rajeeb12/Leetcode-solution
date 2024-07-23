class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length; 
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int arr[][] = new int[map.size()][2];
        int index = 0;
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            arr[index][0] = e.getKey();
            arr[index][1] = e.getValue();
            index++;
        }
        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                if(a[1] == b[1]){
                    return Integer.compare(b[0] , a[0]);
                }

                return Integer.compare(a[1] , b[1]);
            }
        });
        int ans[] = new int[n];
        int k = 0;
        for(int i = 0; i < map.size(); i++){
            for(int j = 0; j < arr[i][1]; j++){
                ans[k] = arr[i][0];
                k++;
            }
        }
        return ans;
    }
}
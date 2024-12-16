class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq= new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                if(a[0] != b[0]) return Integer.compare(a[0] , b[0]);
                return Integer.compare(a[1], b[1]);
            }
        });
        int n = nums.length;
        for(int i = 0; i < n ;i++){
            pq.add(new int[]{nums[i] , i});
        }

        while(k-- > 0){
            int temp[] = pq.poll();
            temp[0] *= multiplier;
            pq.add(new int[]{temp[0], temp[1]});
        }
        while(!pq.isEmpty()){
            int temp[] = pq.poll();
            nums[temp[1]] = temp[0];
        }
        return nums;
    }
}
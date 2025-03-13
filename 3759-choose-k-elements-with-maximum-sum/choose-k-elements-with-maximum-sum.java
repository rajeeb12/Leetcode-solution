class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int triple[][] = new int[n][3];        
        for(int i = 0; i < n; i++){
            triple[i][0] = nums1[i];
            triple[i][1] = i;
            triple[i][2] = nums2[i];
        }
        Arrays.sort(triple, new Comparator<int[]>(){
            public int compare(int a[],int b[]){
                return a[0] - b[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long ans[] = new long[n];
        for(int i = 0; i < n; i++)
        {
            if(i > 0 && triple[i][0] == triple[i - 1][0])
            {
                ans[triple[i][1]] = ans[triple[i - 1][1]];
            } else if(i == 0){
                ans[triple[i][1]] = 0;
                
            }else{
                ans[triple[i][1]] = sum;
            }
            sum += triple[i][2];
            pq.add(triple[i][2]);

            if(!pq.isEmpty() && pq.size() > k){
                sum -= pq.poll();
            }
        }
        return ans;
    }
}
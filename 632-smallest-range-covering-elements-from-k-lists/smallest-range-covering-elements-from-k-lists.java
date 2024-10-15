class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->  a[0] - b[0]);
        int curMax = -(int)1e6;
        for(int i = 0; i < nums.size(); i++){
            pq.add(new int[]{nums.get(i).get(0), i, 0});
            curMax = Math.max(curMax, nums.get(i).get(0));
        }

        int ans[] ={-(int)1e6, (int)1e6};

        while(true){
            int temp[] = pq.poll();
            int curMin = temp[0];
            if(curMax - curMin < ans[1] - ans[0] || (curMin < ans[0] && curMax - curMin == ans[1] - ans[0])){
                ans[0] = curMin;
                ans[1] = curMax;
            }
            int size = nums.get(temp[1]).size();
            if(temp[2] + 1 < size)
            {
                int nextNumber = nums.get(temp[1]).get(temp[2] + 1);
                curMax = Math.max(curMax, nextNumber);
                pq.add(new int[]{nextNumber, temp[1], temp[2] + 1});
            }else{
                break;
            }
        }
        return ans;
    }
}
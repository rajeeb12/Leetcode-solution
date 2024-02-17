class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while(i < n -1)
        {
            if(heights[i] >= heights[i + 1])
            {
                i++;
                continue;
            }else{
                int diff = heights[i + 1] - heights[i];

                if(diff <= bricks)
                {
                    bricks -= diff;
                    pq.add(diff);
                }else{
                    if(ladders > 0)
                    {
                        if(!pq.isEmpty()){
                            int max_past = pq.peek();
                            if(max_past >= diff)
                            {
                                pq.poll();
                                bricks += max_past;
                                bricks -= diff;
                                pq.add(diff);
                                ladders--;
                            }else{
                                ladders--;
                            }
                        }else{
                            ladders--;
                        }
                    }
                    else{
                        break;
                    }
                }
            }
            i++;
        }
        return i;
    }
}
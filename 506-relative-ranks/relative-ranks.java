class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> Integer.compare(y , x));

        for(int i = 0; i < score.length; i++)
        {
            map.put(score[i], i);
            pq.add(score[i]);
        } 
        int n = score.length;
        String ans[] = new String[n];
        int count = 1;
        while(!pq.isEmpty())
        {
            int index = map.get(pq.poll());
            if(count <= 3){
                if(count == 1){
                    ans[index] = "Gold Medal";
                }else if(count == 2){
                    ans[index] = "Silver Medal";
                }else{
                    ans[index] = "Bronze Medal";
                }
                count++;
            }
            else{
                ans[index] = Integer.toString(count);
                count++;
            }
        }
        return ans;
    }
}
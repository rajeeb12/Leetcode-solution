class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int totalCandies = 0;
        int n = status.length;
        boolean reachableButClosedBoxes[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i: initialBoxes){
            if(status[i] == 1){
                q.add(i);
            }else{
                reachableButClosedBoxes[i] = true;
            }
        }

        while(!q.isEmpty()){
            int box = q.poll();
            totalCandies += candies[box];

            for(int i: keys[box]){
                if(status[i] == 0 && reachableButClosedBoxes[i]){
                    q.add(i);
                }
                status[i] = 1;
            }  

            for(int i: containedBoxes[box]){
                if(status[i] == 1){
                    q.add(i);
                }else{
                    reachableButClosedBoxes[i] = true;
                }
            }
        }
        return totalCandies;
    }
}
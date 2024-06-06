class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(hand);
        for(int i: hand){
            map.put(i, map.getOrDefault(i , 0) + 1);
        }

        for(int i = 0; i < n; i++){
            if(!map.containsKey(hand[i]) ) continue;
            int num = hand[i];
            int count = 1;
            while(count <= groupSize){
                if(!map.containsKey(num)) return false;
                
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0) map.remove(num);

                num++;
                count++;
            }
        }
        return true;
    }
}
class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        if(words[startIndex].equals(target)) return 0;

        HashMap<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            if(!map.containsKey(word)){
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(i);
        }
        
        if(!map.containsKey(target)) return -1;

        List<Integer> ls = map.get(target);
        int n = words.length;
        int minDistance = (int)1e9;
        for(int index : ls){
            int right = 0,left = 0;
            if(index > startIndex){
                right = index - startIndex;
                left = (n - index - 1) + startIndex + 1;
            }else{
                right = (n - startIndex - 1) + index + 1;
                left = startIndex - index;
            }
            minDistance = Math.min(minDistance, Math.min(left, right));
        }
        return minDistance;
    }
}
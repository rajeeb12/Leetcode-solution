class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        HashSet<String> set = new HashSet<>();
        for(String s: dictionary) set.add(s);
        List<String> ans = new ArrayList<>();
        for(String query: queries){
            int min = (int)1e9;
            for(String dic: dictionary){
                int count = 0;
                for(int i = 0; i < dic.length(); i++){
                    if(query.charAt(i) != dic.charAt(i)){
                        count++;
                    }
                }
                min = Math.min(min, count);
            }
            if(min <= 2){
                ans.add(query);
            }
        }
        return ans;
    }

}
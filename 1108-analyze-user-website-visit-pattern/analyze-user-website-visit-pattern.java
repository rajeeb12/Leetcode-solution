class Pair{
    int time;
    String str;
    public Pair(int _time,String _str){
        this.time = _time;
        this.str = _str;
    }
}
class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String, List<Pair>> map = new HashMap<>();
        for(int i = 0; i < username.length; i++){
            map.putIfAbsent(username[i], new ArrayList<>());
            map.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }

        String res = "";
        HashMap<String ,Integer> webVisitedCount= new HashMap<>(); 
        for(Map.Entry<String, List<Pair>> entry: map.entrySet()){
            List<Pair> temp = entry.getValue();
            Collections.sort(temp, (a,b) -> a.time - b.time);
            
            HashSet<String> set = new HashSet<>();

            for(int i = 0; i < temp.size() - 2; i++){
                for(int j = i + 1; j < temp.size() - 1; j++){
                    for(int k = j + 1; k < temp.size(); k++){
                        String str = temp.get(i).str+" "+temp.get(j).str+" "+temp.get(k).str;
                        if(!set.contains(str)){
                            set.add(str);
                            webVisitedCount.put(str,webVisitedCount.getOrDefault(str, 0) + 1);
                        }

                        if(res.equals("") || webVisitedCount.get(str) > webVisitedCount.get(res) || (webVisitedCount.get(str) == webVisitedCount.get(res) && res.compareTo(str) > 0)){
                            res = str;
                        }
                    }
                }
            }
        }
        List<String> ans = new ArrayList<>();

        for(String s: res.split(" ")){
            ans.add(s);
        }
        return ans;
    }
}
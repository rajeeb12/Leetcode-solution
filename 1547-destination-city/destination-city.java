class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String,Integer> map= new HashMap<>();
        HashMap<Integer,String> map2= new HashMap<>();
        int index = 0;
        for(List<String> item:paths)
        {
            String str1 = item.get(0);
            String str2 = item.get(1);
            if(!map.containsKey(str1)){
                map.put(str1, index);
                map2.put(index++, str1);
            }
            if(!map.containsKey(str2)){
                map.put(str2, index);
                map2.put(index++, str2);
            }
        }
        int outDegree[]= new int[index];
        for(List<String> item:paths)
        {
            int index1 = map.get(item.get(0));
            outDegree[index1]++;
        }
        for(int i = 0 ; i < index; i++)
        {
            if(outDegree[i] == 0) return map2.get(i); 
        }
        return "";
    }
}
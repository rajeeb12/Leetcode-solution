class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> set = new HashSet<>();

        for(List<String> item: paths)
        {
            set.add(item.get(0));
        }
        for(List<String> item: paths)
        {
            if(!set.contains(item.get(1))) return item.get(1);
        }
        return "";
    }
}
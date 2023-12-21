class Pair{
    String str;
    int timestamp;
    public Pair(String _s,int _t)
    {
        this.str = _s;
        this.timestamp = _t; 
    } 
}
class TimeMap {
    HashMap<String,ArrayList<Pair>> map;
    int timestamp_prev;
    public TimeMap() {
        map = new HashMap<>();
        timestamp_prev = 0;
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        timestamp_prev = timestamp;
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        String res ="";

        ArrayList<Pair> arr = map.get(key);
        int low = 0, high = arr.size()-1;

        while(low <= high)
        {
            int mid = (low + (high - low) / 2);
            int t = arr.get(mid).timestamp;
            if(t <= timestamp)
            {
                res = arr.get(mid).str;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
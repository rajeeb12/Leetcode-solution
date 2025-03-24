class RandomizedSet {
    List<Integer> list;
    HashMap<Integer,Integer> map;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int lastValue = list.remove(list.size() - 1);
            int index = map.get(val);
            if(lastValue != val){
                list.set(index, lastValue);
                map.put(lastValue, index);
            }
            map.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
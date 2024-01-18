class RandomizedSet {
    HashMap<Integer,Integer> map;
    ArrayList<Integer> arr;
    Random random;
    public RandomizedSet() {
        random = new Random();
        map = new HashMap<>();
        arr = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;

        arr.add(val);
        map.put(val, arr.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int lastValue = arr.remove(arr.size() - 1);
        int index = map.remove(val);

        if(lastValue != val)
        {
            arr.set(index, lastValue);
            map.put(lastValue, index);
        }

        return true;
    }
    
    public int getRandom() {
        return arr.get(random.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
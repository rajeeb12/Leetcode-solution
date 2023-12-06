class RandomizedSet {
    HashMap<Integer,Integer> map;
    Random random;
    ArrayList<Integer> list;
    public RandomizedSet() {
        map = new HashMap<>();
        random = new Random();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
        {
          return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
          return false;
        }
        int index = map.remove(val);
        int lastValue = list.remove(list.size()-1);
        if(lastValue != val){
          list.set(index, lastValue);
          map.put(lastValue, index);
        }
        return true;
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
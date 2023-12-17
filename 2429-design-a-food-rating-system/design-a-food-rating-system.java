class valueComaprator implements Comparator<FoodAndRating>{
    public int compare(FoodAndRating a, FoodAndRating b)
    {
        if(a.rating == b.rating){
            return a.food.compareTo(b.food);
        }
        return b.rating - a.rating;
    }
}
class FoodAndRating{
    String food;
    String cuisine;
    int rating;
    public FoodAndRating(String _f,String _c,int _r)
    {
        this.food= _f;
        this.rating = _r;
        this.cuisine = _c;
    }
}
class FoodRatings {
    HashMap<String,PriorityQueue<FoodAndRating>> map;
    HashMap<String, FoodAndRating> map2;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        map2 = new HashMap<>();
        int n = foods.length;

        for(int i = 0; i < n; i++)
        {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            if(!map.containsKey(cuisine))
            {
                map.put(cuisine, new PriorityQueue<>(new valueComaprator()));
            }
            FoodAndRating foodObj = new FoodAndRating(food,cuisine,rating);
            map.get(cuisine).add(foodObj);
            map2.put(food,foodObj);
        }
    }
    
    public void changeRating(String food, int newRating) {

        FoodAndRating tempFood = map2.get(food);
        String getCuisine = tempFood.cuisine;
        PriorityQueue<FoodAndRating> pq = map.get(getCuisine);
        pq.remove(tempFood);
        tempFood.rating = newRating;
        pq.add(tempFood);
    }
    
    public String highestRated(String cuisine) {
        FoodAndRating highestRatedFood = map.get(cuisine).peek();
        return highestRatedFood.food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
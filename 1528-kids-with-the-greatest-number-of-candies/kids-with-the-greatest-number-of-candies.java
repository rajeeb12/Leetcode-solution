class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int largest = 0;
        int size = candies.length;
        for(int candy: candies)
        {
            largest = Math.max(candy, largest);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int i =0 ; i < size; i++)
        {
            int sumofCandies = candies[i] + extraCandies;
            if(sumofCandies >= largest)
            {
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
    }
}
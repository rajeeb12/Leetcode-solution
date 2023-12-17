class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        int left = 0 , right = people.length-1;
        while(left <= right)
        {
            int sum = people[left] + people[right];
            if(sum <= limit)
            {
                left++;
            }
            count++;
            right--;
        }
        return count;
    }
}
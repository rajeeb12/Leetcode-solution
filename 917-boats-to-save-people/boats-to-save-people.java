class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int boats = 0;

        int i = 0 , j = people.length - 1;

        while(i < j){
            if(people[i] + people[j] <= limit){
                boats++;
                i++;
                j--;
            }else{
                boats++;
                j--;
            }
        } 
        if(i == j) boats++;

        return boats;
    }
}
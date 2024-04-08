class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int countZero = 0;
        int countOne = 0;
        for(int i : students)
        {
            if(i == 0)
            {
                countZero++;
            }else{
                countOne++;
            }
        }
        for(int i: sandwiches)
        {
            if(i == 0){
                if(countZero == 0) break;
                countZero--;
            }else{
                if(countOne == 0) break;
                countOne--;
            }
            
        }
        if(countOne != 0)
        {
            return countOne;
        }else if(countZero != 0)
        {
            return countZero;
        }
        return 0;
    }
}
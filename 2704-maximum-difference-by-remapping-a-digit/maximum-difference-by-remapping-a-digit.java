class Solution {
    public int minMaxDifference(int num) {
        String s = num + "";   
        char max[] = s.toCharArray();
        char min[] = s.toCharArray();
        int index = 0;
        while(index < max.length && max[index] - '0' == 9){
            index++;
        }
        if(index == max.length){
            return num;
        }
        char c = max[index];
        for(int i = 0; i < max.length; i++){
            if(max[i] == c){
                max[i] = '9';
            }
        }
        
        for(int i = 1; i < max.length; i++){
            if(min[i] == min[0]){
                min[i] = '0';
            }
        }
        min[0] = '0';
        int maximum = 0;
        int minimum = 0;
        for(int i = 0; i < max.length; i++){
           
            maximum = (maximum * 10) + (max[i] - '0');
            minimum = (minimum * 10) + (min[i] - '0'); 
        }
        
        return maximum - minimum;
    }
}

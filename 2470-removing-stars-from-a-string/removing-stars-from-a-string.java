class Solution {
    public String removeStars(String s) {
        char arr[] = new char[s.length()];
        int index = 0;
        for(char c: s.toCharArray()){
            if(c == '*'){
                index--;
            }else{
                arr[index++] = c;
            }
        }
        return new String(arr, 0, index);
    }
}
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> map= new HashMap<>();
        
        for(int i=0; i<26; i++)
        {
            map.put(order.charAt(i) , i+1);
        }
        for(int j=0; j<words.length-1; j++){
            if(compare(words[j],words[j+1],map)){
                return false;
            }
        }
        return true;
    }
    public static boolean compare(String w1, String w2,HashMap<Character,Integer> map){

        for(int i=0; i<w1.length() && i<w2.length(); i++){
            if(w1.charAt(i) != w2.charAt(i)){ // jaha pehela char diff hoga
                return (map.get(w1.charAt(i)) > map.get(w2.charAt(i)));
            }
        } 
        return w1.length() > w2.length();
    }
}
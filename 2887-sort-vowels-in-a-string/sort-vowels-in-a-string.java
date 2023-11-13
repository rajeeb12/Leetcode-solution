class Solution {
    public String sortVowels(String s) {
        int n =s.length();
        if(n == 0 ) return s;

        ArrayList<Character> sorted_vowel = new ArrayList<>();
        for(char ch: s.toCharArray()){
            if(isVowel(ch)) sorted_vowel.add(ch);
        }
        Collections.sort(sorted_vowel);

        char arr[] = s.toCharArray();
        int index = 0;
        for(int i = 0 ; i < n; i++){
            if(isVowel(arr[i])){
                arr[i] = sorted_vowel.get(index);
                index++;
            }
        }
        String res ="";
        for(int i = 0 ; i < n; i++){
            res += arr[i];
        }
        return res;
    }
    public boolean isVowel(char ch){
        if(ch == 'a' || ch== 'e' || ch=='i' || ch == 'o' || ch == 'u' || ch == 'A' || ch== 'E' || ch=='I' || ch == 'O' || ch == 'U' ){
            return true;
        }
        return false;
    }
}
class Pair{
    char c;
    int count;
    public Pair(char _c,int _count){
        this.c = _c;
        this.count = _count;
    }
}
class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int map[] = new int[26];
        for(char c: s.toCharArray()){
            map[c-'a']++;
        }
        int maxFreq = 0;
        char maxFreqChar = 'a';
        for(char ch = 'a' ; ch <= 'z'; ch++){
            if(map[ch-'a'] == 0) continue; 
            if(map[ch-'a'] > maxFreq){
                maxFreq = map[ch-'a'];
                maxFreqChar = ch;
            }
        }
        if(maxFreq > (n + 1) / 2){
            return "";
        }

        char arr[] = new char[s.length()];
        int index = 0;
        while(maxFreq > 0){
            arr[index] = maxFreqChar;
            index += 2;
            maxFreq--;
            map[maxFreqChar - 'a']--;
        }

        for(char ch = 'a'; ch <= 'z'; ch++){
            while(map[ch -'a'] > 0){
                if(index >= s.length()) index = 1;
                arr[index] = ch;
                index += 2;
                map[ch-'a']--;
            }
        }

        return new String(arr);
    }
}
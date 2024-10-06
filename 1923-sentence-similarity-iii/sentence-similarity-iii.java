class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.equals(sentence2)) return true;

        if(sentence1.length() < sentence2.length()) return areSentencesSimilar(sentence2,sentence1);
        
        String arr[] = sentence1.split(" ");
        String brr[] = sentence2.split(" ");
        
        if(brr.length == 1)
        {
            if(arr[0].equals(brr[0]) || arr[arr.length - 1].equals(brr[0])) return true;
            else return false;
        }
        int start = 0, end = 0;
        int n1= arr.length, n2 = brr.length;

        while(start < n2 && arr[start].equals(brr[start])) start++;

        while(end < n2 && brr[n2 - end - 1].equals(arr[n1 - end - 1])) end++;
        
        return start + end >= brr.length;
    }}

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int lastZeroCount = 0, currentZeroCount = 0 , convertedOne = 0, oneCount = 0;
        for(char c: s.toCharArray()){
            if(c == '0'){
                currentZeroCount++;
            }else{
                if(currentZeroCount != 0) lastZeroCount = currentZeroCount;
                currentZeroCount = 0;
                oneCount++;
            }
            convertedOne = Math.max(convertedOne, lastZeroCount + currentZeroCount);
        }
        if(convertedOne == currentZeroCount || convertedOne == lastZeroCount) return oneCount;
        return convertedOne + oneCount;
    }
}
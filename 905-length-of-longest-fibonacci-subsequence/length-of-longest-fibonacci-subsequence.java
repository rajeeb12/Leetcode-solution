class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Arrays.sort(arr);
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i: arr) set.add(i);

        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(set.contains(arr[i] + arr[j]))
                {
                    int count = 2;
                    int prev = arr[i];
                    int next = arr[j];
                    while(set.contains(next + prev)){
                        count++;
                        int temp = prev;
                        prev = next;
                        next = temp + prev;
                    }
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

}
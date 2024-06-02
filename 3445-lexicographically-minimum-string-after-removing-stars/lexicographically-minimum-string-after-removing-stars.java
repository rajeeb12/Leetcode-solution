class Pair{
    char c;
    int index;
    public Pair(char _c,int _index){
        this.c = _c;
        this.index = _index;
    }
}

class Solution {
    public String clearStars(String s) {
        PriorityQueue<Pair> pq =new PriorityQueue<>((a,b) -> {
            int compare = Integer.compare(a.c , b.c);
            if(compare != 0) return compare;

            return Integer.compare(b.index, a.index);
        });
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '*'){
                if(!pq.isEmpty()) pq.poll();
            }else{
                pq.add(new Pair(s.charAt(i), i));
            }
        }
        char arr[] = new char[s.length()];
        Arrays.fill(arr, '.');
        while(!pq.isEmpty()){
            Pair p =  pq.poll();
            int index = p.index;
            arr[index] = p.c;
        }
        String ans = new String("");
        for(char c: arr){
            if(c != '.') ans += c;
        }
        return ans;
    }
}
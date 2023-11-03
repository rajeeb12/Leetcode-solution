class Solution {
    public List<String> buildArray(int[] target, int n) {
        Stack<Integer> st= new Stack<>();
        HashSet<Integer> set= new HashSet<>();
        List<String> ans = new ArrayList<>();

        for(int i: target){
            set.add(i);
        }

        for(int num = 1 ; num <= n; num++){
            st.add(num);
            ans.add("Push");
            if(!set.contains(num)){
                st.pop();
                ans.add("Pop");
            }
            if(st.size() == target.length){
                break;
            }
        }
        return ans;
    }
}
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map =new HashMap<>();
        int n = nums2.length;
        st.add(nums2[n-1]);
        int nge[] = new int[n];
        map.put(nums2[n-1], -1);
        
        for(int i = n - 2 ; i >= 0; i--)
        {
            if(st.isEmpty())
            {
                nge[i] = -1;
            }else{
                while(!st.isEmpty() && nums2[i] >= st.peek())
                {
                    st.pop();
                }
                if(st.isEmpty())
                {
                    nge[i] = -1;
                }else{
                    nge[i] = st.peek();
                }
            }
            st.add(nums2[i]);
            map.put(nums2[i], nge[i]);
        }
        int ans[]= new int[nums1.length];
        for(int i = 0 ; i < nums1.length; i++)
        {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
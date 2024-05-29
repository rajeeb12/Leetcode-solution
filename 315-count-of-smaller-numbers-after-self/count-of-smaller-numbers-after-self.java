class Pair{
    int num;
    int index;
    public Pair(int _num,int _index){
        this.num = _num;
        this.index = _index;
    }
}
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return new ArrayList<>();
        }
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Pair(nums[i], i);
        }
        int temp[] = new int[n];
        mergeSort(0,n - 1,temp, arr);
        List<Integer> res = new ArrayList<>();
        for(int i: temp) res.add(i);

        return res;
    }
    public void mergeSort(int low,int high,int[] ans,Pair[] arr){
        if(low >= high) return;

        int mid = (low + high) >> 1;
        mergeSort(low , mid, ans, arr);
        mergeSort(mid + 1, high, ans, arr);
        merge(low , mid , high, ans, arr);
    }
    public void merge(int low ,int mid,int high, int ans[],Pair[] arr){
        int l = low; 
        int r = mid + 1;
        List<Pair> temp = new ArrayList<>();
        int count = 0;
        while(l <= mid && r <= high)
        {
            if(arr[l].num > arr[r].num){
                count++;
                temp.add(arr[r]);
                r++;
            }else{
                ans[arr[l].index] += count;
                temp.add(arr[l]);
                l++;
            }
        }

        while(l <= mid){

            ans[arr[l].index] += count;

            temp.add(arr[l]);
            l++;
        }
        while(r <= high){
            temp.add(arr[r]);
            r++;
        }

        int pos = low;
        for(Pair p: temp){
            arr[pos] = p;
            pos++;
        }
    }

}
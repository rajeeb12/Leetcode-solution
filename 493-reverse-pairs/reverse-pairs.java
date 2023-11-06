class Solution {
    // practise merge sort
    public int reversePairs(int[] nums) {
        int n = nums.length - 1;
        return sort(nums,0,n);
    }
    public int sort(int[] nums, int low, int high){
        int count = 0; 
        if(low >= high) return count;
        
        int mid = (low + high) >> 1;
        count += sort(nums, low, mid);
        count += sort(nums, mid + 1, high);
        count += countRev(nums, low, mid , high);
        merge(nums, low, mid, high);

        return count;
    }
    public void merge(int arr[], int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while(left <= mid && right <= high){
            if(arr[left] < arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }

        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }
        while(right <= high){
            temp.add(arr[right]);
            right++;
        }
        for(int i = low ; i <= high ; i++){
            arr[i] = temp.get(i - low);
        }
    }
    // this will give the count for each array
    public int countRev(int[] arr, int low, int mid, int high){
        int left = low, right = mid + 1, count =0 ;

        for(int i = low ; i <= mid ; i++){
            
            while(right <= high && (((long)arr[i]) > ((long) 2 * arr[right]))){
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }
}
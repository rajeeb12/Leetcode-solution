/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    
    public int firstBadVersion(int n) {
        if(n == 1) return 1;
        int low = 1 , high = n;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            boolean left = isBadVersion(mid - 1);
            boolean right = isBadVersion(mid);

            if(left == false && right == true)
            {
                return mid;
            }
            if(left == false && right == false)
            {
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return 0;
    }
    
}
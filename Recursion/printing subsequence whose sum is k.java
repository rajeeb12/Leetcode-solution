//traditional pick and not pick 
// subsequence sum equals to k
import java.util.*;
public class Main
{
     public static void solution(int i,int[] arr,ArrayList<Integer> bucket,int sum,int k)
    {
        if(i == arr.length)
        {
            if(sum == k)
            {
                System.out.print(bucket);
            }
            return;
        }
        bucket.add(arr[i]);
        sum += arr[i];
        solution(i+1,arr,bucket,sum,k);
        sum -= bucket.get(bucket.size()-1);
        bucket.remove(bucket.size()-1);
        solution(i+1,arr,bucket,sum,k);
    }

    // this is for if you want only one answer using recursion.
    
    // public static boolean solution(int i,int[] arr,ArrayList<Integer> bucket,int sum,int k)
    // {
    //     if(i == arr.length)
    //     {
    //         if(sum == k)
    //         {
    //             System.out.print(bucket);
    //             return true;
    //         }
    //         else
    //             return false;
    //     }

    //     bucket.add(arr[i]);
    //     sum += arr[i];
    //     if(solution(i+1,arr,bucket,sum,k)==true)
    //         return true;

    //     sum -= bucket.get(bucket.size()-1);
    //     bucket.remove(bucket.size()-1);
    //     if(solution(i+1,arr,bucket,sum,k)==true)
    //         return true;
        
    //     return false; 
    // }


    // This is for count the subsequence with sum k
    // public static int solution(int i,int[] arr,int sum,int k)
    // {
        // if(sum > k)
        //    return 0;
    //     if(i == arr.length-1)
    //     {
    //         if(sum == k)
    //         {
    //             System.out.print(bucket);
    //             return 1;
    //         }
    //         else
    //             return 0;
    //     }
    //     sum += arr[i];
    //     int l=solution(i+1,arr,bucket,sum,k);
    //         return true;

    //     sum -= arr[i];     
    //     int r= solution(i+1,arr,bucket,sum,k);
        
    //     return l+r; 
    // }
	public static void main(String[] args) {
		int arr[]= {1,2,1};
        int k=2;
        ArrayList<Integer> bucket= new ArrayList<>();
        solution(0,arr,bucket,0,k);
	}
}

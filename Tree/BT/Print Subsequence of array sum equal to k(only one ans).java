import java.util.*;
public class HelloWorld{

     public static void main(String []args){
         Scanner sc=new Scanner(System.in);
         int[] arr={1,2,1};
         int k=2;
         ArrayList<Integer> res=new ArrayList<>();
         boolean result=solution(0,res,arr,0,k);
         System.out.println(result);
     }
     public static boolean solution(int i,ArrayList<Integer> res,int[] arr,int sum,int k)
     {
        if(i==arr.length)
        {
            if(sum==k)
            {
                System.out.println(res);
                return true;
            }
            else
                return false;
        }
        res.add(arr[i]);
        sum +=arr[i];
        
        if(solution(i+1,res,arr,sum,k)==true) return true;
        
        sum -=arr[i];
        res.remove(res.size()-1);
        
        if(solution(i+1,res,arr,sum,k)==true) return true;
        
        return false;
     }
}
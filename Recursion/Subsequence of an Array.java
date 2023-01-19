import java.util.*;
public class HelloWorld{

     public static void main(String []args){
         Scanner sc=new Scanner(System.in);
         int[] arr={3,1,2};
         ArrayList<Integer> res=new ArrayList<>();
         solution(0,res,arr);
         
     }
     public static void solution(int i,ArrayList<Integer> res,int[] arr)
     {
        if(res.size()>=arr.length)
        {
            System.out.print(res);
            return;
        }

        //take or pick condition into the subsequence

        res.add(arr[i]);
        solution(i+1,res,arr);

        res.remove(res.size()-1);
        // not pick or not take condition ,this element is not added in your subsequence
        solution(i+1,res,arr);
     }
}
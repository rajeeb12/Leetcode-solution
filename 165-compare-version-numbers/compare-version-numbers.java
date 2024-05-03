class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[] = version1.split("[.]");
        String v2[] = version2.split("[.]");
        int i;
        for(i = 0; i < Math.min(v1.length, v2.length); i++)
        {
            int num1 = Integer.parseInt(v1[i]);
            int num2 = Integer.parseInt(v2[i]);
            if(num1 < num2)
            {
                return -1;
            }else if(num1 > num2){
                return 1;
            }
        }
        while(i < v1.length){
            int num = Integer.parseInt(v1[i]);
            if(num > 0){
                return 1;
            }
            i++;
        }
        while(i < v2.length){
            int num = Integer.parseInt(v2[i]);
            if(num > 0){
                return -1;
            }
            i++;
        }
        return 0;
    }
}
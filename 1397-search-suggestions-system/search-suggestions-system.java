class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products);
        for(int i = 0; i < searchWord.length(); i++){
            String substr = searchWord.substring(0, i + 1);
            List<String> temp = new ArrayList<>();
            for(String product: products){
                if(product.startsWith(substr)){
                    temp.add(product);
                }
                if(temp.size() == 3) break;
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}
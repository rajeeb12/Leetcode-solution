class Disjoinset{
    int parent[];
    int size[];
    public Disjoinset(int n)
    {
        parent = new int[n + 1];
        size = new int[n + 1];
        for(int i =0 ; i <=n ; i++)
        {
            parent[i] = i;
            size[i] = 1;
        } 
    }
    public int getParent(int node)
    {
        if(parent[node] == node)
        {
            return node;
        }
        parent[node] = getParent(parent[node]);
        return parent[node];
    }
    public void unionBySize(int node1, int node2)
    {
        int up1 = getParent(node1);
        int up2 = getParent(node2);

        int size1 = size[up1];
        int size2 = size[up2];
        if(up1 == up2) return;
        if(size1 == size2)
        {
            parent[up1] = up2;
            size[up2] *= 2;
        }
        else if(size[up1] < size[up2])
        {
            parent[up1] = up2;
            size[up2] += size[up1]; 
        }
        else{
            parent[up2] = up1;
            size[up1] += size[up2]; 
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> map = new HashMap<>();
        int n = accounts.size();
        Disjoinset ds= new Disjoinset(n);
        for(int i = 0 ; i < n; i++)
        {
            for(int j = 1; j < accounts.get(i).size(); j++)
            {
                String str = accounts.get(i).get(j);
                if(map.containsKey(str))
                {
                    ds.unionBySize(i ,map.get(str));

                }else{
                    map.put(str, i);
                }
            }
        }
        ArrayList<ArrayList<String>> mergedMail = new ArrayList<>();
        for(int i =0 ; i < n ; i++)
        {
            mergedMail.add(new ArrayList<>());
        }
        for(Map.Entry<String , Integer> entry: map.entrySet())
        {
            String str = entry.getKey();
            int parent = ds.getParent(entry.getValue());
            mergedMail.get(parent).add(str);
        }

        List<List<String>> ans= new ArrayList<>();
        for(int i =0 ; i < n ; i++)
        {
            if(mergedMail.get(i).size() == 0) continue;
            List<String> temp = new ArrayList<>();
            for(String str : mergedMail.get(i))
            {
                temp.add(str);
            }
            Collections.sort(temp);
            temp.add(0,accounts.get(i).get(0));
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int x : nums){
            int count;
            if(!mp.containsKey(x)){
                count = 1; 
            }
            else{
                count = mp.get(x) + 1;
            }
            mp.put(x,count);
        }

        List<Integer>[] bucket = new List[nums.length+1];
        for(int key : mp.keySet()){
            int value = mp.get(key);
            if(bucket[value] == null){
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key);
        }

        int count = k;
        int[] ans = new int[k];
        for(int i = nums.length ; i >= 0 ; i--){
            if(bucket[i] != null){
                for(int x : bucket[i]){
                    ans[count - 1] = x;
                    count--;
                    if(count == 0) break;
                }
            }
            if(count == 0) break;
        }
        return ans;

    }
}

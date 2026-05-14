class Solution {
    public String sortString(String str){
        if(str == null) return "";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> mp = new HashMap<>();

        for(int i = 0 ; i < strs.length ; i++){
            String origional = strs[i];
            String sorted = sortString(origional);
            if(!mp.containsKey(sorted)){
                mp.put(sorted,new ArrayList<>());
            }
            mp.get(sorted).add(origional);
        }

        return new ArrayList<>(mp.values());
    }
}

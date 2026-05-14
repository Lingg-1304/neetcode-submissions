
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> mp = new HashMap<>();

        for (String s : strs) {
            // 1. Tạo mảng đếm tần suất 26 chữ cái
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // 2. Chuyển mảng này thành một String để làm Key
            // Ví dụ: "abb" -> "#1#2#0#0..."
            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append('#'); // Ký tự phân tách để tránh nhầm lẫn
                sb.append(i);
            }
            String key = sb.toString();

            // 3. Gom nhóm vào Map
            if (!mp.containsKey(key)) {
                mp.put(key, new ArrayList<>());
            }
            mp.get(key).add(s);
        }

        return new ArrayList<>(mp.values());
    }
}
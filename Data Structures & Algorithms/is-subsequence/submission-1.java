class Solution {
    private Map<Character, List<Integer>> charIndices;
    private String cachedT; // remember which t we preprocessed
    
    public boolean isSubsequence(String s, String t) {
        // Build the index only if we haven't already, or if t has changed
        if (charIndices == null || !t.equals(cachedT)) {
            preprocess(t);
            cachedT = t;
        }
        
        int prevIndex = -1;
        
        for (char c : s.toCharArray()) {
            List<Integer> indices = charIndices.get(c);
            if (indices == null) return false;
            
            int pos = binarySearchGreater(indices, prevIndex);
            if (pos == -1) return false;
            
            prevIndex = pos;
        }
        
        return true;
    }
    
    private void preprocess(String t) {
        charIndices = new HashMap<>();
        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            charIndices.computeIfAbsent(c, k -> new ArrayList<>()).add(j);
        }
    }
    
    private int binarySearchGreater(List<Integer> indices, int target) {
        int lo = 0, hi = indices.size() - 1;
        int result = -1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (indices.get(mid) > target) {
                result = indices.get(mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return result;
    }
}
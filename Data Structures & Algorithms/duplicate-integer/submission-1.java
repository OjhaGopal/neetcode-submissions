class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
        if (!seen.add(num)) {  // add returns false if already present
            return true;
        }
    }
    return false;
    }
}
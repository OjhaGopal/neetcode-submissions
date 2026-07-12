class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
        if (seen.contains(num)) {
            return true;   // already seen → duplicate
        }
        seen.add(num);
    }

    return false;
    }
}
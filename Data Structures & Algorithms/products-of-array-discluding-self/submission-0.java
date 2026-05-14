class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] right = new int[1005];
        int[] left = new int[1005];
        right[0] = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            right[i] = right[i-1] * nums[i];
        }
        left[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2 ; i >= 0 ; i--){
            left[i] = left[i+1] * nums[i];
        }

        int[] ans = new int[nums.length];
        ans[0] = left[1];
        ans[nums.length - 1] = right[nums.length - 2];
        for(int i = 1 ; i < nums.length - 1; i++){
            ans[i] = right[i-1] * left[i+1];
        }
        return ans;
    }
}  

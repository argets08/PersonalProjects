package problems;

public class MaxSumSubArray {
    //thi is O(n) linear solution.
    // There exists a better divide and conquer solution O(nlongn)
    public int maxSubArray(int[] nums) {
        int temp = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (temp + nums[i] >= sum && temp + nums[i] >= nums[i]){
                temp = temp + nums[i];
                sum = temp;
            }
            else if (temp + nums[i] <= nums[i] && temp < nums[i] && nums[i] >= sum ){
                temp = nums[i];
                sum = nums[i];
            }else if (temp + nums[i] <= nums[i] && nums[i] > sum ){
                sum = nums[i];
                temp = sum;
            } else if(temp + nums[i] <= nums[i] && nums[i] < sum){
                temp = nums[i];
            }
            else{
                temp = temp + nums[i];
            }
        }
        return sum;
    }
}

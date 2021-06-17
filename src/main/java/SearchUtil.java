public class SearchUtil {

    //{4,5,6,7,0,1,2} return 0, sorted but rotated
    public static int findMinimum(int[] nums){
        return binarySearch(nums, 0, nums.length-1);
    }
//  middle start 0=4, middle 3=7, end 6=2
//    -----
    private static int binarySearch(int[] nums, int start, int end){
        if(start == end){
            return nums[start];
        }
        if(end-start == 1){
            return Math.min(nums[start], nums[end]);
        }
        int middle = start + (end-start)/2;
        if(nums[start]<nums[middle] && nums[end]<nums[middle]){//if middle is bigger from start and end go right
            return binarySearch(nums, middle+1, end);
        }else {
            return binarySearch(nums, start, middle);
        }
    }
}

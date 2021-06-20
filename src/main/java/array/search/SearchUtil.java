package array.search;

public class SearchUtil {

    public static int binarySearchPivot(int[] nums, int target){
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            if(target == nums[0]){
                return 0;
            }else{
                return -1;
            }
        }
        int pivotIndex = pivotIndex(nums);
        if(pivotIndex == 0){
            return binarySearch(nums, target, 0 , nums.length-1);
        }
        if(target>nums[nums.length-1]){
            return binarySearch(nums, target, 0 , pivotIndex-1);
        }else{
            return binarySearch(nums, target, pivotIndex , nums.length-1);
        }
    }

//    sorted array of distinct element in ascending order
    public static int binarySearch(int[] nums, int target){
        return binarySearch(nums, target, 0 , nums.length-1);
    }

    public static int binarySearch(int[] nums, int target, int start, int end){
        if(start > end){
            return -1;
        }
        int middle = start + (end-start)/2;
        if(target==nums[middle]){
            return middle;
        }
        if(target>nums[middle]){
            return binarySearch(nums, target, middle+1, end);
        }else{
            return binarySearch(nums, target, start, middle-1);
        }
    }
//rotated sorted array
    public static int pivotIndex(int[] nums){
        return pivotIndex(nums, 0 , nums.length-1);
    }

    private static int pivotIndex(int[] nums, int start, int end){
        if(start == end){
            return start;
        }
        if(end-start == 1 && nums[end]<nums[start]){
            return end;
        }

        int middle = start + (end-start)/2;
        if(nums[middle]>nums[end]){
            return pivotIndex(nums, middle, end);
        }else{
            return pivotIndex(nums, start, middle);
        }
    }
}

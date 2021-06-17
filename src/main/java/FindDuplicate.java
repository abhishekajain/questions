public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        //initialize temp boolean array of found numbers
        boolean[] foundit = new boolean[nums.length+1];

        int i = 0;
        while(i<nums.length){
            int num = nums[i];
            if(!foundit[num]){//if number is not previously found, set to found
                foundit[num] = true;
            }else{//if number is already is in the foundit, code found duplicate return this number
                return num;
            }
            i++;
        }

        return 0;

    }

}

import java.util.Arrays;

class Rotate {
 
    public void rotateTwoDimensionBy1Clockwise(char[][] input) {

    	int start = 0;
    	int end = input.length-1;
    	
    	while(start<end) {
        	int row = start;
        	int col = start;
    		char previous = input[row][col];
    		while(col<end) {
    			col++;
    			previous = swap(input, row, col, previous);  
    		}
    		while(row<end) {
    			row++;
    			previous = swap(input, row, col, previous);  
    		}
    		while(col>start) {
    			col--;
    			previous = swap(input, row, col, previous);    			
    		}
    		while(row>start) {
    			row--;
    			previous = swap(input, row, col, previous); 
    		}
    		start++;
    		end--;
    	}
    }
    
    private char swap(char[][] input, int row, int col, char previous) {
		char temp = input[row][col];
		input[row][col] = previous;
		return temp;
    }
    
    
    public void rotate(int[] nums, int k) {
        if(k < 1){
            return;
        }
        int length = nums.length;
        if(k>length){
            k = k-length;
        }
        int count = 0;
        for(int i=0; count<length; i++) {
        	int move = i;
        	int current = nums[move];
        	do {
        		int nextmove = move+k;
        		if(nextmove>=length) {
        			nextmove = nextmove -length;
        		}
        		int next = nums[nextmove];
        		nums[nextmove] = current;  
        		move = nextmove;
        		current = next;
                count++;
        	}while(i!=move);
        }        
    }  
    
    public void rotateR(int[] nums, int k) {
        if(k < 1){
            return;
        }
        int length = nums.length;
        k = k %length;

        reverse(nums, 0, length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, length-1);
    }    
    
    public void reverse(int[] nums, int start, int end) {
    	while(start<=end) {
    		int temp = nums[start];
    		nums[start] = nums[end];
    		nums[end] = temp;
    		start++;
    		end--;
    	}
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,2,3,4,5,6,7};
    	Rotate r = new Rotate();
    	//r.rotate(nums, 3);
    	r.reverse(nums, 0, 6);
    	r.reverse(nums, 0, 3-1);
    	r.reverse(nums, 3, 6);
    	System.out.println(Arrays.toString(nums));
    	
    	char[][] input = new char[4][4];
    	input[0][0] = 'A';
    	input[0][1] = 'B';
    	input[0][2] = 'C';
    	input[0][3] = 'D';    	
    	
    	input[1][0] = 'E';
    	input[1][1] = 'F';
    	input[1][2] = 'G';
    	input[1][3] = 'H';

    	input[2][0] = 'I';
    	input[2][1] = 'J';
    	input[2][2] = 'K';    
    	input[2][3] = 'L';
    	
    	input[3][0] = 'M';
    	input[3][1] = 'N';
    	input[3][2] = 'O';    
    	input[3][3] = 'P';

    	System.out.println(Arrays.deepToString(input));
    	r.rotateTwoDimensionBy1Clockwise(input);
    	System.out.println(Arrays.deepToString(input));

    }
}
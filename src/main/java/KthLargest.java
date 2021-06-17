import java.util.PriorityQueue;

class KthLargest{
	int k;
	PriorityQueue<Integer> pq;
	public KthLargest(int k, int[] arr){
		this.k = k;
		this.pq = new PriorityQueue<Integer>(k);
		int count = 0;
		for(int i=0; i<arr.length; i++){
			if(count == k){
				this.pq.offer(arr[i]);
				this.pq.poll();
			}else{
				this.pq.offer(arr[i]);
				count++;
			}
		}
	}


	public int add(int val){
		if(this.pq.size() == this.k){
			this.pq.offer(val);
			this.pq.poll();
		}else {
			this.pq.offer(val);
		}
		return this.pq.peek();
	}

	public static void main(String[] args){
		int k = 3;
		int[] arr = {4,5,8,2};//8-->.5-->4
		KthLargest kl = new KthLargest(k, arr);
		System.out.println(kl.add(3));//4
		System.out.println(kl.add(5));//5
		System.out.println(kl.add(10));//5
		System.out.println(kl.add(9));//8
		System.out.println(kl.add(4));//8

		int[] nums = {-10,1,3,1,4,10,3,9,4,5,1};
		KthLargest kln = new KthLargest(7, nums);
		System.out.println(kln.add(3));//4



	}
}
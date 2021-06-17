public class MinHeap {

    private int[] heap;
    private int size = 0;
    private final int maxSize;

    public MinHeap(int maxSize){
        this.heap = new int[maxSize];
        this.maxSize = maxSize;
    }

    private int getChild(int p, boolean left){
        return left?(2*p+1):(2*p+2);
    }

    private int getParent(int c){
        return (c-1)/2;
    }

    public int getMin(){
        return this.heap[0];
    }

    private void swap(int i, int j){
        int iVal = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = iVal;
    }

    public void push(int num){
        if(this.size == maxSize){
            throw new RuntimeException("Heap Full");
        }
        this.heap[this.size++] = num;
        if(this.size == 1){
            return;
        }

        int parentIndex = this.getParent(this.size-1);

        if(num<this.heap[parentIndex]){
            this.heapifyUp(this.size-1);
        }
    }

    public int pop(){
        if(this.size == 0){
            throw new RuntimeException("Heap Empty");
        }
        int element = this.heap[0];
        this.size--;
        this.heap[0] = this.heap[this.size];

        int leftChild = this.getChild(0, true);
        int rightChild = this.getChild(0, false);
        if (rightChild < this.size) {
            while(this.heap[0] > this.heap[leftChild] || this.heap[0] > this.heap[rightChild]){
                this.heapifyDown(0);
            }
        }else if(leftChild < this.size){
            while(this.heap[0] > this.heap[leftChild]){
                this.heapifyDown(0);
            }
        }
        return element;
    }

    private void heapifyDown(int fromIndex){
        int currentIndex = fromIndex;
        while(currentIndex<this.size) {
            int leftChild = this.getChild(currentIndex, true);
            int rightChild = this.getChild(currentIndex, false);
            if (rightChild < this.size) {
                if(this.heap[currentIndex]<= this.heap[leftChild] && this.heap[currentIndex]<= this.heap[rightChild]){
                    break;
                }
                if (this.heap[leftChild] <= this.heap[rightChild]) {
                    this.swap(currentIndex, leftChild);
                    currentIndex = leftChild;
                }else  {
                    this.swap(currentIndex, rightChild);
                    currentIndex = rightChild;
                }
            }else if(leftChild < this.size){
                if(this.heap[currentIndex]<= this.heap[leftChild]){
                    break;
                }
                else {
                    this.swap(currentIndex, leftChild);
                    currentIndex = leftChild;
                }
            }else{
                break;
            }
        }
    }

    private void heapifyUp(int fromIndex){
        int currentIndex = fromIndex;
        while(currentIndex>0){
            int parentIndex = this.getParent(currentIndex);
            if(this.heap[parentIndex]>this.heap[currentIndex]){
                this.swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            }else{
                break;
            }
        }
    }
}


public class UnionFindQuickUnion {
	
	private int[] elements;
	
	public UnionFindQuickUnion(int n) {
		elements = new int[n];
		for(int i=0; i<n; i++) {
			elements[i] = i;
		}
	}
	
	public void union(int p, int q) {
		int rootp = root(p);
		int rootq = root(q);
		if(rootp == rootq) {//this mean they are connected
			return;
		}
		elements[rootp] = rootq;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	private int root(int p) {
		while(elements[p] != p) {
			p = elements[p];
		}
		return p;
	}
}

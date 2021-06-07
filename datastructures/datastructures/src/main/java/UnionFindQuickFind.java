
public class UnionFindQuickFind {
	
	private int[] elements;
	
	public UnionFindQuickFind(int n) {
		elements = new int[n];
		for(int i=0; i<n; i++) {
			elements[i] = i;
		}
	}
	
	public void union(int p, int q) {
		if(!connected(p, q)) {
			int pid = elements[p];
			for(int i=0; i<elements.length; i++) {
				if(pid == elements[i]) {
					elements[i] = elements[q];
				}
			}
		}
	}
	
	public boolean connected(int p, int q) {
		return elements[p] == elements[q];
	}

}

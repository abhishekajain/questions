
public class UFTest {
	
	public static void main(String[] args) {
		UnionFindQuickFind uqf = new UnionFindQuickFind(10);
		uqf.union(0, 2);
		System.out.println(uqf.connected(0, 2));
		System.out.println(uqf.connected(0, 1));
		uqf.union(1, 2);
		System.out.println(uqf.connected(0, 1));
		uqf.union(4, 6);
		uqf.union(8, 9);
		System.out.println(uqf.connected(4, 5));
		uqf.union(6, 5);
		System.out.println(uqf.connected(4, 5));
		System.out.println("<<<<>>>");
		
		UnionFindQuickUnion uqu = new UnionFindQuickUnion(10);
		uqu.union(0, 2);
		System.out.println(uqu.connected(0, 2));
		System.out.println(uqu.connected(0, 1));
		uqu.union(1, 2);
		System.out.println(uqu.connected(0, 1));
		uqu.union(4, 6);
		uqu.union(8, 9);
		System.out.println(uqu.connected(4, 5));
		uqu.union(6, 5);
		System.out.println(uqu.connected(4, 5));		

	}
	
	
	public static void printIntArray(int[] intArray) {
		for(int i: intArray) {
			System.out.print(i+"->");
		}
	}

}

public class ZigZagConversion {
	
	public static void main(String arg[]) {
		System.out.println(convert("PAYPALISHIRING",3));
	}

	public static String convert(String s, int numRows) {
		if(numRows==1)
			return s;
		int i = 0;
		int j = 0;
		int strLength = s.length();
		int strCount = 0;
		String result = "";
		String[] arr = new String[numRows];
//		char[][] arr = new char[numRows][strLength];
		while (strCount < strLength) {
			while(i<numRows && strCount<strLength) {
//				arr[i++][j]=s.charAt(strCount++);		
				if(arr[i] == null) {
					arr[i] = "";
				}
				arr[i] = arr[i]+s.charAt(strCount++);
				i++;
			}
			i--;
			while(i>0 && strCount<strLength) {
//				arr[--i][++j]=s.charAt(strCount++);
				--i;
				arr[i] = arr[i]+s.charAt(strCount++);
			}
			i++;
		}
		for(int k=0;k<numRows;k++) {
			result=result+arr[k];
		}
		
//		for(int k=0;k<numRows;k++) {
//			for(int l=0;l<arr[k].length;l++) {
//				if(arr[k][l] != '\u0000')
//					result=result+arr[k][l];
//			}
//		}
		return result;
	}
}

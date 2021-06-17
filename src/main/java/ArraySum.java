import java.util.*;

public class ArraySum {
    //sum of any two elements is found in test array
    public static boolean arraySum(List<Integer> input, List<Integer> test){
        return false;
    }

    // xxx.xxx.xxx.xxx max len 12
//    12 31 45 92
//    123.145.9.2
//    1.23.145.92
    public static List<String> findIp(String numberString){
        int len = numberString.length();
        if(len>12){
            throw new IllegalArgumentException("not a valid stream");
        }
        char[] chars = numberString.toCharArray();
        List<String> result = new ArrayList<>();
        int i = 1;
        while (i<=3){
            int j = i+1;
            while (j<=(i+3)){
                int k = j+1;
                while (k<=(j+3) && k<chars.length-1){
                    int[] indexs = {0,i,j,k,chars.length};
                    if(isValid(chars, indexs)){
                        result.add(build(chars,indexs));
                    }
                    k++;
                }
                j++;
            }
            i++;
        }
        return result;
    }
    private static String build(char[] chars, int[] indexs){
        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (i<4){
            int start = indexs[i];
            int end = indexs[i+1];
            while (start<end){
                builder.append(chars[start++]);
            }
            if(i!=3) {
                builder.append('.');
            }
            i++;
        }
        return builder.toString();
    }
//    {0,1,2,3,length}
    private static boolean isValid(char[] chars, int[] indexs){
        int i = 0;
        while (i<4){
            if(!isValid(chars, indexs[i], indexs[i+1])){
                return false;
            }
            i++;
        }
        return true;
    }
    //start inclusive end exclusive
    private static boolean isValid(char[] chars, int start, int end){
        StringBuilder builder = new StringBuilder();
        while (start<end){
            builder.append(chars[start++]);
        }
        int number = Integer.parseInt(builder.toString());
        if(number<=255){
            return true;
        }
        return false;
    }
    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        if(h1.size() == 0 || h2.size() == 0 || h3.size() == 0){
            return 0;
        }
        SortedSet<Integer> h1Total = totalHeight(h1);
        SortedSet<Integer> h2Total = totalHeight(h2);
        SortedSet<Integer> h3Total = totalHeight(h3);

        SortedSet<Integer> minTotal = null;


        Integer min = Math.min(Math.min(h1Total.last(), h2Total.last()), h3Total.last());
        if(min.equals(h1Total.last())){
            minTotal = h1Total;
        }else if(min.equals(h2Total.last())){
            minTotal = h2Total;
        }else{
            minTotal = h3Total;
        }
        while (minTotal.size()>0){
            min = minTotal.last();
            if(h1Total.contains(min) && h2Total.contains(min) && h3Total.contains(min)){
                return min;
            }else{
                minTotal.remove(min);
            }

        }
        return 0;
    }

    //h1 = [3, 2, 1, 1, 1]
    //
    private static SortedSet<Integer> totalHeight(List<Integer> h){
        SortedSet<Integer> set = new TreeSet<>();
        int size = h.size()-1;
        int total = 0;
        while(size >=0){
            total += h.get(size--);
            set.add(total);
        }

        return set;
    }

    /*
 * given string input. longest substring. unique
 
 abcda = abcd, bcda
 
 aabdanghn = a, abd, bdangh, dangh,
 
 aaaa = a
 
 dersf = dersf
 
 "" = ""
 
 */
    public static String longestSubString(String str) {
        int index = 0;
        int startIndex = 0;
        int len = str.length();
        String result = "";
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (index<len){
            if(map.containsKey(str.charAt(index))){
                if((index-startIndex)>maxLen){
                    maxLen = (index-startIndex);
                    result = str.substring(startIndex, index);
                }
                startIndex = map.get(str.charAt(index))+1;//copy from start index to index in the hashmap
                index = startIndex;
                map = new HashMap<>();
            }else{
                map.put(str.charAt(index), index);
                index++;
            }
        }
        if(startIndex == 0 && index == len){
            return str;
        }
        return result;
    }

    public static String longestSubString1(String str) {
        char[] charArray = str.toCharArray();

        int max = 0;

        String maxStr = new String();


        for(int j=0;j<charArray.length;j++) {

            if(charArray.length - j < max) {
                break;
            }

            Set<Character> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();

            for(int i=j;i<charArray.length;i++) {

                if(set.contains(charArray[i])) {
                    if(sb.length() > max) {
                        max = sb.length();
                        maxStr = sb.toString();
                        break;
                    }
                }
                else {
                    set.add(charArray[i]);
                    sb.append(charArray[i]);
                }

            }

            if(sb.length() > max) {
                max = sb.length();
                maxStr = sb.toString();
            }

        }

        return maxStr;
    }
}

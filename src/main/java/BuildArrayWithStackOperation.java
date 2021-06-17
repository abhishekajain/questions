import java.util.ArrayList;
import java.util.List;

public class BuildArrayWithStackOperation {
    public List<String> buildArray(int[] target, int n) {

        int i = 0;
        int currentNumber = 1;
        List<String> result = new ArrayList<>();
        while(i<target.length){
            int taregetNumber = target[i];
            if(currentNumber == taregetNumber){
                result.add("Push");
                currentNumber++;
            }else{
                while(currentNumber<taregetNumber){
                    result.add("Push");
                    result.add("Pop");
                    currentNumber++;
                }
                result.add("Push");
                currentNumber++;
            }
            i++;
        }
        return result;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class ParenthesesUtil {

    static class Node{
        char item;
        int index;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return item == node.item;
        }

        @Override
        public int hashCode() {
            return Objects.hash(item);
        }
    }

//    ab(ef)()
    public static String minRemoveToMakeValid(String s) {
        return findUnmatchedParenthese(s);

    }


    public static String findUnmatchedParenthese(String s){
        if(s == null || s.length() == 0){
            return null;
        }
        //define empty stack
        Stack<Node> opentack = new Stack<>();
        Stack<Node> closestack = new Stack<>();

        char[] chars = s.toCharArray();
        int i = 0;
//        loop over string char array
        while(i<chars.length){
//            if '(' push to stack
            if(chars[i] == '('){
                Node node = new Node();
                node.index = i;
                node.item = chars[i];
                opentack.push(node);
            }else if(chars[i] == ')'){//if ')' check corresponding '('
                if(opentack.isEmpty() || opentack.peek().item != '('){
                    Node node = new Node();
                    node.index = i;
                    node.item = chars[i];
                    closestack.push(node);
                }else{
                    opentack.pop();
                }
            }
            i++;
        }
        i--;
        String result = "";
        while(i>=0){
            if(chars[i] == '('){
                if(!opentack.isEmpty() && opentack.peek().index == i){
                    opentack.pop();
                }else{
                    result = result + chars[i];
                }
            }else if(chars[i] == ')'){
                if(!closestack.isEmpty() && closestack.peek().index == i){
                    closestack.pop();
                }else{
                    result = result + chars[i];
                }
            }else{
                result = result + chars[i];
            }
            i--;
        }
//      if stack is empty at the end return true else false
        return reverse(result);
    }

    public static String reverse(String s){
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while (i<j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return String.copyValueOf(chars);
    }

    public static boolean isValidParenthese(String s){
        if(s == null || s.length() == 0){
            return true;
        }
        //define empty stack
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int i = 0;
//        loop over string char array
        while(i<chars.length){
//            if '(' push to stack
            if(chars[i] == '('){
                stack.push(chars[i]);
            }else if(chars[i] == ')'){//if ')' check corresponding '(' if does not find return false
                if(stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            }
            i++;
        }
//      if stack is empty at the end return true else false
        return stack.isEmpty();
    }
}

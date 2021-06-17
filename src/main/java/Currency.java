public class Currency {

    private final static char EURO = '€';
    private final static char YEN = '¥';
    private final static char DOLLAR = '$';

    private final static char NEGATIVE = '-';
    private final static char OPEN = '(';
    private final static char CLOSE = ')';

    private final static String DOLLAR_REGEX = "(\\d+|\\d{1,3}(,\\d{3})*)(\\.\\d{2})?";
    private final static String YEN_REGEX = "(\\d+|\\d{1,3}(,\\d{3})*)?";

    public static boolean isCurrency(String strAmount){
        char first = strAmount.charAt(0);
        if(first == OPEN){
            char last = strAmount.charAt(strAmount.length()-1);
            if(last != CLOSE){
                return false;
            }
            return isValidAmount(strAmount.substring(1, strAmount.length()-1));
        }else if(first == NEGATIVE){
            return isValidAmount(strAmount.substring(1));
        }else {
            return isValidAmount(strAmount);
        }
    }

    private static boolean isValidAmount(String strAmount){
        char first = strAmount.charAt(0);
        if(first == EURO || first == DOLLAR){
            return isDollarEuro(strAmount.substring(1));
        } else if(first == YEN){
            return isYen(strAmount.substring(1));
        } else{
            return false;
        }
    }


    private static boolean isDollarEuro(String strAmount){
        if(strAmount.charAt(0) == '0' ){
            return isCents(strAmount.substring(1));
        }else {
            return strAmount.matches(DOLLAR_REGEX);
        }
    }

    private static boolean isYen(String strAmount){
        return strAmount.matches(YEN_REGEX);
    }

    private static boolean isCents(String strAmount){
        double cents = Double.parseDouble(strAmount);
        if(cents>=1){
            return false;
        }
        return true;
    }

}

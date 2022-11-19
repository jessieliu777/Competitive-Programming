import java.util.*;
import java.util.regex.*;
class Solution {
    public boolean isNumber(String s) {
        s=s.toLowerCase();
        // [+-]? = option + or -
        // ((\\d+)|((\\d+\\.)|(\\d+\\.\\d+)|(\\.\\d+))) = 1 or more digits || 1 or more digits, dot || 1 or more digits, dot, 1 or more digits || dot, one or more digits
        // (e[+-]?\\d+)? = optional(e, optional sign, int)
        Pattern p=Pattern.compile("[+-]?((\\d+)|((\\d+\\.)|(\\d+\\.\\d+)|(\\.\\d+)))(e[+-]?\\d+)?");
        Matcher m=p.matcher(s);
        return m.matches();
    }
}
public class Atoi {
    public int myAtoi(String s) {
        int i = 0;
        int stringLen = s.length();   
        
        // 1. Whitespace
        while (i < stringLen && s.charAt(i) == ' ')
            i++;
        // 2. Signedness
        int sign = 1; // Positive is default
        if (i < stringLen && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') sign = -1;
            i++;
        }
        
        // 3. Conversion
        int result = 0;
        while (i < stringLen && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
                
            // 4. Rounding
            if (result > (Integer.MAX_VALUE - digit)/10){ // checking if result*10+digit>MAX_INTEGER
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            i++;
        }
        return result * sign;
    }    
}

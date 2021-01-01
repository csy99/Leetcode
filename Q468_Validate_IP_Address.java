package Leetcode;

/**
 * Created by csy99 on 12/31/20.
 */
public class Q468_Validate_IP_Address {
    public String validIPAddress(String IP) {
        int n = IP.length();
        if (n == 0) return "Neither";
        char last = IP.charAt(n-1);
        if (last == '.' || last == ':')
            return "Neither";
        
        String[] potentialIPv4 = IP.split("\\.");
        if (potentialIPv4.length == 4) {
            boolean ipv4 = true;
            for (String str: potentialIPv4) {
                if (!partIPv4(str)) {
                    ipv4 = false;
                    break;
                }
            }
            if (ipv4) return "IPv4";
        }
        
        String[] potentialIPv6 = IP.split(":");
        if (potentialIPv6.length == 8) {
            boolean ipv6 = true;
            for (String str: potentialIPv6) {
                if (!partIPv6(str)) {
                    ipv6 = false;
                    break;
                }
            }
            if (ipv6) return "IPv6";
        }
        
        return "Neither";
    }
    
    private boolean partIPv4(String str) {
        int n = str.length();
        if (n == 0 || n > 3) return false;
        if (n > 1 && str.charAt(0) == '0') return false;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') return false;
            sum = sum * 10 + (c - '0');
        }
        return sum < 256;
    }
    
    private boolean partIPv6(String str) {
        int n = str.length();
        if (n == 0 || n > 4) return false;
        for (int i = 0; i < n; i++) {
            boolean valid = false;
            char c = Character.toLowerCase(str.charAt(i));
            if (c >= '0' && c <= '9') 
                valid = true;
            if (c >= 'a' && c <= 'f')
                valid = true;
            if (!valid) return false;
        }
        return true;
    }
}

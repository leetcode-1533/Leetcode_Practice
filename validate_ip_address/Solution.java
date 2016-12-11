package validate_ip_address;

/**
 * Created by y1275963 on 12/10/16.
 */
import java.util.*;

public class Solution {
    public static String validIPAddress(String IP) {
        String[] ipv4 = IP.split("\\.");
        String[] ipv6 = IP.split(":");

        if (ipv4.length == 4) {
            for (String item : ipv4) {
                int temp = parser(item, 10);
                if (temp > 255 || temp < 0)
                    return "Neither";
            }
            return "IPv4";
        } else if (ipv6.length == 8) {
            int maxbound = parser("ffff", 16);
            int minbound = parser("0000", 16);
            for (String item : ipv6) {
                int temp = parser(item, 16);
                if  (temp > maxbound || temp < minbound)
                    return "Neither";
            }
            return "IPv6";
        }
        return "Neither";
    }

    private static int parser(String cont, int radix) {
        int re;
        try {
            re = Integer.parseInt(cont, radix);
        } catch(NumberFormatException e) {
            return -1;
        }
        if (radix == 10 && cont.length() > 1 && cont.charAt(0) == '0')
            return -1;
        if (radix == 16 && cont.length() > 4)
            return -1;
        return re;
    }

    public static void main(String[] args) {
//        System.out.println(Solution.parser("0255", 10));
//        System.out.println(432);
        ArrayList<String> test = new ArrayList<>();
        test.add("172.16.254.1");
        test.add("172.16.254.01");
        test.add("2001:0db8:85a3:0000:0000:8a2e:0370:7334");
        test.add("2001:db8:85a3:0:0:8A2E:0370:7334");
        test.add("2001:0db8:85a3::8A2E:0370:7334");
        test.add("02001:0db8:85a3:0000:0000:8a2e:0370:7334");
//        String test = "172.16.254.1";
        for (String item : test) {
            System.out.print(item + '\t');
            System.out.print(validIPAddress(item));
            System.out.println();
        }
    }
}

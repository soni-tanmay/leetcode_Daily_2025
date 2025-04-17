class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP == null || queryIP.isEmpty()) {
            return "Neither";
        }

        if (queryIP.contains(".")) {
            return isValidIPv4(queryIP) ? "IPv4" : "Neither";
        } else if (queryIP.contains(":")) {
            return isValidIPv6(queryIP) ? "IPv6" : "Neither";
        } else {
            return "Neither";
        }
    }

    private boolean isValidIPv6(String queryIP) {
        if (queryIP.endsWith(":") || queryIP.startsWith(":")) {
            return false;
        }
        String[] l = queryIP.split(":");
        if (l.length != 8) {
            return false;
        }
        for (String s : l) {
            if (s.length() < 1 || s.length() > 4 || !s.matches("[0-9a-fA-F]+")) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidIPv4(String queryIP) {
        if (queryIP.endsWith(".") || queryIP.startsWith(".")) {
            return false;
        }
        String[] l = queryIP.split("\\.");
        if (l.length != 4) {
            return false;
        }
        for (String s : l) {
            if (!s.matches("[0-9]{1,3}")) {
                return false;
            }
            int num = Integer.parseInt(s);
            if (num < 0 || num > 255 || (s.length() > 1 && s.charAt(0) == '0')) {
                return false;
            }
        }
        return true;
    }
}
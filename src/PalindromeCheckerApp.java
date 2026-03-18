public class PalindromeCheckerApp {
    public static boolean isPalindromeReverse(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reversed);
    }

    public static boolean isPalindromeTwoPointer(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String str, int left, int right) {
        if (left >= right) return true;
        if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) return false;
        return isPalindromeRecursive(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String testString = "madam";

        System.out.println("Palindrome Performance Comparison for: " + testString);

        // Reverse method
        long start = System.nanoTime();
        boolean result1 = isPalindromeReverse(testString);
        long end = System.nanoTime();
        System.out.println("Reverse Method: " + result1 + " | Time: " + (end - start) + " ns");

        // Two-pointer method
        start = System.nanoTime();
        boolean result2 = isPalindromeTwoPointer(testString);
        end = System.nanoTime();
        System.out.println("Two-Pointer Method: " + result2 + " | Time: " + (end - start) + " ns");

        // Recursive method
        start = System.nanoTime();
        boolean result3 = isPalindromeRecursive(testString, 0, testString.length() - 1);
        end = System.nanoTime();
        System.out.println("Recursive Method: " + result3 + " | Time: " + (end - start) + " ns");
    }
}
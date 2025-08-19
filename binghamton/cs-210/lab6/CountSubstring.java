class CountSubstring {
    public static int countSubstring(String stack, String needle) {
        if (stack.length() < needle.length()) {
            return 0;
        } else if (stack.startsWith(needle)) {
            return countSubstring(stack.substring(1), needle) + 1;
        } else {
            return countSubstring(stack.substring(1), needle);
        }
    }

    public static void main(String[] args) {
        // copied test cases from pdf.
        System.out.println(countSubstring("aabaa", "aa")); // Output: 2
        System.out.println(countSubstring("abcdef", "xyz")); // Output: 0
        System.out.println(countSubstring("abababab", "ab")); // Output: 4
        System.out.println(countSubstring("abcabcabc", "abc")); // Output: 3
        System.out.println(countSubstring("banana", "na")); // Output: 2
        System.out.println(countSubstring("thisisjustatest", "test")); // Output: 1
        System.out.println(countSubstring("ababa", "ab")); // Output: 2
        System.out.println(countSubstring("aaa", "a")); // Output: 3
        System.out.println(countSubstring("aaaaa", "aaa")); // Output: 3
    }
}
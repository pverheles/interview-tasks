package tenlettersubstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.stream.Collectors.toList;


/**
 * Given input string, return array of 10-long substrings which has more than 1 occurrence in the input string
 *
 * For example, given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", return: ["AAAAACCCCC", "CCCCCAAAAA"].
 *
 */
public class TenLetterSubstrings
{
    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(findTenLetterSubstrings(null)));
        System.out.println(Arrays.toString(findTenLetterSubstrings("")));
        System.out.println(Arrays.toString(findTenLetterSubstrings("AAA")));
        System.out.println(Arrays.toString(findTenLetterSubstrings("AAAAAAAAAA")));
        System.out.println(Arrays.toString(findTenLetterSubstrings("AAAAAAAAAAA")));
        System.out.println(Arrays.toString(findTenLetterSubstrings("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")));
    }

    static String[] findTenLetterSubstrings(String input) {
        if (input == null || input.length() < 11) {
            return new String[0];
        }

        Map<String, AtomicLong> counts = new HashMap<>();
        for (int i = 0; i < input.length() - 9; i++) {
            String substr = input.substring(i, i + 10);

            counts.computeIfAbsent(substr, k -> new AtomicLong(0)).incrementAndGet();
        }

        return counts.keySet().stream().filter(key -> counts.get(key).longValue() > 1).collect(toList()).toArray(new String[0]);
    }
}
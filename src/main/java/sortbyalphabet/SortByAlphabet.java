package sortbyalphabet;

/**
 * Given the ordered alphabet, sort chars in a string by this alphabet,
 * unknown chars (not present in alphabet) should go to the end of the string
 */
public class SortByAlphabet {
  public static void main(String[] args) {
    String data = "abftxrca";
    String alphabet = "acbfx";

    System.out.println("sortByCopyingCharsIntoSeparateArray: " + sortByCopyingCharsIntoSeparateArray(data, alphabet));
    System.out.println("sortBySwappingChars: " + sortBySwappingChars(data, alphabet));

    //result = "aacbfxtr"
  }

  private static String sortByCopyingCharsIntoSeparateArray(String data, String alphabet) {
    char[] output = new char[data.length()];

    int k = 0;
    for (int i = 0; i < alphabet.length(); i++) {
      char alphabetChar = alphabet.charAt(i);
      for (int j = 0; j < data.length(); j++) {
        if (data.charAt(j) == alphabetChar) {
          output[k] = alphabetChar;
          k++;
        }
      }
    }

    for (int i = 0; i < data.length(); i++) {
      if (alphabet.indexOf(data.charAt(i)) < 0) {
        output[k] = data.charAt(i);
        k++;
      }
    }

    return new String(output);
  }

  private static String sortBySwappingChars(String data, String alphabet) {
    char[] output = data.toCharArray();

    int offsetIndex = 0;
    for (int i = 0; i < alphabet.length(); i++) {
      for (int j = offsetIndex; j < output.length; j++) {
        if (output[j] == alphabet.charAt(i)) {
          if (j != offsetIndex) {
            swapThem(output, offsetIndex, j);
            offsetIndex++;
          } else {
            offsetIndex++;
          }
        }
      }
    }

    return new String(output);
  }

  private static void swapThem(char[] output, int m, int n) {
    char tmp = output[m];
    output[m] = output[n];
    output[n] = tmp;
  }
}

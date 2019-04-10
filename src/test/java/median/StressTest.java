package median;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by petroverheles on 3/12/19.
 */
public class StressTest {

    private static final int ATTEMPTS = 10000;

    private static final int NUMBER_OF_ELEMENTS = 101; // try different values here, both even and odd


    @Test
    public void stressTest() {
        Random random = new Random();

        for (int k = 0; k < ATTEMPTS; k++) {

            Solution solution = new Solution();
            NaiveSolution naiveSolution = new NaiveSolution();

            List<Integer> sequence = new ArrayList<>();

            for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
                int num = random.nextInt(5);

                sequence.add(num);

                solution.addNum(num);
                naiveSolution.addNum(num);
            }

            assertEquals("Failed for the sequence: " + sequence, naiveSolution.findMedian(), solution.findMedian());
        }
    }
}

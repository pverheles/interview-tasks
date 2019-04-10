package median;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by petroverheles on 3/12/19.
 */
public class NaiveSolution {
    private List<Integer> data = new ArrayList<>();

    public void addNum(int num) {
        data.add(num);
    }

    public double findMedian() {
        if (data.size() == 0) {
            throw new IllegalStateException("No elements were added");
        }

        if (data.size() == 1) {
            return data.get(0).doubleValue();
        }

        Collections.sort(data);

        int halfSize = data.size() / 2;
        if (data.size() % 2 == 1) {
            return data.get(halfSize).doubleValue();
        }

        return (data.get(halfSize - 1) + data.get(halfSize)) / 2D;
    }

    public static void main(String[] args) {
        NaiveSolution naiveSolution = new NaiveSolution();
//        naiveSolution.addNum(5);
//        naiveSolution.addNum(2);
//        naiveSolution.addNum(0);
//        naiveSolution.addNum(3);
//        naiveSolution.addNum(4);
//        naiveSolution.addNum(0);

        naiveSolution.addNum(1);

        naiveSolution.addNum(0);
        naiveSolution.addNum(3);
        //naiveSolution.addNum(4);


        System.out.println(naiveSolution.findMedian());
    }
}


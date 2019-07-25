package ipcounter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * implement ip counter class that will have two operations
 * incrementIP - increment counter of the given IP
 * top - return top N (for example, 100) elements with the highest counters
 *
 */
public class IPCounter {

    private Map<String, Counter> counters = new HashMap<>();
    private PriorityQueue<IPEntry> top = new PriorityQueue<>(
            Comparator.comparing(IPEntry::getCount));

    private int topNum;

    public IPCounter(int topNum) {
        this.topNum = topNum;
    }

    public void incrementIP(String ip) {
        counters.computeIfAbsent(ip, x -> new Counter()).increment();

        // move the element to the root of the heap and remove it
        top.add(new IPEntry(ip, 0L));
        top.poll();

        // add the element to the heap with the new counter value
        top.add(new IPEntry(ip, counters.get(ip).get()));

        // remove the element with the smallest counter if the heap contains more than needed elements
        if (top.size() > topNum) {
            top.poll();
        }
    }

    public Iterable<IPEntry> top() {
        List<IPEntry> result = top.stream().collect(Collectors.toList());
        Collections.reverse(result);
        return result;
    }

    private class Counter {
        private long count = 0;

        public Counter() {}

        private void increment() {
            count++;
        }

        private long get() {
            return count;
        }
    }

    private class IPEntry {
        private String ip;
        private Long count;

        public IPEntry(String ip, Long count) {
            this.ip = ip;
            this.count = count;
        }

        public String getIp() {
            return ip;
        }

        public Long getCount() {
            return count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IPEntry ipEntry = (IPEntry) o;
            return Objects.equals(ip, ipEntry.ip);
        }

        @Override
        public int hashCode() {
            return Objects.hash(ip);
        }

        @Override
        public String toString() {
            return "IPEntry{" +
                    "ip='" + ip + '\'' +
                    ", count=" + count +
                    '}';
        }
    }

    public static void main(String[] args) {
        IPCounter ipCounter = new IPCounter(2);
        ipCounter.incrementIP("ip1");
        ipCounter.incrementIP("ip1");
        ipCounter.incrementIP("ip2");
        ipCounter.incrementIP("ip3");
        ipCounter.incrementIP("ip3");
        ipCounter.incrementIP("ip3");
        ipCounter.incrementIP("ip4");

        System.out.println(ipCounter.top());
    }
}

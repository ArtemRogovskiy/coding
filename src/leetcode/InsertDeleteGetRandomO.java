package leetcode;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class InsertDeleteGetRandomO {

    public static void main(String[] args) {
        InsertDeleteGetRandomO o = new InsertDeleteGetRandomO();
        System.out.println(o.insert(1));
        System.out.println(o.remove(2));
        System.out.println(o.insert(2));
        System.out.println(o.getRandom());
        System.out.println(o.remove(1));
        System.out.println(o.insert(2));
        System.out.println(o.getRandom());
        System.out.println(o.getRandom());
    }

    Map<Integer, Integer> valueToIndex;
    List<Integer> values;
    Set<Integer> deleted;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandomO() {
        valueToIndex = new HashMap<>();
        values = new ArrayList<>();
        deleted = new HashSet<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valueToIndex.containsKey(val)) return false;
        valueToIndex.put(val, values.size());
        values.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!valueToIndex.containsKey(val)) {
            return false;
        }
        int index = valueToIndex.get(val);
        valueToIndex.remove(val);
        deleted.add(index);
        resize();
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int random = ThreadLocalRandom.current().nextInt(0, values.size());
        while (deleted.contains(random)) {
            random = ThreadLocalRandom.current().nextInt(0, values.size());
        }
        return values.get(random);
    }

    private void resize() {
        if (deleted.size() == values.size() / 2) {
            List<Integer> newList = new ArrayList<>();
            for (int i = 0; i < values.size(); i++) {
                if (deleted.contains(i)) continue;
                newList.add(values.get(i));
                valueToIndex.put(values.get(i), newList.size() - 1);
            }
            values = newList;
            deleted.clear();
        }
    }
}

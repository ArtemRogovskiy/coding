package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

class RandomizedSet {

    public static void main(String[] args) {
        RandomizedSet o = new RandomizedSet();
        System.out.println(o.insert(1));
        System.out.println(o.remove(2));
        System.out.println(o.insert(2));
        System.out.println(o.getRandom());
        System.out.println(o.remove(1));
        System.out.println(o.insert(2));
        System.out.println(o.getRandom());
        System.out.println(o.getRandom());
    }

    List<Integer> list;
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int i = map.get(val);
        map.remove(val);
        list.set(i, list.get(list.size() - 1));
        Integer replaced = list.remove((int) (list.size() - 1));
        if (replaced != val) {
            map.put(val, i);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());
        return list.get(randomNum);
    }
}

package course.leetcode.TopInterview150.a10_insertDeleteGetRandom;

/**
 * 380. Insert Delete GetRandom O(1)
 *
 * Implement the RandomizedSet class:
 *
 * 1) RandomizedSet() Initializes the RandomizedSet object.
 * 2) bool insert(int val) Inserts an item val into the set if not present. Returns true
 *      if the item was not present, false otherwise.
 * 3) bool remove(int val) Removes an item val from the set if present.
 *      Returns true if the item was present, false otherwise.
 * 4) int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one
 * element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 *
 *  Constraints:
 * -2^31 <= val <= 2^31 - 1
 * At most 2 * 10^5 calls will be made to insert, remove, and getRandom.
 * There will be at least one element in the data structure when getRandom is called.
 */
public class A10_InsertDeleteGetRandom {

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        assert set.insert(1);
        assert !set.remove(2);
        assert set.insert(2);
        int random = set.getRandom();
        assert random == 2 || random == 1;
        assert set.remove(1);
        assert !set.insert(2);
        random = set.getRandom();
        assert random == 2;


        set = new RandomizedSet();
        set.insert(0);
        set.insert(1);
        set.remove(0);
        set.insert(2);
        set.remove(1);
        random = set.getRandom();
        assert random == 2;

        set = new RandomizedSet();
        set.remove(0);
        set.remove(0);
        set.insert(0);
        assert set.getRandom() == 0;
        set.remove(0);
        assert set.insert(0);
    }
}

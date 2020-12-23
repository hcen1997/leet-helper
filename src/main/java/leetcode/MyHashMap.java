package leetcode;

import java.util.ArrayList;

/**
 * 使用链表实现hashmap
 */
class MyHashMap {
    private int size = 16;
    private ArrayList<ArrayList<KeyLoc>> hash;
    private ArrayList<Integer> table;
//    ????????

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        hash = new ArrayList<>(size);
        table = new ArrayList<>(size * size);
        for (int i = 0; i < hash.size(); i++) {
            hash.add(new ArrayList<>(size));
        }
    }

    private int loc(int key) {
        return -1;
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int h = key % 31;
        ArrayList<KeyLoc> keySet = hash.get(h);
        // 如果有， 更新
        if (get(key) != -1) {
            int loc = loc(key);
            table.set(loc, value);
        } else {
            int loc = table.size() + 1;
            table.add(value);
            keySet.add(new KeyLoc(key, loc));
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int h = key % 31;
        ArrayList<KeyLoc> keySet = hash.get(h);
        if (keySet.size() == 0) {
            return -1;
        } else {
            for (int i = 0; i < keySet.size(); i++) {
                if (keySet.get(i).key == key) {
                    return table.get(keySet.get(i).loc);
                }
            }
            return -1;
        }
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        // woc 这个remove不好写， 因为变地址会引起loc失常
        if(get(key)==-1){
            return;
        }
        int h = key % 31;
        // 不存在
        // 只有一个

        // 是个list
    }

    class KeyLoc {
        public KeyLoc(int key, int loc) {
            this.key = key;
            this.loc = loc;
        }

        public int key;
        public int loc;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
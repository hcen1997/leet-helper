import java.util.HashMap;

public class Hashmap {
    public static void main(String[] args) {
        Hashmap hashmap = new Hashmap();
        int hash = hashmap.hash(76);
        System.out.println("hash = " + hash);
    }
    int size;
    int[] table;

    public Hashmap() {
        size = 16;
        table = new int[size];
    }

    private int hash(int key) {
            int i =key;
            int h=key;
            while (i>0){
                i = i>>1;
                h = h*31+i&1;
            }
        return h;
    }

    public void put(int key, int val) {

    }

    public int get(int key) {
        return table[hash(key)];
    }
}

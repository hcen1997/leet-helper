package leetcode.level.easy.woked.rand4;

public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int sum = 0;
        for (String word : words) {
            ChStack chStack = new ChStack(chars);
            if (canSpell(word, chStack)) {
                sum += word.length();
            }
        }
        return sum;
    }

    private boolean canSpell(String word, ChStack chStack) {
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            if(!chStack.pull(aChar)){
                return false;
            }
        }
        return true;
    }

    class ChStack {
        private int[] map = new int[26];

        public ChStack(String chars) {
            char[] chars1 = chars.toCharArray();
            for (char c : chars1) {
                map[getIndex(c)]++;
            }
        }

        public boolean pull(char ch) {
            int index = getIndex(ch);
            if (map[index] != 0) {
                map[index]--;
                return true;
            } else {
                return false;
            }
        }

        private int getIndex(char ch) {
            return ch - 'a';
        }
    }
}

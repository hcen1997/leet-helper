package leetcode.level.easy.rand4;

public class ReverseWords {
    public String reverseWords(String s) {
        String trim = s.trim();
        String[] s1 = trim.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : s1) {
            if(word.length()>0){
                sb.insert(0,word+" ");
            }
        }
        if(sb.length()>0&&sb.charAt(sb.length()-1)==' '){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}

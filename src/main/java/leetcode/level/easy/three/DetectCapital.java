package leetcode.level.easy.three;

import java.util.Map;

public class    DetectCapital {
    public static void main(String[] args) {
        DetectCapital dc = new DetectCapital();
        Map<String, Boolean> s = Map.of(
                "a",true,
                "B",true,
                "Ab",true,
                "aa",true,
                "AA",true,
                "Aaaa",true,
                "aaaaa",true,
                "AAAAa",false,
                "AaA",false,
                "aaA",false
                );
        s.forEach((s1, aBoolean) -> {
            boolean b = dc.detectCapitalUse(s1);
            if(b!=aBoolean){
                System.out.println(s1);
            }
        });
    }
    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        boolean first = isLow(chars[0]);
        if(first){
            return allLow(chars,0,chars.length);
        }else {
            if(word.length()>1){
                boolean second = isLow(chars[1]);
                if(second){
                    return allLow(chars,1,chars.length);
                }else {
                    return allCap(chars,1,chars.length);
                }
            }else {
                return true;
            }
        }
    }
    boolean isLow(char c){
        return c>='a'&&c<='z';
    }
    boolean allLow(char[] chars,int s,int e){
        for (int i = s; i < e; i++) {
            if(!isLow(chars[i])){
                return false;
            }
        }
        return true;
    }
    boolean allCap(char[] chars,int s,int e){
        for (int i = s; i < e; i++) {
            if(isLow(chars[i])){
                return false;
            }
        }
        return true;
    }
}

package UI;

import java.util.ArrayList;
import java.util.Random;

public class Code {
    public static String getCode() {
        ArrayList<Character> code = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            code.add((char) ('A' + i));//A-Z
            code.add((char) ('a' + i));//a-z
        }
        Random r=new Random();
        String result=" ";
        for (int i = 0; i < 4; i++) {

            char c=code.get(r.nextInt(code.size()));
            result+=c;
        }
        int num=r.nextInt(10);
        result+=num;
        return result;

    }
}

package com.jackie.classbook.util;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/12/3
 */
public class ExportContentUtil {
    public static String[][] getContetn(List list, int length){
        String[][] content = new String[list.size()][length];
        for (int r = 0; r < list.size(); r ++){
            String string = list.get(r).toString();
            String[] strings = string.split(",");
            for (int c = 0; c < length; c ++){
                if (c == length - 1 && strings.length > length){
                    String s = "";
                    for (int i = c; i < strings.length; i ++){
                        s += strings[i];
                        if (i != strings.length - 1){
                            s += ",";
                        }
                    }
                    content[r][c] = s;
                } else {
                    content[r][c] = strings[c];
                }
            }
        }
        return content;
    }
}

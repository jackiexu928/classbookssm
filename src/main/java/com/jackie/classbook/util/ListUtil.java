package com.jackie.classbook.util;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/12/7
 */
public class ListUtil {
    public ListUtil() {
    }

    public static boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }

    public static boolean isNotEmpty(List list) {
        return !isEmpty(list);
    }
}

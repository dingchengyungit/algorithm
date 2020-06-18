package com.dcy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author dingchengyun
 * @date 2020/6/16
 * @description
 */
public class MainTest {
    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>(1);

        m.put("a", "a");
        m.put("b", "b");
        m.put("c", "c");
        m.put("d", "c");
        m.put("e", "c");
        m.put("f", "c");
        m.put("g", "c");
        m.put("h", "c");
        m.put("i", "c");
        m.put("j", "c");
        m.put("l", "c");
        m.put("k", "c");

        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("s");

    }
}

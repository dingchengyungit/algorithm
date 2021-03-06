package com.dcy;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

        m.containsKey("k");

        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("s");

        Queue<String> queue;


        String x = "1,2,3,4, ,5";
        List<String> articleIds1 = Arrays.stream(x.split(","))
                .filter(str -> !str.trim().isEmpty())
                .collect(Collectors.toList());

        List<Long> articleIds = Arrays.stream(x.split(","))
                .filter(str -> !str.trim().isEmpty())
                .map(str -> Long.valueOf(str))
                .collect(Collectors.toList());

        articleIds.forEach(aid -> {
            System.out.println(aid);
        });

        AtomicInteger ai = new AtomicInteger();

        removeList();

    }

    public static void removeList() {
        List<String> list = new LinkedList<>();
        List<String> arrList = new ArrayList<>();

        arrList.add("a");
        arrList.add("b");
        arrList.add("c");
        arrList.add("d");

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        int x = list.size();
        for (int i = 0; i < x; i++) {
            list.remove(i);
        }

        int y = arrList.size();
        for (int i = 0; i < y; i++) {
            arrList.remove(i);
        }

        System.out.println("xx");

    }
}

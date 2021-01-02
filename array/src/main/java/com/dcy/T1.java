package com.dcy;

import java.time.LocalDate;

/**
 * @author dingchengyun
 * @date 2020/11/23
 * @description
 */
public class T1 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.of(2021, LocalDate.now().getMonth().getValue(), LocalDate.now().getDayOfMonth());
        System.out.println(today);
    }
}

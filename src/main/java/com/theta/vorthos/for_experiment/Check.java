/*
package com.theta.vorthos.filter;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Slf4j
public class Check {
    static Set<Ku> kuSet = new HashSet<Ku>();
    static void atGo(String... args) {
        List<GrantYou> gList = new ArrayList<>(args.length);
        for (String arg : args) {
            gList.add(new GrantYou(arg));
        }
        log.info(gList.toString());
    }

    public static void main(String[] args) {
        kuSet.add(Ku.ROCK);
        kuSet.add(Ku.PAPER);
        System.out.println(String.valueOf(kuSet));
        atGo(kuSet.stream()
                .map(Ku::toString)
                .toArray(String[]::new));
    }
}
*/

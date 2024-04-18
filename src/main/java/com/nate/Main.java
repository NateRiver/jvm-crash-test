package com.nate;

import cn.hutool.core.bean.BeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * vm thread crash
 */
public class Main {
    private static final Random random = new Random();
    public static void main(String[] args) {
        int size=Integer.parseInt(args[0]);
        System.out.println("input size=>"+size);
        List<Source> sources = randomSources(size);
        List<Target> targets = sources.stream().map(e -> BeanUtil.copyProperties(e, Target.class)).collect(Collectors.toList());
        System.out.println("====DONE========"+targets.size());
    }

    private static List<Source> randomSources(int size) {
        List<Source> sources = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            sources.add(generateRandomSource());
        }
        return sources;
    }


    public static Source generateRandomSource() {
        Source source = new Source();
        source.setId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        source.setField1(generateRandomString());
        source.setField2(generateRandomString());
        source.setField3(generateRandomString());
        source.setField4(generateRandomString());
        source.setField5(generateRandomString());
        source.setField6(generateRandomString());
        source.setField7(generateRandomString());
        source.setField8(generateRandomString());
        source.setField9(generateRandomString());
        source.setField10(generateRandomString());
        source.setField(generateRandomInteger());
        return source;
    }

    private static String generateRandomString() {
        return UUID.randomUUID().toString();
    }

    private static int generateRandomInteger() {
        return random.nextInt();
    }

}
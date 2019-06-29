package com.github.hcsp.polymorphism;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Home2Test {
    @Test
    public void test() {
        Home2 home = new Home2();
        home.cats.add(new Cat("ABC"));
        home.cats.add(new Cat("123"));

        Assertions.assertEquals(Arrays.asList("ABC", "123"), home.getCatNames());
    }

    @Test
    public void hasStaticInnerClass() {
        Assertions.assertTrue(Modifier.isStatic(Home2.CatNameCollector.class.getModifiers()));
    }
}

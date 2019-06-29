package com.github.hcsp.polymorphism;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomeTest {
    @Test
    public void test() {
        Home home = new Home();
        home.cats.add(new Cat("ABC"));
        home.cats.add(new Cat("123"));

        Assertions.assertEquals(Arrays.asList("ABC", "123"), home.getCatNames());
    }

    @Test
    public void hasNonStaticInnerClass() {
        Assertions.assertFalse(Modifier.isStatic(Home.CatNameCollector.class.getModifiers()));
    }
}

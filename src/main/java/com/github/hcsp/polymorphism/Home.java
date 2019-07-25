package com.github.hcsp.polymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Home {
    List<Cat> cats = new ArrayList<>();

    public List<String> getCatNames() {
        CatNameCollector collector = new CatNameCollector();
        cats.forEach(collector);
        return collector.getCatNames();
    }

    // 记录日志
    private void log(Cat cat) {
        System.out.println("Collecting cat " + cat.getName());
    }

    // 在这个类里会产生一个编译错误
    // 请思考一下为什么
    // 并将此类改写成非静态的内部类，以修复此问题
    class CatNameCollector implements Consumer<Cat> {
        private List<String> catNames = new ArrayList<>();

        @Override
        public void accept(Cat cat) {
            log(cat);//log是一个实例，，编译器要访问外围实例的时候，需要和外围类实例想绑定，所以不能够使用static
            catNames.add(cat.getName());
        }

        private List<String> getCatNames() {
            return catNames;
        }
    }
}

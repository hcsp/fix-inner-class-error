package com.github.hcsp.polymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Home2 {
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

    static class CatNameCollector implements Consumer<Cat> {
        // 在这个类里会产生一个编译错误
        // 请思考一下为什么
        // 不要将此类改写成非静态的内部类
        // 而是引入一个外围类的实例以调用外围类的实例方法
        // private Home2 home;
        private List<String> catNames = new ArrayList<>();

        @Override
        public void accept(Cat cat) {
            log(cat);
            catNames.add(cat.getName());
        }

        private List<String> getCatNames() {
            return catNames;
        }
    }
}

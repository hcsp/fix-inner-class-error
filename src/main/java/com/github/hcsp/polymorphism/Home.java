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

        // 编译器偷偷摸摸的帮你注入了一个外围类的实例/对象
        // private Home this$0;
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

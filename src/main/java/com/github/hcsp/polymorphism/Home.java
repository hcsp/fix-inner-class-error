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
        /*
            不知道这样的解释对不对。。。

            类的初始化顺序是先从静态再到非静态，在内部静态类中调用外部类的非静态的成员时，其还未被加载到虚拟机（外部类的引用还找不到），
            所以无法编译。

            而通过实例调用，外围类已经被实例化了，可以调用其的方法
         */
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

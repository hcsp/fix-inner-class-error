package com.github.hcsp.polymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Home2 {
    List<Cat> cats = new ArrayList<>();

    public List<String> getCatNames() {
        CatNameCollector collector = new CatNameCollector(this); // 1. 这里传入外部类的实例
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
        // 2. 将外部类的实例保存为自身实例成员
         private Home2 home;
         public CatNameCollector(Home2 home) {
             this.home = home;
         }
        private List<String> catNames = new ArrayList<>();

        @Override
        public void accept(Cat cat) {
            // 3. 通过外部类实例来调用它的实例方法
            home.log(cat);
            catNames.add(cat.getName());
        }

        private List<String> getCatNames() {
            return catNames;
        }
    }
}

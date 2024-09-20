package com.github.hcsp.polymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Home2 {
    List<Cat> cats = new ArrayList<>();

    public List<String> getCatNames() {
        // 将 Home2 的实例传递给 CatNameCollector
        CatNameCollector collector = new CatNameCollector(this);
        cats.forEach(collector);
        return collector.getCatNames();
    }

    // 记录日志
    private void log(Cat cat) {
        System.out.println("Collecting cat " + cat.getName());
    }

    // 静态内部类
    static class CatNameCollector implements Consumer<Cat> {
        private Home2 home; // 保存外围类 Home2 的实例
        private List<String> catNames = new ArrayList<>();

        // 构造方法接受 Home2 的实例
        public CatNameCollector(Home2 home) {
            this.home = home;
        }

        @Override
        public void accept(Cat cat) {
            home.log(cat); // 使用 home 实例调用 log 方法
            catNames.add(cat.getName());
        }

        private List<String> getCatNames() {
            return catNames;
        }
    }
}

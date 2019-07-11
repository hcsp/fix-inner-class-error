package com.github.hcsp.polymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Home {
    List<Cat> cats = new ArrayList<>();

    public List<String> getCatNames() {
        List<String> catNames = new ArrayList<>();
        Consumer collector = new Consumer<Cat>(){
            @Override
            public void accept(Cat cat) {
                log(cat);
                catNames.add(cat.getName());
            }

            private List<String> getCatNames() {
                return catNames;
            }
        };
        cats.forEach(collector);
        return catNames;
    }

    // 记录日志
    private void log(Cat cat) {
        System.out.println("Collecting cat " + cat.getName());
    }

    // 在这个类里会产生一个编译错误
    // 请思考一下为什么
    // 并将此类改写成非静态的内部类，以修复此问题
    class CatNameCollector implements Consumer<Cat>{
        private List<String> catNames = new ArrayList<>();
        @Override
        public void accept(Cat cat) {
            log(cat);
            catNames.add(cat.getName());
        }

        private List<String> getCatNames() {
            return catNames;
        }
    };
}

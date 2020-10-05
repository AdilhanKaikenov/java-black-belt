package com.epam.adilkhan.nested_classes.anonymous_inner_class;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Math math = new Math() {
            @Override
            public int doOperation(int a, int b) {
                return a + b;
            }
        };

        System.out.println(math.doOperation(2, 2));

        MathTwo mathTwo = new MathTwo() {
            private final int c = 2;

            @Override
            int doOperation(int a, int b) {
                return super.doOperation(a, b) * 2;
            }
        };

        System.out.println(mathTwo.doOperation(2, 2));

    }
}

interface Math {
    int doOperation(int a, int b);
}

class MathTwo {
    int doOperation(int a, int b) {
        return a + b;
    }
}
package com.epam.adilkhan.nested_classes.local_inner_class;

public class LocalInner {
    public static void main(String[] args) {
        Math math = new Math();
        math.getResult(21, 4);
    }
}

class Math {

    public void getResult(final int dividend, final int divisor) {

        // Деление
        class Division {

            // частное
            public int getQuotient() {
                return dividend / divisor;
            }

            // остаток
            public int getRemainder() {
                return dividend % divisor;
            }
        }

        Division division = new Division();

        System.out.println("Dividend = " + dividend); // делимое
        System.out.println("Divisor = " + divisor); // делитель
        System.out.println("Quotient = " + division.getQuotient());
        System.out.println("Remainder = " + division.getRemainder());

    }
}
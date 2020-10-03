package com.epam.adilkhan.generics.parametrized_method;

import java.util.List;

public class ParametrizedMethod {
    // The method does not have to be static, it can be non-static
    public static <T> T getSecondElement(List<T> list) {
        return list.get(1);
    }
}

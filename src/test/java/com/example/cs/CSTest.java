package com.example.cs;

import org.junit.jupiter.api.Test;

public class CSTest {
    InternedStringinJava internedStringinJava = new InternedStringinJava();

    @org.junit.jupiter.api.Test
    void csInternedStringinJava() {
        internedStringinJava.func1();
        internedStringinJava.func2();
        internedStringinJava.func3();
    }

    고유락 java_lock = new 고유락();

    @Test
    void intrinsic_lock() {
        java_lock.new Reentrancy().a();
    }

}

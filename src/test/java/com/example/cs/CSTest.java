package com.example.cs;

import com.example.cs.CallByValueAndCallByReference.CallByReference;
import com.example.cs.CallByValueAndCallByReference.CallByValue와CallByReference;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CSTest {

    // InternedStringinJava
    InternedStringinJava internedStringinJava = new InternedStringinJava();

    @org.junit.jupiter.api.Test
    void csInternedStringinJava() {
        internedStringinJava.func1();
        internedStringinJava.func2();
        internedStringinJava.func3();
    }

    //고유락
    고유락 java_lock = new 고유락();

    @Test
    void intrinsic_lock() {
        java_lock.new Reentrancy().a();
    }

// 컴포지션
    컴포지션.CustomHashSet<String > customHashSet = new 컴포지션.CustomHashSet<>();

    @Test
    void customHashSet6() {
        List<String>test = Arrays.asList("a","b","c");
        customHashSet.addAll(test);
        System.out.println(customHashSet.getCount()); //6
    }

    컴포지션.CustomHashSet_com<String>customHashSet_com = new 컴포지션.CustomHashSet_com<>(new HashSet<>());
    @Test
    void CustomHashSet3() {
        List<String>test = Arrays.asList("a","b","c");
        customHashSet_com.addAll(test);
        System.out.println(customHashSet_com.getCount()); // 3
    }

    CallByValue와CallByReference callByValueAndCallByReference = new CallByValue와CallByReference();
    CallByReference callByReference = new CallByReference(3);
    @Test
    void valueAndReference() {
        System.out.println("call by value");
        callByValueAndCallByReference.call_by_value_main();
        System.out.println("call by reference");
        callByReference.call_by_reference_main();

    }
}

package com.example.cs;

import com.example.cs.CallByValueAndCallByReference.CallByReference;
import com.example.cs.CallByValueAndCallByReference.CallByValue와CallByReference;
import com.example.cs.JavaThread.Java에서의Thread;
import com.example.cs.JavaThread.ThreadTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

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


    @Test
    void castingExample() {
        Casting.Parent p = new Casting.Child();

        p.printInfo(); // 문제1 : 출력 결과는?
        Casting.Child c = (Casting.Child) new Casting.Parent(); //문제2 : 에러 종류는?
    }
    /*
    * 문제1 : Child Call!!!!

자바에서는 오버라이딩된 함수를 동적 바인딩하기 때문에, Parent에 담겼어도 Child의 printInfo() 함수를 불러오게 된다.

문제2 : Runtime Error

컴파일 과정에서는 데이터형의 일치만 따진다.
* 프로그래머가 따로 (Child)로 형변환을 해줬기 때문에 컴파일러는 문법이 맞다고 생각해서 넘어간다.
* 하지만 런타임 과정에서 Child 클래스에 Parent 클래스를 넣을 수 없다는 것을 알게 되고,
* 런타임 에러가 나오게 되는것!*/


    @Test
    void java_thread() {
        Java에서의Thread.Java_tread();
    }

    ThreadTest.Money shareMoney = new ThreadTest.Money();
    ThreadTest.Bread shareBread = new ThreadTest.Bread();
    @Test
    void MoneyThread() throws InterruptedException {
        //Money 자원 공유
        shareMoney.saveMoney(1000000000);
        shareMoney.minusMoney(50000000);
    }

    @Test
    void BreadThread() throws InterruptedException {
        //Bread 자원 공유
        shareBread.makeBread();
        shareBread.eatBread();
    }

//Stream예시

    @Test
    void streamMapTest() {
        StreamJava.setStreamMapNames();
    }

    @Test
    void streamReduceTest() {
        //numbers의 총합
        StreamJava.createStreamReduceSum();
        //설정값과 numbers의 총합
        StreamJava.createStreamInitialValueReduce();
        //설정값과 비어있는 값의 합
        StreamJava.createStreamInitialEmptyReduce();
    }

    @Test
    void streamFilterTest() {
        StreamJava.createStreamFilter();
    }

    @Test
    void streamCollectTest() {
        StreamJava.createStreamCollect();
    }

}

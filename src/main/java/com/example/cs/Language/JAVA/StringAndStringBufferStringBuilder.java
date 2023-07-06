package com.example.cs.Language.JAVA;

public class StringAndStringBufferStringBuilder {
    // String의 특징
        /*new 연산을 통해 생성된 인스턴스의 메모리 공간은 변하지 않음(immutable)
        *Garbage Collector 로 제거되어야 함.
        * 문자열 연산시 새로 객체를 만드는 Overhead 발생
        * 객체가 불변하므로, Multithread에서 동기화를 신경 쓸 필요가 없음.(조회 연산에 매우 큰 장점)
        * */
    //String 클래스 : 문자열 연산이 적고, 조회가 많은 멀티 쓰레드 환경에서 좋음

    //StringBuffer, StringBuilder 특징
        //공통점
            /*new 연산으로 클래스를 한 번만 만듬(Mutable)
            *문자열 연산시 새로 객체를 만들지 않고, 크기를 변경시킴
            *StringBuffer 와 StringBuilder 클래스의 메서드가 동일함
            * */
        //차이점
            //StringBuffer는 Thread-Safe함/ tringBuilder는 Thread-safe 하지 않음(불가능)

    //StringBuffer 클래스 : 문자열 연산이 많은 Multi-Thread 환경
    //StringBuilder 클래스 : 문자열 연산이 많은 Single-Thread 또는 Thread 신경 안쓰는 환경

}

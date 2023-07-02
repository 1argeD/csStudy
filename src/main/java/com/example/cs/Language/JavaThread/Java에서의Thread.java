package com.example.cs.Language.JavaThread;

public class Java에서의Thread {
    //요즘 OS는 모두 멀티태스킹을 지원한다.

        // 멀티태스킹이란?
    /* 예를 들면, 컴퓨터로 음악을 들으면서 웹서핑도 하는 것
    * 쉽게 말해서 두 가지 이상의 작업을 동시에 하는 것을 말한다. */

    /*
    * 실제로 동시에 처리될 수 있는 프로세스의 개수는 CPU 코어의 개수와 동일한데, 이보다 많은 개수의
    *프로세스가 존재하기 떄문에 모두 함꼐 동시에 처리 할 수는 없다.
    *
    * 각 코어들은 아주 짧은 시간동안 여러 프로세스를 번갈아가며 처리하는 방식으로 동시에 동작하는 것처럼
    *보이게 할 뿐이다.
    *
    * 이와 마찬가지로, 멀티스레딩이란 하나의 프로세스 안에 여러개의 스레드가 동시에 작업을 수해하는 것을
    * 말한다. 스레드는 하나의 작업단위라고 생각하면 편하다.
    * */

    //스레드 구현

        //자바에서 스레드 구현 방법은 2가지가 있다.
            /* 1.Runnable 인터페이스 구현
            * 2. Thread 클래스 상속
            * */
        //둘다 run() 메소드를 오버라이딩 하는 방식이다.

    //ex))
    public static class MyThread1 implements Runnable {
        @Override
        public void run() {
            //수행코드
        }
    }

    public class MyThread2 extends Thread {
        @Override
        public void run() {
            //수행코드
        }
    }

    //스레드 생성
        /*
            하지만 두가지 방법은 인스턴스 생성 방법에 차이가 있다.
            Runnable 인터페이스를 구현한 경우는, 해당 클래스를 인스턴스화해서 Thread 생성자에 argument로 넘겨줘야 한다.
            그리고 run() 을 호출하면 Runnable 인터페이스에서 구현한 run()이 호출되므로 따로 오버라이딩하지 않아도
            되는 장점이 있다.
        * */

    //ex)) CSTest 참조
    public static void Java_tread() {
        Runnable r = new MyThread1();
        Thread t = new Thread(r, "mythread");
    }


}

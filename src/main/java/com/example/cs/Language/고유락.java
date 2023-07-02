package com.example.cs.Language;

public class 고유락 {

    public static class Counter {
        private int count;

        public int no_thread_safe() {
            return ++count; //Thread-safe 하지 않은 연산
        }

        /*Q? ++count문은 atomic 연산인가?
        * A : read(count갑을 읽음) -> modify (count 값을 수정) -> write(count 값을 저장) 의 과정에서,
        * 여러 Thread가 공유 자원(count)로 접근할 수 있음.
        * 동시성 문제가 발생함)*/

        private Object lock = new Object();
        private int cnt;

        public int use_lock() {
            synchronized (lock) {
                return ++cnt;
                //lock 을 이용해서 count 변수의 접근을 막음.
            }
        }

        public int use_this() {
            synchronized (this) {
                return ++cnt;
                //this도 객체임으로 lock으로 사용이 가능함.
            }
        }

        public synchronized int no_use_lock() {
            return ++cnt;
            //lock의 생성 없이 synchronized 블록 구현이 가능하다.
        }

    }

    /*Reentrancy
    *
    * 재진입 : Lock을 획득한 Thread가 같은 Lock을 얻기 위해서 대기할 필요가
    * 없는 것 (Lock의 획득이 '호출 단위'가 아니니 Thread 단위로 일어나는것 )*/

    public class Reentrancy{
        //CSTset void intrinsic_lock() 참고**

        /*b가 synchronized로 선언 되어 있어도, a진입시 lock를 획득
        * b를 호출 할 수 있음*/
        public synchronized void a() {
            System.out.println("a");
            b();
        }

        public synchronized void b() {
            System.out.println("b");
        }

        /*Structured Lock vs Reentrant Lock
        *
        *Structured Lock (구조적 Lock) : 고유 lock을 이용한 동기화
        * (Structured 블록 단위로 lock의 획득 /헤제가 일어남)
        *
        * A획득 -> B획득 -> B해제 -> A해제는 가능하지만,
        * A획득 -> B획득 -> A해제-> B해제는 불가능함
        *
        * 이것을 가능하게 하기 위해서는 **Reentrant Lock(명시적 Lock)을
        * 사용해야함.
        * */
        
        
        /*Visibility
        * 
        * 가시성 : 여러 Thread가 동시에 작동하였을 때, 한 Tread가 쓴 값을 다른 Tread가
        * 볼 수 있는지, 없는지 여부
        *
        * 문제 : 하나의 Thread가 쓴 값을 다른 Thread가 볼 수 있느냐 없느냐.^^볼 수 없으면 문제가 됨^^
        * 원인 :
        * 1 최적화를 위해서 Compiler 나 CPU에 발생하는 코드 재배열로 인해서,
        * CPU core 의 cache 값이 Memory에 제때 쓰이지 않아 발생하는 문제 */


    }

}

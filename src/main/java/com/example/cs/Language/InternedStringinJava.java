package com.example.cs.Language;

import java.util.Objects;

public class InternedStringinJava {


    /*자바의 Sting은 불변 객체로 String의 함수를 호출하면 해당 객체를 직접 수정하는 것이 아니라, 함수의 결과 값으로 다른 객체를 반환한다.*/


    public void func1() {
        String myTestWord1 = new String("MYTESTWORD");
        String copiedMyTestWord = myTestWord1.toUpperCase();


        /*이 케이스의 경우  String이 불변 객체임에도"MYTESTWORD"를 선언한 후 .toUpperCase로 호출한 뒤 == 로 비교하면, True값이 반환되는데,
        * toUpperCase의 함수는 lower Case가 보이지 않을 경우 기존의 객체를 반환하기 떄문에 True가 반환하는 것이지
        * copiedTestWord와 myYestWord1는 다른 객체이며, 같은 문자를 가진 새로운 객체가 생성 되며 힙(heap)에 새로운 메모리를 할당한다.) */


        System.out.println ("케이스 1");
        System.out.println( myTestWord1 == copiedMyTestWord);
    }

    public void func2() {
        String myTestWord1 = new String("MYTESTWORD");
        String myTestWord3 = "MYTESTWORD";


        /*이 경우 -- 로 비교할 경우 false지만 .equals() 의 결과값은 true로 두 개의 문자열 값은 같지만, 실제로는 서로 다른 객체이다.*/


        System.out.println ("케이스 2");
        System.out.println(myTestWord1.equals(myTestWord3));
        System.out.println(myTestWord1 == myTestWord3);
    }

    public void func3() {
        String myTestWord3 = "MYTESTWORD";
        String myTestWord4 = String.valueOf("MYTESTWORD");


        /*리터럴로 선언한 객체와 String.valueOf로 가져온 객체를 비교하면, valueOf()의 경우 null인지 확인한 후 null이 아니라면 toString을 호출한다.
        * 여기서 String.toSting()는 this를 반환한다. 즉 두 구문 모두 리터럴 선언이다.*/


        System.out.println ("케이스 3");
        System.out.println(myTestWord3 == myTestWord4);
        System.out.println(myTestWord3.equals(myTestWord4));
    }

    /*JVM에서 constant pool을 통해서 문자열을 관리하고 있기 때문에 리터럴로 선언한 문자열이 constant pool에 있으면  해당 객체를 바로 가져온다.
    만약 pool에 없다면 새로 객체를 생성한 후, pool에 등록하고 가져온다. 이러한 플로우를 거치기 때문에 "MYTESTWORD"로 선언한 문자열은 같은 객체로 나오는 것이다.
    String.intern() 함수를 참고해보자.
     */
}

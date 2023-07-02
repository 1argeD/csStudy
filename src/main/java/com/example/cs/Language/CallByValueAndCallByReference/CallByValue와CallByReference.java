package com.example.cs.Language.CallByValueAndCallByReference;

public class CallByValue와CallByReference {
    //상당히 기본적인 질문이지만, 헷갈리기 쉬운 주제다.

    /*call by value
    *  값에 의한 호출
    *
    * 함수가 호출 될 떄, 메모리 공간 안에서는 함수를 위한 별도의 임시 공간이 생성됨 (종료 시 해당 공간 사라짐)
    * call by value 호출 방식은 함수 호출 시 전달되는 변수 값을 복사해서 함수 인자로 전달함
    * 이때 복사된 인자는 함수 안에서 지역적으로 사용되기 때문에 local value 속성을 가짐
    *
    *  따라서, 함수 안에서 인자 ㄱ밧이 변경되더라도, 외부 변수 값은 변경이 안 됨
    * */

    //ex)

    void call_by_value_func(int n) {
        n = 20;
    }

    public void call_by_value_main() {
        int n =10;

        System.out.println(n);
        call_by_value_func(n);
        System.out.println(n);
    }

    //println 그대로 10이 출력 된다.

    /*call by reference 호출 방식은 함수 호출 시 인자로 전달되는 변수의 레퍼런스를 전달함.
    * 따라서 하뭇 안에서 인자 값이 변경되면, 아규먼트로 전달된 객체의 값도 변경이 됨*/

    //*같은 패키지 안의 CallByReference와 CSTest의  valueAndReference() 참조
    //println으로 출력 되는 값은 20이다.

    /* Java의 함수는 항상 call by value로 값을 넘긴다. 그렇기에 일반적으로 Integer값으로 넘기거나 하는 방식으로
     * reference를 구현할 수 없다. 변수의 조사값 자체를 가져올 방법이 없기 때문이다.
     * 따라서 reference type을 넘길 시에는 해당 객체의 주소값을 복사해서 이를 가지고 사용해야한다.
     *  그렇기에  ^^원복 객체의 프로퍼티까지는 접근이 가능하나, 원본 객체 자체를 바꿀 수 없다.^^
     */

    /*
    User a = new User("gyoogle");   // 1

    foo(a);

    public void foo(User b){        // 2
        b = new User("jongnan");    // 3
    }

    /*
    ==========================================

    // 1 : a에 User 객체 생성 및 할당(새로 생성된 객체의 주소값을 가지고 있음)

     a   -----> User Object [name = "gyoogle"]

    ==========================================

    // 2 : b라는 파라미터에 a가 가진 주소값을 복사하여 가짐

     a   -----> User Object [name = "gyoogle"]
                   ↑
     b   -----------

    ==========================================

    // 3 : 새로운 객체를 생성하고 새로 생성된 주소값을 b가 가지며 a는 그대로 원본 객체를 가리킴

     a   -----> User Object [name = "gyoogle"]

     b   -----> User Object [name = "jongnan"]

*/
    /*
    * 파라미터에 객체/값의 주소값을 복사하여 넘겨주는 방식을 사용하고 있는 JAVA는 주소값을 넘겨 주소겂을
    넘겨 주소값에 저장되어 있는 값을 사용하는 call by reference 라고 오해할 수 있다.
    *
    * 이는 C/C++ 과 JAVA에서 변수를 할당하는 방식을 보면 알 수 있다.
     * */

    /*
    // c/c++

     int a = 10;
     int b = a;

     cout << &a << ", " << &b << endl; // out: 0x7ffeefbff49c, 0x7ffeefbff498

     a = 11;

     cout << &a << endl; // out: 0x7ffeefbff49c

    //java

     int a = 10;
     int b = a;

     System.out.println(System.identityHashCode(a));    // out: 1627674070
     System.out.println(System.identityHashCode(b));    // out: 1627674070

     a = 11;

     System.out.println(System.identityHashCode(a));    // out: 1360875712
    */


    /*c/c++ 에서는 생성한 변수마다 새로운 메모리 공간을 할당하고 이에 값을 덮어씌우는 형식으로 값을 할당한다.
    * (*포인터를 사용한다면, 같은 주소값을 가리킬 수 있도록 할 수 있다).
    *
    * 이를 다음과 같이 나타낼 수 있다.
    *
    *   C/C++        |        Java
                           |
        a -> [ 10 ]    |   a -> [ XXXX ]     [ 10 ] -> XXXX(위치)
        b -> [ 10 ]    |   b -> [ XXXX ]
                           |
                       값 변경
       a -> [ 11 ]    |   a -> [ YYYY ]     [ 10 ] -> XXXX(위치)
       b -> [ 10 ]    |   b -> [ XXXX ]     [ 11 ] -> YYYY(위치)
    *
    * b=a; 일 때 a의 값을 b의 값으로 덮어 씌우는 것은 같지만, 실제 값을 저장하는 것과 값의 주소값을 저장하는 것의
    * 차이가 존재한다.
    *
    * 즉 JAVA에서의 변수는 [할당된 값의 위치] 를 [값]으로 가지고 있는 것이다.
    *
    * C/C++ 에서는 주소값 자체를 인자로 넘겼을 때 값을 변경하면 새로운 값으로 덮어 쓰여 기존 값이 변경되고,
    * JAVA에서는 주소값이 덮어 쓰여지므로 원본 값은 전혀 영향이 가지 않는 것이다.(객체의 속성값에 접근하여 변경하는
    * 것은 직접 접근하여 변경하는 것이므로 이를 가리키는 변수들에서 변경이 일어난다.)

    * 객체 접근하여 속성값 변경

        a : [ XXXX ]  [ Object [prop : ~ ] ] -> XXXX(위치)
        b : [ XXXX ]

        prop : ~ (이 또한 변수이므로 어딘가에 ~가 저장되어있고 prop는 이의 주소값을 가지고 있는 셈)
        prop : [ YYYY ]    [ ~ ] -> YYYY(위치)

        a.prop = * (a를 통해 prop를 변경)

        prop : [ ZZZZ ]    [ ~ ] -> YYYY(위치)
                                 [ * ] -> ZZZZ

        b -> Object에 접근 -> prop 접근 -> ZZZZ
    *
    * 위와 같은 이유로 JAVA에서 인자로 넘길 때는 주소값이란 값을 복사하여 넘기는 것이므로 call by value 라고
    * 할 수 있다.
    *
    *
    * 정리
    *
    * call by value 의 경우, 데이터 값을 복사해서 함수로 전달하기 때문에 원본의
    * 데이터가 변경될 가능성이 없다. 하지만 인자를 넘겨줄 때마다 공간을 할당해야해서
    * 메모리 공간을 더 잡아먹는다.
    *
    * call by reference의 경우 메모리 공간 할당 문제는 해결했지만, 원본 값이 변경 될 수 있다는
    * 위험이 존재한다.
    * */
}

package com.example.cs.CallByValueAndCallByReference;

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
     *  그렇기에 ** 원복 객체의 프로퍼티까지는 접근이 가능하나, 원본 객체 자체를 바꿀 수 없다.
     */}

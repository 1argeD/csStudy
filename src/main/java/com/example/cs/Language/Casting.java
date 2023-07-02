package com.example.cs.Language;

public class Casting {
    // 업캐스팅과 다운캐스팅

    // 캐스팅이란?

    /*변수가 원하는 정보를 다 갖고 있는 것
    */
     /*
     int a = 0.1;  // (애러 발생 x)
     int b = (int) true;
   0.1은 double이지만, int 로 될 정보 또한 가지고 있음.
   true는 int형이 될 정보를 가지고 있지 않음

     */

    // 캐스팅이 필요한 이유

    /*
    * 1. 다형성 - 오버라이딩된 함수를 분리해서 활용할 수 있다.
    * 2. 상속 캐스팅을 통해 범용적인 프로그래밍이 가능하다.
     */

    // 형변환의 종류

    //묵시적 형변환 : 캐스팅이 자동으로 발생 (업캐스팅)

    /*
    * Parent p = new Child(); - new Child() 할 필요가 없음
    *Parent 를 상속받은 Child 는 Parent의 속성을 포함하고 있다
    */

    //2. 명시적 형변환 : 캐스팅할 내용을 적어줘야 하는 경우(다운캐스팅)

    /*
    * Parent p = new  Child();
    *Child c = (Child) p;
    * 
    * 다운캐스팅은 업캐스팅이 발생한 이후에 작동한다.
    * */

    //문제

    static class Parent {
        int age;

        Parent() {}

        Parent(int age) {
            this.age = age;
        }

        void printInfo() {
            System.out.println("Parent Call!!!!");
        }
    }

    static class Child extends Parent {
        String name;

        Child() {}

        Child(int age, String name) {
            super(age);
            this.name = name;
        }

        @Override
        void printInfo() {
            System.out.println("Child Call!!!!");
        }
        // CSTest로 이동할 것
    }
}

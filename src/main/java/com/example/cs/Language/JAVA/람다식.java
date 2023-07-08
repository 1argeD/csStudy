package com.example.cs.Language.JAVA;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class 람다식 {
    //1.람다식(Lamda Expression)이란>?

    /*Stream 연산들은 매개변수로 함수형 인터페이스(Functional Interface)를 받도록 되어있다. 그리고 람다식은 반환값으로
    * 함수형 인터페이스를 반환하고 있다. 그렇기 때문에, 람다식은 익명 함수의 한 종류라고 볼 수 있다.
    * 익명함수란 함수의 이름이 없는 함수로, 익명함수들은 모두 일급 객체이다.
    * 일급객체가 무엇인지는 앞선 포스팅에서 자세히 다루었다. 일급 객체인 함수는 변수로 전달이 가능하는 등의
    * 특징을 가지고 있다.
    * 기존의 방식에서는 함수를 선언할 때 다음과 같이 선언하였다.
    * */

    //기존 방식

    /*
    반환타입 메소드명 (매개변수, ...) {
        실행문
    }
    * */


    //ex

    public String hello() {
        return "Hello World!";
    }

    //하지만 람다 방식으로는 위와 같이 메소드 명이 불필요하며, 다음과 같이 괄호() 와 화살표-> 를 이용해 함수를 선언하게 된다

    //람다 방식
    // ( 매개변수 , ... ) -> { 실행문 ... }

    //ex
    // () -> "Hello World";

    /*이렇게 람다식이 등장하게 된 이유는 불필요한 코드를 줄이고, 가독성을 높이고 위함이다. 그렇기 때문에 함수형 인터페이스의
    * 인스턴스를 생성하여 함수를 변수처럼 선언하는 람다식에서는 메소드의 이름이 불필요하다고 여겨져서 이를
    * 사용하지 않는다. 대신 컴파일러가 문맥을 살펴 타입을 추론하다. 또한 람다식으로 선언된 함순느 1급 객체이기 때문에
    * Stream API의 매개변수로 전달이 가능해진다.*/

    //--------------------------------------------------------------------------------------------------------

    // 람다식 의 특징

    /*
    *람다식 내에서 사용되는 지역변수는 final 이 붙지 않아도 상수로 간주된다.
    * 람다식으로 선언된 변수명은 다른 변수명과 중복될 수 없다.
    */

    //람다식의 장점

    /*
    * 1, 코드를 간결하게 만들 수 있다.
    * 2, 식에서 개발자의 의도가 명확히 드러나 가독성이 높아진다.
    * 3, 함수를 만드는 과정없이 한번에 처리할 ㅜㅅ ㅣㅇㅆ어 생산성이 높아진다.
    * 4, 병렬프로그래밍이 용이하다.
     */

    //람다식의 단점

    /*
    *1. 람다를 사용하면서 만든 무몀의 함수는 재사용이 불가능하다.
    *2. 디버깅이 어렵다.
    *3. 람다를 남발하면 비슷한 함수가 중복 생성되어 코드가 지저분해질 수 있다.
    *4, 재귀로 만들경우에 부적합하다.
    */

    //결국 무조건 람다가 좋단는 보장은 없다. 상황에 따라 필요에 맞는 방법을 사용하는 것이 중요하다.

    //함수형 인터페이스란?

        // 함수형 인터페이스란?

        /*
            이제 우리는 람다식으로 순수 함수를 선언할 수 있게 되었다. 하지만Java는 기본적으로 객체지향 언어이기 떄문에 순수
            함수와 일반 함수를 다르게 취급하고 있으며, Java에서는 이를 구분하기 위해 함수형 인터페이스가 등장하게 되었다.
            함수형 인터페이스란 함수를 1급 객체처럼 다룰 수 있게 해주는 어노테이션으로, 인터페이스에 선언하여 단 하나의 추상
            메소드만을 갖도록 제한하는 역할을 한다. 함수형 인터페이스를 사용하는 이유는 Java의 람다식이 함수형 인터페이스를
            반환하기 때문이다.

            예를 들어 우리가 두 값 중 큰 값을 구하는 익명 함수를 개발하였다고 하자. 그러면 우리는 지금까지 다음과 같이 개발을
            하였을 것이다.
         */
        //CSTest 참고
        public static void Lamda1() {
            //기존의 익명함수
            System.out.println(new MyLambdaFunction() {
                public int max(int a, int b) {
                    return a > b ? a : b;
                }
            }.max(3, 5));
        }

        /*
        하지만 함수형 인터페이스의 등장으로 우리는 함수를 변수처럼 선언할 수 있게 되었고, 코드 역시 간결하게 작성할 수
        있게 되었다. 함수형 인터페이스를 구현하기 위해서는 인터페이스를 개발하여 그 내부에는 1개 뿐인 abstract 함수를
        선언하고, 위에는 @FunctionalInterface 어노테이션을 붙여주면 된다. 위의 코드를 람다식으로 변경하면 다음과 같다.
         */

    @FunctionalInterface
    interface MyLambdaFunction {
            int max(int a, int b);
    }
    //CSTest 참고
    public static void Lambda2() {
        MyLambdaFunction myLambdaFunction = (int a, int b) -> a > b ? a : b;
        System.out.println(myLambdaFunction.max(3,5));
    }
    /*
    이제 우리는 Java8 이전에 사용했던 익명함수들을 ㄹ마다식으로 변경해 코드를 줄일 수 있게 되었고,
    여기서 놓치지 말아야 하는 것은 람다식으로 생성된 순수 함수는 함수형 인터페이스로만 선언이 가능하다는 점이다.
    또한 @FunctionalInterface는 해당 인터페이스가 1개의 함수만을 갖도록 제한하기 때문에, 여러 개의 함수를 선언하면
    컴파일 에러가 발생할 것이라는 점이다.
    */

    //Java에서 제공하는 함수형 인터페이스

        //Java에는 자주 사용될 것 같은 함수형 인터페이스가 이미 정의되어 있으며, 총 4가지 함수형 인터페이스를 지원하고 있다.

    /*
    * Supplier<T>
    * Consumer<T>
    * Function<T,R>
    * Predicate<T>
    */

    //1. supplier <T>
    /*Supplier 는 매개변수 없이 반환값 만을 갖는 함수형 인터페이스다.
    *Supplier 는 T get() 을 추상 메소드로 갖고 있다.
    */

    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }
    static Supplier<String> supplier = () -> "Hello World!";
    public static void supplierFunction() {
        System.out.println(supplier.get());
    }
    
    //2. Consumer <T>
    /*
    Consumer는 객체 T를 매개변수로 받아서 사용하며, 반환값 없는 함수형 인터페이스다.
    Consumer는 void accept(T t)를 추상메소드로 갖는다.
    또한 Consumer는 andThen 이라는 함수를 제공하고 있는데, 이를 통해 하나의 함수가 끝난 후 다음 Consumer를
    연쇄적으로 이용할 수 있다.
    아래의 예제에서는 먼저 accept로 받아드린 Cousmer를 먼저 처리하고, andThen 으로 받은 두 번쨰
    Consumer를 처리하고 있다. 함수형에서 함수는 값의 대입 또는 변경 등이 없기 때문에 첫 번쨰 Consumer 가
    split으로 데이터를 변경하였다 하더라도 원본의 데이터는 유지 된다.
    */


    //ex CSTest 참조
    @FunctionalInterface
    public interface Consumer<T> {
        void accept(T t);

        default Consumer<T> andThen(Consumer<? super T> after) {
            Objects.requireNonNull(after);
            return (T t) -> {
                accept(t);
                after.accept(t);
            };
        }

    }
        //3. Function <T, R>

    /*
   Function은 객체 T를 매개변수로 받아서 처리한 후 R로 반환하는 함수형 인터페이스다.
   Functiom은 R apply(T t)를 추상메소드로 갖는다.
   또한 Function은 Consumer와 마찬가지로andThen을 제공하고 있으며, 추가적으로 compose를 제공하고 있다.
   앞에서 andThen은 첫 번째 함수가 실행된 이후에 다음 함수를 연쇄적으로 실행하도록 연결해준다고 하였다.
   하지만 compose는 첫 번째 함수 실행 이전에 먼저 함수를 실행하여 연쇄적으로 연결해준다는 점에서 차이가 있다.
   또한 identity 함수가 존재하는데, 이는 자기 자신을 반환하는 static함수이다.
    * */


        //ex CSTest 참조
        @FunctionalInterface
        public interface Function<T, R> {
            R apply(T t);

            default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
                Objects.requireNonNull(before);
                return (V v) -> apply(before.apply(v));
            }

            default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
                Objects.requireNonNull(after);
                return (T t) -> after.apply(apply(t));
            }

            static <T> Function<T, T> identity() {
                return t -> t;
            }
        }

        //4, Predicate<T>

        /*
         *Predicate는 객체 T를 매개 변수로 받아 처리한 후 Boolean을 반환하다.
         * Predicate는 Boolean test(T t)을 추상 메소드로 갖고 있다.
         * */

        //ex)) CSTest 참조
        @FunctionalInterface
        public interface Predicate<T> {
            boolean test(T t);

            default Predicate<T> and(Predicate<? super T> other) {
                Objects.requireNonNull(other);
                return (t) -> test(t) && other.test(t);
            }

            default Predicate<T> negate() {
                return (t) -> !test(t);
            }

            default Predicate<T> or(Predicate<? super T> other) {
                Objects.requireNonNull(other);
                return (t) -> test(t) || other.test(t);
            }

            static <T> Predicate<T> isEqual(Object targetRef) {
                return (null == targetRef)
                        ? Objects::isNull
                        : Object -> targetRef.equals(Object);
            }
        }

        //메소드 참조(Method Reference)

        /*
         * 메소드 참조란 함수형 인터페이스를 람다식이 이닌 일반 메소드를 참조시켜 선언하는 방법이다. 일반 메소드를 참조하기 위해서는
         * 다음의 3가지 조건을 만족해야 한다.
         * 1, 함수형 인터페이스의 매개변수 타입 = 메소드의 매개변수 타입
         * 2. 함수형 인터페이스의 매개변수 개수 =  메소드의 매개변수 개수
         * 3, 함수형 인터페이스의 반환형 = 메소드의 반환형
         *
         *참조가능한 메소드는 일반 메소드, Static 메소드, 생성자가 있으며 '클래스 이름 :: 메소드 이름' 으로 참조할 수 있다.
         * 이렇게 참조를 하면 함수형 엔터페이스로 반환이 된다.
         */

        //1. 일반 메소드 참조

        //예를 들어 위에서 보여준 Function에 메소드 참조를 적용한 다고 하자. 우선 해당 메소드(length)가 위의 3가지 조건을 만족하는지 살펴보아야 한다

        /*
         *   매개변수 없음
         *   매개변수 개수 = 0개
         *   반환형 = int
         */

        //String의 length 함수는 매개변수가 없으며, 반환형이 int로 동일하기 때문에 String :: length로 다음과 같은 메소드 참조를 적용할 수 있다.

        //기존의 람다식
        Function<String, Integer> standard = (str) -> str.length();

        //메소드 참조로 변경
        Function<String, Integer> method = String::length;

        /*또한 추가로 예시를 살펴보면, System.out,println() 메소드는 반환형이 void이며, 파라미터로 String을 받는 메소드이다.
         * 그렇기에 Consumer에 System.out.println() 메소드를 참조 시킬 수 있다.
         * */

        //ex - CSTest 참조
        //일반 메소드 참조
        Consumer<String> consumer = System.out::println;
        // 메소드 참조를 통해 Consumer를 매개변수로 받는 forEach를 쉽게 사용할 수 있다.
       public static List<String> list = Arrays.asList("유태", "태봉봉", "유태태", "듁수");

        public static <T> void forEach(List<T> list, Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : list ) {
            action.accept(t);
        }
    }

    //Static 메소드 참조

            /*
            Static 메소드 역시 참조가 가능하다. 예를 들어     Objects의 isNull은 반환값이 Boolean이며, 매개변수 값은 1개이고,
             매개 변수가 Object이므로 Predicate로 메소드 참조가 가능하다.
             */

    Predicate<Boolean> predicate = Objects :: isNull;

    public static boolean isNull(Object obj) {
        return obj == null; }

    //3. 생성자 참조
        /*생성자도 메소드 참조를 할 수 있다. 생성자는 new 로 생성 해주므로 클래스 이름 :: new로 참조 할 수 있다,
        * Supplier는 매개 변수가 없이 반환값만을 갖는 인터페이스이기 때문에, 매개변수 없이 String 객체를 새롭게 생성하는
        * String의 생성자를 참조하여 Supplier로 선언할 수 있다.
        */

    Supplier<String > supplierEx = String :: new;

}

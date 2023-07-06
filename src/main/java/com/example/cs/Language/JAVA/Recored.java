package com.example.cs.Language.JAVA;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Recored {
    // Java 14 에서 프리뷰로 도입된 클래스 타입
        //순수히 데이터를 보유하기 위한 클래스

    /* Java 14에서 도입이 되었고 16에서 정식으로 스펙에 포함된 Recored 타입은
    class 처럼 타입으로 사용이 가능하다
     객체를 생성할 떄 보통 아래와 같이 개발자가 만들어야한다.*/

    public class Person1 {
        private final String name;
        private final int age;

        public Person1(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String  getName() {
            return name;
        }

        public int getAge(){
            return age;
        }
    }

    /*
        1. 클래스 Person을 만든다.
        2. 필드 name, age를 생성한다.
        3. 생성자를 만든다.
        4. getter를 구현한다.
     */
    public record Person2(String name, Integer age) {

    }
    //긴 코드가 매우 간결해 졌다
        //이 record 클래스에 대해서 간단히 설명하면 아래와 같다.

    /*해당 record 클래스는 final이라 상속할 수 없다.
    * 각 필드는 private final 필드로 정의 된다.
    * 모든 필드를 초기화하는 RequiredAllArgument가 생성 된다
    * 각 필드의 getter는 getXXX()가 아닌, 필드명을 딴 getter가 생성된다(ex : name(), age(), address())
    * */

    /*
    *만약 josn serialize 가 되기 위해선 위와 같이 선언하지 말고 jason 어노테이션을 붙여줘야한다.
    ex))*/
    public record sampleRecordJason(
            @JsonProperty("name") String name,
            @JsonProperty("age") Integer age)
    {}
    //record는 static 변수를 가질 수 있고 , static&public method를 가질 수 있다.

    public record sampleStaticAndPublicMethod(
            @JsonProperty(value = "name") String name,
            @JsonProperty(value = "age") Integer age,
            @JsonProperty(value = "sex") String sex
    ) {
        static String STATIC_VARIABLE = "static variable";

        @JsonIgnore
        public String getInfo() {
            return this.name+ " " + this.age + " " +this.sex;
        }

        public static String get() {
            return STATIC_VARIABLE;
        }
    }
    // record 클래스의 생성사를 명시적으로 만들어서 생성자 매개변수를 validation 로직 등을 넣을 수 있다.

    public record ValidationLogic(
            @JsonProperty(value = "name") String name,
            @JsonProperty(value = "age") Integer age,
            @JsonProperty(value = "sex") String sex
     ) {
        public ValidationLogic {
            if(name == null || age == null || sex == null) {
                throw new IllegalArgumentException();
            }
        }

        static String STATIC_VARIABLE2 = "static variable";

        @JsonIgnore
        public String getInfo() {
            return this.name + " " + this.age + " " + this.sex;
        }
    }

    public static String get() {
        return  ValidationLogic.STATIC_VARIABLE2;
    }

    //이러한 record 클래스로 spring controller와 연계하여 사용하면 더 간결한 injection이 가능해지기 떄문에 훤씬 더 깔끔한 컨트롤러 작성이 가능하다
}

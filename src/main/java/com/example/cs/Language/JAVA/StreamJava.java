package com.example.cs.Language.JAVA;

import javax.xml.stream.events.Namespace;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJava {
    //Java 8 버전 이상부터는 Stream API를 지원한다.

    /*자바에서도 8버전 이상부터 람다를 사용한 함수형 프로그래밍이 가능해졌다.
        기존에 존재하던 Collection과 Stream은 무슨 차이가 있을까?
        바로 **데이터 계산 시점** 이다.
    * */

    //Collection
    /*
    * 모든 값을 메모리에 저장하는 자료구조다. 따라서 Collection에 추가하기 전에 미리 계산이 완료 되어 있어야한다
    *외부 반복을 통해 사용자가 직접 반복 작업을 거쳐 요소를 가져올 수 있다(for-each)
    * */

    //Stream
    /*
    * 요청할 때만 요소를 계산한다. 내부 반복을 사용하므로, 추출 요소만 선언해주면 알아서 반복 처리를 진행한다.
    *스트림에 요소를 따로 추가 혹은 제거하는 작업은 불가능하다.
    * */

    //Collection은 핸드폰에 음악 파일을 미리 저장하여 재생하는 플레이어라면, Stream은 필요할 떄 검색해서 듣는 멜론과 같은 음악 어플이라고 생각하면 된다.

    //외부 반복 & 내부 반복

    //Collection은 외부 반복, Stream은 내부 반복이다.   두 차이를 알아보자.

    /* 성능 명에서는 "내부 반복" 이 비교적 좋다. 내부 반복은 작업을 병렬 처리하여 최적화 된 순서로 처리해준다. 하지만
    *외부 반복은 명시적으로 컬렉션 항목을 하나씩 가져와서 처리해야하기 때문에 최적화에 불리하다.
    *
    * 즉, Collection에서 병렬성을 이용하려면 직접 synchronized를 통해 관리해야만 한다.
    * */
    //사진 참고
    //https://camo.githubusercontent.com/cafbe058a588b4c8e9e382f0fba3e93fabcced8da8ad0f3125c607a613799d8a/68747470733a2f2f6d656469612e766c70742e75732f696d616765732f6164616d322f706f73742f35656361623839612d346336302d346261362d626333362d3361353839313564386231622f696d6167652e706e67

    //Stream 연산

    /* 스트림은 연산 과정이 '중간'과 '최종' 으로 나누어진다,
    *  filter,map,limit 등 파이프라이닝이 가능한 연산을 중간 연산, count, collect 등 스트림을 닫는 연산을 최종 연산
    * 이라고 한다.
    * 둘로 나누는 이유는 , 중간 연산들은 스트림을 반환해야 하는데, 모두 한꺼번에 병합하여 연산을 처리한 다음
    * 최종 연산에서 한꺼번에 처리하게 된다.
    * */

    public class Item {
        private final String name;
        private final int price;


        public Item(String name, int price) {
            this.name = name;
            this.price =price;
        }

        public int getPrice() {
            return price;
        }
        public String getName() {
            return name;
        }
    }

    //ex)) Item 중에 가격이 1000 이상인 이름을 5개 선택한다.
    List<Item> items;

    {
        items = items.stream()
                .filter(item -> item.getPrice()>=1000)
                .limit(5)
                .collect(Collectors.toList());
    }
    //filter와 map은 다른 연산이지만, 한 과정으로 병합된다.
    /* 만약 Collection이었다면, 우선 가격이 1000이상인 아이템을 찾은 다음, 이름만 따로 저장한 뒤에
    * 5개를 선택해야 한다. 연산 최적화는 물론, 가독성 면에서도 Stream이 더 좋다.
    * */

    //Stream 중간 연산

    /*
    * filter(Predicate) : Predicate 를 인자로 받아 true인 요소를 포함하여 스트림 반환
    * distinct() : 중복 필터링
    * limit(n) : 주어진 사이즈 이하 크기를 갖는 스트림 반환
    * skip(n) : 처음 요소 n개를 제외한 스트림 반환
    * map(Function) : 매핑 함수의 result로 구성된 스트림 반환
    * flatMap() : 스트림의 콘텐츠로 매핑함. map과 달리 평면화된 스트림 반환
    * */

    // 중간 연산은 모두 스트림을 반환한다.

    //Stream 최종 연산

    /*
    * (boolean) allMatch(Predicate) : 모든 스트림 요소가 Predicate와 일치하는지 검사
    * (boolean) anyMatch(Predicate) : 하나라도 일치하는 요소가 있는지 검사
    * (boolean) noneMatch(Predicate) :매치되는 요소가 없는지 검사
    * (Optional) findAny() : 현재 스트림에서 임의의 요소
    * (Optional) findFirst() : 스트림의 첫번째 요소
    * reduce() : 모든 스트림 요소를 처리해 값을 도출. 두 개의 인자를 가짐.
    * collect() : 스트림을 reduce 하여, lest, map , 정수 형식 컬렉션을 만듬
    * (void) forEach() : 스트림 각 요소를 소비하여 람다 적용
    * (Long) count : 스트림 요소 개수 반환
    *  */

    //Optional 클래스

    // 값의 존재나 여부를 표현한느 컨테이너 Class

    /*
    * null 로 인한 버그를 막을 수 있다는 장점이 있다.
    * isPresent() : Optional이 값을 포함할 떄 Ture 반환
    * */

    //Stream 활용 예제 CSTest 참조
    static List<String > names = Arrays.asList("Frist강유태","Second두칠","Thrid포론포","Fourth나나문","지니피아","한결","고단씨","엶");
    //map()
    public static void setStreamMapNames() {
        names.stream()
                .map(String::toUpperCase)//
                .forEach(System.out::println);
    }


    //filter()
    public static void createStreamFilter() {
        List<String>streamFilter = names.stream()
                .filter(name -> name.startsWith("S")).toList();//S로 시작하는 값
        System.out.println(streamFilter);
    }
    //reduce()

    //스트림 전체 합
    public static void createStreamReduceSum() {
        Stream<Integer> numbers = Stream.of(1,2,3,4,5,6);
        Optional<Integer> result = numbers.reduce(Integer::sum); //sum으로 Integer의 합을 구함
        result.ifPresent(System.out::println);
    }

    //설정한 값과 스트림 전체의 합
    public static void createStreamInitialValueReduce() {
        Stream<Integer> numbers = Stream.of(1,2,3,4,5,6);
        Integer result = numbers.reduce(10, Integer::sum);
        System.out.println(result);
    }

    //설정한 값과 비어있는 스트림의 합
    public static void createStreamInitialEmptyReduce() {
        Stream <Integer> numbers = Stream.empty();
        Integer result = numbers.reduce(10,Integer::sum);
        System.out.println(result);
    }
    //collect()
    public static void createStreamCollect() {
        System.out.println(names.stream()
                .map(String :: toUpperCase)
                .collect(Collectors.joining(", ")));
    }
}

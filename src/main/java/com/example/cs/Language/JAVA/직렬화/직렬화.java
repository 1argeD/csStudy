package com.example.cs.Language.JAVA.직렬화;

import java.io.*;


public class 직렬화 {
    //직렬화
    //---------------------------------------------------------------------------------------------------------------------------------

    /* 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부의 자바 시스템에서도 사용할 수 있도록
    * 바이트(byte) 형태로 데이터 변환하는 기술*/

    /*각자의 PC의 OS 마다 서로 가상 메모리 주소 공간을 갖기 때문에, Reference Type의 데이터들은 인스턴스를
    * 전달 할 수 없다.
    *
    * 따라서, 이런 문제를 해결하기 위해서 주소값이 아닌 Byte 형태로 직렬화 된 객체 데이터를 전달해야 한다.
    *
    *직렬화 데이터들은 모두 기본형(Primitive Type)이 되고 , 이는 파일 저장이나 네트워크 전송시 파싱이 가능한
    * 유의미한 데이터가 된다. 따라서, 전송 및 저장이 가능한 데이터로 만들어 주는 것이 바로 직렬화(Serialization)이라고 할 수 있다.
    */

    //직렬화 조건
    //---------------------------------------------------------------------------------------------------------------------------------

    /*자바에서는 간단히 java.io.Serializable 인터스페이스 구현으로 직렬화/역직렬화가 가능하다.
    *  역직렬화는 직렬화된 데이터를 받는 쪽에서 다시 객체 데이터로 변환하기 위한 작업을 말한다.
    *
    * 직렬화 대상 : 인터스페이스 상속 받은 객체, Primitive 타입의 데이터
    * Primitive 타입이 아닌 Reference 타입 처럼 주소값을 지닌 객체들은 바이트로 변환하기 위해 Serializable 인터페이스를 구현해야 한다.
    * */


    //직렬화 상황
    //---------------------------------------------------------------------------------------------------------------------------------
    /*JVM에 상주하는 객체 데이터를 영속화할 때 사용
    * Servlet Session
    *Cache
    *Java RMI(Remote Method Invocation)*/

    //직렬화 구현
    //---------------------------------------------------------------------------------------------------------------------------------

    public 직렬화() throws IOException {
        Post post = new Post(1,"제목", "내용");
        String fileName = "Post.ser";

        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream out = new ObjectOutputStream(fos);
        ) {
            try {
                out.writeObject(post);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    /*ObjectOutputStream으로 직렬화를 진행한다. Byte로 변환된 값을 저장하면 된다.*/

    //역직렬화 구현
    //---------------------------------------------------------------------------------------------------------------------------------
    public void 역직렬화() throws IOException {
        String fileName = "Post.ser";

        try (
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream in = new ObjectInputStream(fis);
                ) {
            Post deserializedPost = (Post) in.readObject();
            System.out.println(deserializedPost);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    /*ObjectInputStream으로 역직렬화를 진행한다. Byte의 값을 다시 객체로 저장하는 과정이다.*/

    /*데이터 통신 상에서 전송 및 저장하기 위해서 직렬화/역직렬화를 사용한다*/
}

package com.example.cs;

import java.io.Serializable;


public class Post implements Serializable {
    //Serializable = 직렬화를 사용하겠다는 의도
    int id;
    String title;
    String content;

    public Post(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}


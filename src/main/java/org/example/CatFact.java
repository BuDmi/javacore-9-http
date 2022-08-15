package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CatFact {
    private String id;
    private String text;
    private String type;
    private String user;
    private Integer upvotes;

    public CatFact(
        @JsonProperty("id") String id,
        @JsonProperty("text") String text,
        @JsonProperty("type") String type,
        @JsonProperty("user") String user,
        @JsonProperty("upvotes") Integer upvotes) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return "CatFact{" +
            "id='" + id + '\'' +
            ", text='" + text + '\'' +
            ", type='" + type + '\'' +
            ", user='" + user + '\'' +
            ", upvotes=" + upvotes +
            '}';
    }
}

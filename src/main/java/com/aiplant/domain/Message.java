package com.aiplant.domain;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@EnableAutoConfiguration
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    int type;
    String text;
    private String groupId;
    private String groupName;

    private boolean isAt = false;

    private String userId;
    private String username;

    Long created = System.currentTimeMillis();

    public Message() {
    }

    public Message(int type, String text, String groupId, String groupName, String userId, String username) {
        this.type = type;
        this.text = text;
        this.groupId = groupId;
        this.groupName = groupName;
        this.userId = userId;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }


    public boolean isAt() {
        return isAt;
    }

    public void setAt(boolean at) {
        isAt = at;
    }

}

package com.example.demo.account;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("accounts")
public class Account {

    @Id
    private String id;
    private String username;
    private String emalil;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmalil() {
        return emalil;
    }

    public void setEmalil(String emalil) {
        this.emalil = emalil;
    }
}

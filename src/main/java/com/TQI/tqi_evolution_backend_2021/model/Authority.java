package com.TQI.tqi_evolution_backend_2021.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "authorities")

public class Authority {
    @Id
    String username;
    String authority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

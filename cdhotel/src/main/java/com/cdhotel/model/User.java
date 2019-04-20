package com.cdhotel.model;

import java.util.Date;

public class User {
    private Integer id;

    private String name;

    private String password;

    private String role;

    private Date createtime;

    private String createname;

    private String emolument;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    public String getEmolument() {
        return emolument;
    }

    public void setEmolument(String emolument) {
        this.emolument = emolument == null ? null : emolument.trim();
    }
}
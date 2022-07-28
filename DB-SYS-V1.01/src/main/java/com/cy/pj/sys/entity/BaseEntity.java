package com.cy.pj.sys.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;
}

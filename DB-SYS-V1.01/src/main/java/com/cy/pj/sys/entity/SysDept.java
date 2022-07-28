package com.cy.pj.sys.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysDept extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -6671658954498645857L;

    private Integer id;
    private String name;
    private Integer parentId;
    private Integer sort;
    private String note;
//    private Date createdTime;
//    private Date modifiedTime;
//    private String createdUser;
//    private String modifiedUser;

}

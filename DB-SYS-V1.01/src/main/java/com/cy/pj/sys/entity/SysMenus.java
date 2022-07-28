package com.cy.pj.sys.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysMenus extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 7252919955471461274L;
    private Integer id;
    private String name;
    private String url;
    private Integer type;
    private Integer sort;
    private String note;
    private Integer parentId;
    private String permission;
//    private Date createdTime;
//    private Date modifiedTime;
//    private String createdUser;
//    private String modifiedUser;

}

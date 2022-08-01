package com.cy.pj.sys.entity;

import lombok.Data;

@Data
public class SysUser extends BaseEntity {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String mobile;
    private Integer valid;
    private Integer deptId;
}

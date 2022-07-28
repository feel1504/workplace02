package com.cy.pj.sys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysRole extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 2870238028916628005L;
    private Integer id;
    private String  name;
    private String note;
//    private Date createdTime;
//    private Date modifiedTime;
//    private String  createdUser;
//    private String modifiedUser;
}

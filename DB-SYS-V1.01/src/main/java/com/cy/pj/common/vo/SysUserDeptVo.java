package com.cy.pj.common.vo;

import com.cy.pj.sys.entity.BaseEntity;
import com.cy.pj.sys.entity.SysDept;
import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserDeptVo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -7462980363207792514L;
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String mobile;
    private Integer valid=1;
    private SysDept sysDept;
}

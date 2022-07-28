package com.cy.pj.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SysRoleMenuVo implements Serializable {

    private static final long serialVersionUID = -8736534314621626350L;
    private Integer id;
    private String name;
    private String note;
    private List<Integer> menuIds;

}

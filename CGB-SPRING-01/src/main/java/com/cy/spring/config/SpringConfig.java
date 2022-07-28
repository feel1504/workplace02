package com.cy.spring.config;

import org.springframework.context.annotation.ComponentScan;

/**
 * 用于告诉spring容器
 * 从指定包进行bean的扫描
 */
@ComponentScan("com.cy.spring.beans")
public class SpringConfig {

}

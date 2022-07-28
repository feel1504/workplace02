package com.cy.spring.service;

import com.cy.spring.beans.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "defaultSearchService")
public class DefaultSearchService implements SearchService{
    @Autowired
    @Qualifier("defaultCache")
    Cache cache;
    public  String toString() {
        return "DefaultSearchService [cache=" + cache + "]";
    }
}

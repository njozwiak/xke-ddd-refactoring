package com.xebia.domain.comission;

import com.google.common.collect.Lists;

import java.util.List;

public class ComissionBook {

    private List<Comission> comissions = Lists.newArrayList();

    public List<Comission> getComissions() {
        return comissions;
    }

    public void setComissions(List<Comission> comissions) {
        this.comissions = comissions;
    }

}

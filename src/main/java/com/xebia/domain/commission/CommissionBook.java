package com.xebia.domain.commission;


import com.google.common.collect.Lists;

import java.util.List;

public class CommissionBook {

    private List<Commission> commissions = Lists.newArrayList();

    public List<Commission> getCommissions() {
        return commissions;
    }

    public void setCommissions(List<Commission> commissions) {
        this.commissions = commissions;
    }
}


package com.xebia.port.adapter.service;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

// Simulation d'une librairie externe
public class DataService {

    public BigDecimal getFixingPourDate(Date date) {
        return BigDecimal.TEN;
    }

    public List<BigDecimal> getFixingPourPeriode(Date dateDebut, Date dateFin) {
        return Lists.newArrayList();
    }

    public BigDecimal getCrossChange(Date date) {
        return BigDecimal.ONE;
    }
}

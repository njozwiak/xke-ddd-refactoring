package com.xebia.service;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.xebia.domain.ProductDecimal;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

// Couche anti corruption de DataService
public class ProductDataService {

    private DataService dataService;

    @Inject
    public ProductDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public ProductDecimal getFixingPourDate(Date date) {
        BigDecimal fixingPourDate = dataService.getFixingPourDate(date);
        return new ProductDecimal(fixingPourDate);
    }

    public List<ProductDecimal> getFixingPourPeriode(Date dateDebut, Date dateFin) {
        List<BigDecimal> fixingPourPeriode = dataService.getFixingPourPeriode(dateDebut, dateFin);
        Iterable<ProductDecimal> fixingInProductDecimal = Iterables.transform(fixingPourPeriode, new Function<BigDecimal, ProductDecimal>() {
            @Override
            public ProductDecimal apply(BigDecimal number) {
                return new ProductDecimal(number);
            }
        });

        return Lists.newArrayList(fixingInProductDecimal);
    }

    public ProductDecimal getCrossChange(Date date) {
        BigDecimal crossChange = dataService.getCrossChange(date);
        return new ProductDecimal(crossChange);
    }

}

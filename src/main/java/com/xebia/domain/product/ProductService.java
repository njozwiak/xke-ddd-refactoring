package com.xebia.domain.product;

import com.xebia.domain.echeance.EcheanceRequest;
import com.xebia.domain.currency.Currency;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jean-eudes
 * Date: 05/02/14
 * Time: 14:08
 * To change this template use File | Settings | File Templates.
 */
public interface ProductService {
    List<EcheanceRequest> valoriseProduct(Product product, Date dateValorisation);

    void addEcheanceToProduct(Long productId, EcheanceRequest echeance);

    BigDecimal applyCrossChange(BigDecimal value, Date date);

    Boolean containsFundingCurrencies(List<Currency> currencies);
}

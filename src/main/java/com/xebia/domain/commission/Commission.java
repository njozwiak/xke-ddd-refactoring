package com.xebia.domain.commission;

import com.xebia.domain.product.Product;

import java.math.BigDecimal;
import java.util.Date;

// TODO 1.1 move into the appropriate package

public class Commission {

    private Long id;

    private Date dateDebut;

    private Date dateFin;

    private Montant montant;

    // TODO 4.2 Remove
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Montant getMontant() {
        return montant;
    }

    public void setMontant(Montant montant) {
        this.montant = montant;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

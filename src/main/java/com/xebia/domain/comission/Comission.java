package com.xebia.domain.comission;

import com.xebia.domain.model.IdValueObject;

import java.math.BigDecimal;
import java.util.Date;

public class Comission extends IdValueObject {

    private Date dateDebut;

    private Date dateFin;

    private BigDecimal montant;

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

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
}

package com.xebia.domain.comission;

import com.xebia.domain.model.IdValueObject;

import java.math.BigDecimal;
import java.util.Date;

public class Comission extends IdValueObject {

    private Date dateDebut;

    private Date dateFin;

    private BigDecimal montant;

    protected Comission() {
      super();
    }

    public Comission(Date dateDebut, Date dateFin, BigDecimal montant) {
      this.setDateDebut(dateDebut);
      this.setDateFin(dateFin);
      this.setMontant(montant);
    }

    public Date dateDebut() {
        return dateDebut;
    }

    public Date dateFin() {
        return dateFin;
    }

    public BigDecimal montant() {
        return montant;
    }

    protected void setDateDebut(Date dateDebut) {
      this.dateDebut = dateDebut;
    }

    protected void setDateFin(Date dateFin) {
      this.dateFin = dateFin;
    }

    protected void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
}

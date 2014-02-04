package com.xebia.domain.comission;

import com.xebia.domain.model.IdValueObject;

import java.util.Date;

public class Comission extends IdValueObject {

    private Date dateDebut;

    private Date dateFin;

    private Montant montant;

    protected Comission() {
        super();
    }

    public Comission(Date dateDebut, Date dateFin, Montant montant) {
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

    protected void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    protected void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Montant getMontant() {
        return montant;
    }

    public void setMontant(Montant montant) {
        this.montant = montant;
    }

}

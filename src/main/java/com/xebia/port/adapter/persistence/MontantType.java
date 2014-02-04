package com.xebia.port.adapter.persistence;

import com.google.common.base.Objects;
import com.xebia.domain.comission.Montant;
import com.xebia.domain.currency.Currency;
import com.xebia.domain.echeance.ProductDecimal;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MontantType implements UserType {

    @Override
    public int[] sqlTypes() {
        int[] productDecimalTypes = ProductDecimalType.INSTANCE.sqlTypes();

        int[] myTypes = new int[productDecimalTypes.length + 2];

        for (int i = 0; i < productDecimalTypes.length; i++) {
            myTypes[i] = productDecimalTypes[i];
        }

        myTypes[myTypes.length - 2] = StringType.INSTANCE.sqlType();
        myTypes[myTypes.length - 1] = StringType.INSTANCE.sqlType();

        return myTypes;
    }

    @Override
    public Class returnedClass() {
        return BigDecimalType.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equal(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return Objects.hashCode(x);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
        assert names.length == 3;

        BigDecimal value = (BigDecimal) BigDecimalType.INSTANCE.get(rs, names[0], session);
        String name = (String) StringType.INSTANCE.get(rs, names[1], session);
        String isoCode = (String) StringType.INSTANCE.get(rs, names[2], session);

        if (null != value && null != name && null != isoCode) {
            return new Montant(new ProductDecimal(value), new Currency(name, isoCode));
        }

        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
        if (value == null) {
            preparedStatement.setNull(index, BigDecimalType.INSTANCE.sqlType());
            preparedStatement.setNull(index + 1, LongType.INSTANCE.sqlType());
        } else {
            Montant montant = (Montant) value;

            ProductDecimalType.INSTANCE.nullSafeSet(preparedStatement, montant.getValue(), index, session);
            preparedStatement.setObject(index + 1, montant.getCurrency().name());
            preparedStatement.setObject(index + 2, montant.getCurrency().isoCode());
        }

    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        if (value == null) {
            return null;
        }

        Montant montant = (Montant) value;

        return new Montant(montant.getValue(), montant.getCurrency());
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public Object assemble(Serializable serializable, Object owner) throws HibernateException {
        return serializable;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        if (original == null) {
            return null;
        }

        return original;
    }

}

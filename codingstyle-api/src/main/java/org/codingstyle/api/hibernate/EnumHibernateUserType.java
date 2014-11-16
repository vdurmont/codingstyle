package org.codingstyle.api.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public abstract class EnumHibernateUserType<T extends Enum> implements UserType {
    // //////////////////////
    // VARIABLES
    // //////////////

    private static final int[] SQL_TYPES = {Types.INTEGER};

    // //////////////////////
    // CONSTRUCTORS
    // //////////////

    // //////////////////////
    // METHODS
    // //////////////

    @Override
    public int[] sqlTypes() {
        return SQL_TYPES;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == null && y == null) {
            return true;
        } else if (x == null || y == null) {
            return false;
        } else {
            return x.equals(y);
        }
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
        String name = rs.getString(names[0]);
        T result = null;
        if (!rs.wasNull()) {
            int code = Integer.valueOf(name);
            for (Object entity : this.returnedClass().getEnumConstants()) {
                T enumEntity = (T) entity;
                if (getIntCode(enumEntity) == code) {
                    result = enumEntity;
                }
            }
        }
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
        if (null == value) {
            st.setNull(index, Types.INTEGER);
        } else {
            T type = (T) value;
            st.setInt(index, getIntCode(type));
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
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
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }

    protected abstract int getIntCode(T enumEntity);
}

package com.movieApp.config;

import com.movieApp.entity.movieEntity;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

public class MovieIdGenerator extends SequenceStyleGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object owner) throws HibernateException {
        final String id;
        if (this.allowAssignedIdentifiers() && owner instanceof movieEntity) {
            id = ((movieEntity) owner).getOmdbID();
        } else {
            id = null;
        }
        return id != null ? id : super.generate(session, owner);
    }

    @Override
    public boolean allowAssignedIdentifiers() {
        return true;
    }
}

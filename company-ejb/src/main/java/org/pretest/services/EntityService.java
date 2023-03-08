package org.pretest.services;

import javax.ejb.Remote;
import java.io.Serializable;
import java.util.List;
@Remote
public interface EntityService <T extends Serializable> {
    List<T> getEntities();
    T getEntityById(String id);
    boolean addEntity(T entity);
    boolean updateEntity(T entity);
    boolean deleteEntity(String id);
}

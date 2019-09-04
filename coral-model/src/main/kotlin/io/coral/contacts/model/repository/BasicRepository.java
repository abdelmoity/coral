package io.coral.contacts.model.repository;

import io.coral.contacts.model.domain.AbstractEntity;
import java.util.List;

public interface BasicRepository {

      AbstractEntity add(AbstractEntity entity);

      AbstractEntity update(AbstractEntity entity);

      AbstractEntity delete(AbstractEntity entity);

      List<AbstractEntity> findAll(String entity, int offset, int maxSize);

}

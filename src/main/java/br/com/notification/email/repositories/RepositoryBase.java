package br.com.notification.email.repositories;

import br.com.notification.email.utils.RandomUUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public interface RepositoryBase<T> extends JpaRepository<T, UUID> {

    @Override
    default <S extends T> S save(S entity) {
        return saveAndFlush(RandomUUID.uuidIfNone(entity));
    }

    @Transactional
    default <S extends T> List<S> saveAll(Iterable<S> entities) {
        List<S> persistedEntities = new ArrayList<>();
        entities.forEach(entity -> persistedEntities.add(this.save(entity)));
        return persistedEntities;
    }
}


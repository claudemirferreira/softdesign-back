package com.softdesign.demo.base.core.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<E> extends PagingAndSortingRepository<E, UUID> {

    Optional<E> findById(UUID id);

    E getById(UUID id);

    List<E> getByIds(Collection<UUID> ids);

    <S extends E> S save(S entity);

    void delete(E e);

    List<E> findAll();

}

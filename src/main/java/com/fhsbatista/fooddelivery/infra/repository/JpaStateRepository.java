package com.fhsbatista.fooddelivery.infra.repository;

import com.fhsbatista.fooddelivery.domain.model.State;
import com.fhsbatista.fooddelivery.domain.repository.StateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class JpaStateRepository implements StateRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<State> list() {
        final var query = manager.createQuery("from State", State.class);
        return query.getResultList();
    }

    @Override
    public State findById(Long id) {
        return manager.find(State.class, id);
    }

    @Override
    @Transactional
    public State save(State state) {
        return manager.merge(state);
    }

    @Override
    @Transactional
    public State update(State state) {
        return manager.merge(state);
    }

    @Override
    @Transactional
    public void delete(State state) {
        state = findById(state.getId());
        manager.remove(state);
    }
}

package com.api_tareas.persistence.dao.implementations;

import com.api_tareas.persistence.dao.interfaces.ITareasDAO;
import com.api_tareas.persistence.entity.TareasEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class ITareasDAOImpl implements ITareasDAO {//ESTA TAREA ES LA QUE VA A INTERACTUAR CON LA BASE DE DATOS

    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional(readOnly = true)
    public List<TareasEntity> obtenerTodos() {
        return this.em.createQuery("SELECT u FROM TareasEntity u").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TareasEntity> obtenerPorId(Long id) {
        return Optional.ofNullable(this.em.find(TareasEntity.class,id));
    }

    @Override
    @Transactional
    public void crearTarea(TareasEntity tareasEntity) {
        this.em.persist(tareasEntity);
        this.em.flush();//Esto para que se sincronice con la base de datos correctamente
    }

    @Override
    @Transactional
    public void modificarTarea(TareasEntity tareasEntity) {
        this.em.merge(tareasEntity);
    }

    @Override
    @Transactional
    public void eliminarTarea(TareasEntity tareasEntity) {
        this.em.remove(tareasEntity);
    }
}

package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);

	}

	@Override
	public Estudiante buscar(Integer id) {
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		Estudiante estu = this.buscar(id);
		this.entityManager.remove(estu);
	}

	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		CriteriaBuilder myBuilder=this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Estudiante> myQuery=myBuilder.createQuery(Estudiante.class);

        Root<Estudiante> miRoot = myQuery.from(Estudiante.class);

        Predicate condicion=myBuilder.equal(miRoot.get("cedula"), cedula);

        //Predicate condicion1=myBuilder.equal(miRoot.get("stock"), stock);

        myQuery.select(miRoot).where(condicion);

        TypedQuery<Estudiante> myQFinal=this.entityManager.createQuery(myQuery);

        

        

        return myQFinal.getSingleResult();
	}
}

package com.training.training.Controller;
import com.training.training.Entity.Filter;
import com.training.training.Entity.ProjectDeveloper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceFilter {
    @PersistenceContext
    private  EntityManager em;
    public  List<ProjectDeveloper> findByFilter(Filter filter) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProjectDeveloper> cq = cb.createQuery(ProjectDeveloper.class);
        Root<ProjectDeveloper> projectRoot = cq.from(ProjectDeveloper.class);
        List<Predicate> predicates = new ArrayList<>();

//        if (filter.getAvailability() != null) {
//            predicates.add(cb.equal(projectRoot.get("availability"), filter.getAvailability()));
//        }
//        if (filter.getAvailability() != null) {
//            predicates.add(cb.equal(projectRoot.get("id"), filter.getId()));
//        }

//        if (filter.getCategoryId() != null) {
//            predicates.add(cb.equal(projectRoot.get("category"), filter.getCategoryId()));
//        }
        if (filter.getDeveloperId() != null) {
            predicates.add(cb.equal(projectRoot.get("developer"), filter.getDeveloperId()));
        }
//        if (filter.getWilaya() != null) {
//            predicates.add(cb.equal(projectRoot.get("wilaya"), filter.getWilaya()));
//        }
//        if (filter.getCategoryId() != null && filter.getWilaya() != null ) {
//            predicates.add(cb.equal(projectRoot.get("category"), filter.getCategoryId()));
//            predicates.add(cb.equal(projectRoot.get("wilaya"), filter.getWilaya()));
//
//
//        }
//
//        if (filter.getTitle() != null  ) {
//            predicates.add(cb.like(projectRoot.get("title"), "%" + filter.getTitle() + "%"));
//        }



        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }
}

package beans;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
@Named
@Transactional
public class DBManager {
    private List<Result> results;
    @PersistenceContext(unitName = "db")
    private EntityManager em;

    public DBManager(){
        results = new ArrayList<>();
    }
    @PostConstruct
    public void init(){
        results.addAll(em.createQuery("SELECT a FROM results a", Result.class).getResultList());
    }
    public List<Result> getResults() {
        return results;
    }
    synchronized public void addResult(Result res){
        results.add(res);
        em.persist(res);
    }
}

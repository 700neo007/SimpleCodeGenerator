package maven.code.generator;

import javax.persistence.EntityManager;

public class AbstractDao<T> implements Dao<T> {
    private final EntityManager em;
    private final Class<T> type;

    protected AbstractDao(EntityManager em, Class<T> type) {
        this.em = em;
        this.type = type;
    }

    public T load(long id) {
        return (T) em.find(type, id);
    }

    public void save(T object) {
        em.persist(object);
    }

    public void update(T object) {
        em.refresh(object);
    }
}

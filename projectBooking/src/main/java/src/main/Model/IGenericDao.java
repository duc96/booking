package src.main.Model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

public interface IGenericDao<T extends Serializable> {
	T findOne(final long id);

	Criteria find();

	T create(final T entity);

	T update(final T entity);

	void delete(final T entity);

	void deleteById(final long entityId);
}

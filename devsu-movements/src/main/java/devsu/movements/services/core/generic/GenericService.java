package devsu.movements.services.core.generic;

import devsu.movements.services.exceptions.ServiceException;

public interface GenericService<T, V, W, X> {
    V findById(W id)throws ServiceException;

    Long save(T t) throws ServiceException;
    //Long update(U u) throws ServiceException;
    Boolean delete(X id)throws ServiceException;
}

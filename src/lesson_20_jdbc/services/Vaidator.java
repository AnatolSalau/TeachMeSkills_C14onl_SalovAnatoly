package lesson_20_jdbc.services;

import lesson_20_jdbc.entity.TypeValid;

import java.util.concurrent.CancellationException;

public interface Vaidator<T> {
    void validate(T entity, TypeValid typeValid) throws CancellationException;
}

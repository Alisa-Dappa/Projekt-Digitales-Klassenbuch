package com.example.mavenKlassenbuch.Main.Model;

import com.example.mavenKlassenbuch.Main.Model.Thema;
import com.example.mavenKlassenbuch.Main.Model.ThemaRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class ThemaRepositoryImpl implements ThemaRepository {
    @Override
    public List<Thema> findByModule_Id(Long module_id) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Thema> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Thema> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Thema> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Thema getOne(Long aLong) {
        return null;
    }

    @Override
    public Thema getById(Long aLong) {
        return null;
    }

    @Override
    public Thema getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Thema> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Thema> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Thema> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Thema> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Thema> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Thema> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Thema, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Thema> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Thema> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Thema> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Thema> findAll() {
        return null;
    }

    @Override
    public List<Thema> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Thema entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Thema> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Thema> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Thema> findAll(Pageable pageable) {
        return null;
    }
}

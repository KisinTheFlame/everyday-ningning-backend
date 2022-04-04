package tech.kisin.everydayningning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kisin.everydayningning.dataobject.Photo;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    @Override
    long count();

    @Override
    List<Photo> findAll();
}

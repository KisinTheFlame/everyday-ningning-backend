package tech.kisin.everydayningning.dao;

import org.apache.ibatis.annotations.Mapper;
import tech.kisin.everydayningning.po.PhotoPO;

import java.util.List;

@Mapper
public interface PhotoRepository {
    int count();
    List<PhotoPO> getAll();
    PhotoPO findByIndex(long index);
    void countUpFrequency(long id);
}

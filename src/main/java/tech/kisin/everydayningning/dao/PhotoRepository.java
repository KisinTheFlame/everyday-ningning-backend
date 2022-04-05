package tech.kisin.everydayningning.dao;

import org.apache.ibatis.annotations.Mapper;
import tech.kisin.everydayningning.po.PhotoPO;

@Mapper
public interface PhotoRepository {
    int count();

    PhotoPO findByIndex(long index);
    void countUpFrequency(long id);
}

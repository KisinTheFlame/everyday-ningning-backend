package tech.kisin.everydayningning.dao;

import org.apache.ibatis.annotations.Mapper;
import tech.kisin.everydayningning.po.PhotoPO;

import java.util.List;

@Mapper
public interface PhotoRepository {
    long count();
    PhotoPO findByIndex(long index);
}

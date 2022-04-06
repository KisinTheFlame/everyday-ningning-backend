package tech.kisin.everydayningning.dao;

import org.apache.ibatis.annotations.Mapper;
import tech.kisin.everydayningning.po.MusicPO;

import java.util.List;

@Mapper
public interface MusicRepository {
    List<String> getAllDescription();

    List<MusicPO> getByKeywordInexactly(String keyword);
}

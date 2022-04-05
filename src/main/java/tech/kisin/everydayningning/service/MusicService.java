package tech.kisin.everydayningning.service;

import tech.kisin.everydayningning.entity.Music;

import java.util.List;

public interface MusicService {
    List<String> getMusicList();
    List<Music> getMusicByKeyword(String keyword);
    void countUpFrequency(long id);
}

package tech.kisin.everydayningning.service.impl;

import org.springframework.stereotype.Service;
import tech.kisin.everydayningning.dao.MusicRepository;
import tech.kisin.everydayningning.entity.Music;
import tech.kisin.everydayningning.service.MusicService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MusicServiceImpl implements MusicService {

    private final MusicRepository musicRepository;

    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public List<String> getMusicList() {
        return musicRepository.getAllFilename();
    }

    @Override
    public List<Music> getMusicByKeyword(String keyword) {
        return musicRepository
                .getByKeywordInexactly(keyword)
                .stream()
                .map(musicPO -> new Music(musicPO.getFilename(), musicPO.getFrequency()))
                .collect(Collectors.toList());
    }

    @Override
    public void countUpFrequency(long id) {
        musicRepository.countUpFrequency(id);
    }
}

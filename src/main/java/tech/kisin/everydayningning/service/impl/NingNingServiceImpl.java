package tech.kisin.everydayningning.service.impl;

import org.springframework.stereotype.Service;
import tech.kisin.everydayningning.dto.MusicDTO;
import tech.kisin.everydayningning.dto.PhotoDTO;
import tech.kisin.everydayningning.entity.Photo;
import tech.kisin.everydayningning.service.MusicService;
import tech.kisin.everydayningning.service.NingNingService;
import tech.kisin.everydayningning.service.PhotoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NingNingServiceImpl implements NingNingService {

    private final PhotoService photoService;
    private final MusicService musicService;

    public NingNingServiceImpl(PhotoService photoService, MusicService musicService) {
        this.photoService = photoService;
        this.musicService = musicService;
    }

    @Override
    public PhotoDTO getRandomPhoto() {
        Photo photo = photoService.getRandomPhoto();
        return new PhotoDTO(photo.getFilename(), photo.getDescription(), photo.getFrequency());
    }

    @Override
    public List<PhotoDTO> getPhotoList() {
        return photoService
                .getPhotoList()
                .stream()
                .map(photo -> new PhotoDTO(photo.getFilename(), photo.getDescription(), photo.getFrequency()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getMusicList() {
        return musicService.getMusicList();
    }

    @Override
    public List<MusicDTO> getMusicListWithKeyword(String keyword) {
        return musicService
                .getMusicByKeyword(keyword)
                .stream()
                .map(music -> new MusicDTO(music.getFilename(), music.getDescription()))
                .collect(Collectors.toList());
    }
}

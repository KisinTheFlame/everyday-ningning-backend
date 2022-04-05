package tech.kisin.everydayningning.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.kisin.everydayningning.dto.MusicDTO;
import tech.kisin.everydayningning.dto.PhotoDTO;
import tech.kisin.everydayningning.service.NingNingService;

import java.util.List;

@RestController
public class NingNingController {
    private final NingNingService service;

    public NingNingController(NingNingService service) {
        this.service = service;
    }

    @PostMapping(value = "/get-random-photo")
    public PhotoDTO getRandomPhoto() {
        return service.getRandomPhoto();
    }

    @PostMapping(value = "/get-music-list")
    public List<String> getMusicList() {
        return service.getMusicFilenameList();
    }

    @PostMapping(value = "/get-music-list-with-keyword")
    public List<MusicDTO> getMusicListWithKeyword(@RequestBody String keyword) {
        return service.getMusicListWithKeyword(keyword);
    }
}

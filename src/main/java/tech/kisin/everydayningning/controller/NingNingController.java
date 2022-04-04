package tech.kisin.everydayningning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.kisin.everydayningning.dto.PhotoDTO;
import tech.kisin.everydayningning.service.NingNingService;

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
}

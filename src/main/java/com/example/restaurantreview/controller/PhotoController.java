package com.example.restaurantreview.controller;

import com.example.restaurantreview.domain.Photo;
import com.example.restaurantreview.service.PhotoService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/photos")
public class PhotoController {
    private final PhotoService service;

    public PhotoController(PhotoService service) {
        this.service = service;
    }

    @PostMapping
    public Photo uploadPhoto(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "caption", required = false) String caption
    ) throws IOException {
        return service.upload(file, caption);
    }

    @GetMapping
    public Map<String, Object> listPhotos(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Photo> photos = service.list(page, size);
        Map<String, Object> response = new HashMap<>();
        response.put("currentPage", photos.getNumber() + 1);
        response.put("pageSize", photos.getSize());
        response.put("totalElements", photos.getTotalElements());
        response.put("totalPages", photos.getTotalPages());
        response.put("photos", photos.getContent());
        return response;
    }
}
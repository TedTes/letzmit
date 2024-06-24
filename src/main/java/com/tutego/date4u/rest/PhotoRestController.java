package com.tutego.date4u.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.tutego.date4u.core.photo.PhotoService;

@RestController
public class PhotoRestController {
    private final PhotoService photos;

    public PhotoRestController(PhotoService photos) {
        this.photos = photos;
    }

    @GetMapping(path = "/api/photos/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> photo(@PathVariable("name") String imagename) {
        // String imagename = "images";
        // return photos.download(imagename).orElseThrow();
        return ResponseEntity.of(photos.download(imagename));
    }
}
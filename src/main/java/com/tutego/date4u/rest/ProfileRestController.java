package com.tutego.date4u.rest;

import org.springframework.web.bind.annotation.RestController;

import com.tutego.date4u.core.photo.Photo;
import com.tutego.date4u.core.photo.PhotoService;
import com.tutego.date4u.interfaces.ProfileRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
import org.springframework.http.MediaType;
import com.tutego.date4u.core.photo.profile.Profile;

@RestController
@RequestMapping("/api/profiles")
public class ProfileRestController {
    final ProfileRepository profiles;
    final PhotoService photos;

    public ProfileRestController(ProfileRepository profiles,
            PhotoService photos) {
        this.profiles = profiles;
        this.photos = photos;
    }

    @GetMapping(path = "{id}/photos/{index}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> get(@PathVariable long id, @PathVariable int index) {
        Optional<Profile> maybeProfile = profiles.findById(id);

        if (maybeProfile.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Profile profile = maybeProfile.get();

        if (index >= 0 && index < profile.getPhotos().size()) {
            try {
                Photo photo = profile.getPhotos().get(index);

                Optional<byte[]> download = photos.download(photo);
                return ResponseEntity.ok(download.get());
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

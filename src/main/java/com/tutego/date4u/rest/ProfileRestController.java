package com.tutego.date4u.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tutego.date4u.core.photo.Photo;
import com.tutego.date4u.core.photo.PhotoService;
import com.tutego.date4u.interfaces.ProfileRepository;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import org.springframework.http.MediaType;
import com.tutego.date4u.core.photo.profile.Profile;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileRestController {
    final ProfileRepository profiles;
    final PhotoService photos;
    private final ProfileMapper profileMapper = new ProfileMapper();

    public ProfileRestController(ProfileRepository profiles,
            PhotoService photos) {
        this.profiles = profiles;
        this.photos = photos;
    }

    @GetMapping
    public List<ProfileDto> profiles() {
        return profiles.findAll().stream()
                .map(profileMapper::convert).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable long id) {
        Optional<ProfileDto> maybeProfileDto = profiles.findById(id).map(profileMapper::convert);
        return ResponseEntity.of(maybeProfileDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        if (!profiles.existsById(id))
            return new ResponseEntity<String>("NOT_FOUND", null, 404);
        profiles.deleteById(id);
        return new ResponseEntity<String>("OK", null, 200);
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

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProfileDto dto, ServletUriComponentsBuilder uriBuilder) {
        if (dto.id() != null)
            return ResponseEntity.badRequest()
                    .body("ID of profile must be null but was '" + dto.id() + "'");

        Profile newProfile = new Profile(dto.nickname(), dto.birthdate(), dto.manelength(), dto.gender(),
                dto.attractedToGender(), dto.description(), dto.lastseen());
        newProfile = profiles.save(newProfile);

        URI uri = uriBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newProfile.getId())
                .toUri();
        return ResponseEntity
                .created(uri)
                .body(profileMapper.convert(newProfile));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @Valid @RequestBody ProfileDto dto) {
        if (dto.id() != null && dto.id() != Long.parseLong(id))
            return new ResponseEntity<String>(
                    "Unable to update profile, because ID of path variable "
                            + "does not match ID of profile"
                            + "CONFLICT",
                    null, 409);
        // dto.id() could be null but we use the id from the parameter
        var maybeProfile = profiles.findById(Long.parseLong(id));
        if (maybeProfile.isEmpty())
            return new ResponseEntity<String>(
                    "Unable to update profile, because no profile with '"
                            + id + "' found" +
                            "NOT_FOUND",
                    null, 404);
        var profile = maybeProfile.get();
        profile.setNickname(dto.nickname());
        profile.setBirthdate(dto.birthdate());
        profile.setManelength(dto.manelength());
        profile.setGender(dto.gender());
        profile.setAttractedToGender(dto.attractedToGender());
        profile.setDescription(dto.description());
        profile.setLastseen(dto.lastseen());
        profile = profiles.save(profile);
        return ResponseEntity.ok(profileMapper.convert(profile));
    }
}

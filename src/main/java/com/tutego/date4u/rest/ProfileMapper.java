package com.tutego.date4u.rest;

import com.tutego.date4u.core.photo.profile.Profile;

class ProfileMapper {
    ProfileDto convert(Profile p) {
        return new ProfileDto(
                p.getId(), p.getNickname(), p.getBirthdate(), p.getManelength(),
                p.getGender(), p.getAttractedToGender(), p.getDescription(),
                p.getLastseen());
    }
}

package com.tutego.date4u.core.photo;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;

@Async
public interface Thumbnail {
    Future<byte[]> thumbnail(byte[] imageBytes);

}

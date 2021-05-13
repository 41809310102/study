package com.bit.java_image_server.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Image {
    private int imageId;
    private String imageName;
    private long size;
    private String uploadTime;
    private String md5;
    private String contentType;
    private String path;
}

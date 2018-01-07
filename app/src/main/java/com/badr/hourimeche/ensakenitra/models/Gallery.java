package com.badr.hourimeche.ensakenitra.models;

import com.google.gson.annotations.SerializedName;

public class Gallery {
    @SerializedName("album_name")
    private String album_name;
    @SerializedName("album_photo")
    private String album_photo;
    @SerializedName("album_link")
    private String album_link;
    @SerializedName("album_photos_number")
    private String album_photos_number;

    public Gallery(String album_name, String album_photo, String album_link, String album_photos_number) {
        this.album_name = album_name;
        this.album_photo = album_photo;
        this.album_link = album_link;
        this.album_photos_number = album_photos_number;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getAlbum_photo() {
        return album_photo;
    }

    public void setAlbum_photo(String album_photo) {
        this.album_photo = album_photo;
    }

    public String getAlbum_link() {
        return album_link;
    }

    public void setAlbum_link(String album_link) {
        this.album_link = album_link;
    }

    public String getAlbum_photos_number() {
        return album_photos_number;
    }

    public void setAlbum_photos_number(String album_photos_number) {
        this.album_photos_number = album_photos_number;
    }
}


package com.krishna.stream;

public class Song {
    public Song(Long id, String singer, String title, Integer duration, AudioType audioType) {
        this.id = id;
        this.singer = singer;
        this.title = title;
        this.duration = duration;
        this.audioType = audioType;
    }

    private Long id;
    private String singer;

    public Long getId() {
        return id;
    }

    public String getSinger() {
        return singer;
    }

    public String getTitle() {
        return title;
    }

    public Integer getDuration() {
        return duration;
    }

    public AudioType getAudioType() {
        return audioType;
    }

    private String title;
    private Integer duration;
    private AudioType audioType;

}

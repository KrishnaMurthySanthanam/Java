package com.krishna.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SongSet {
    public static void main(String[] args) throws IOException {

        List<Song> song = new ArrayList<>();
        Stream<String> fileStream = Files.lines(Path.of("E:\\Projects\\Spring5\\java11\\src\\com\\krishna\\stream\\songs.csv"));

        song = fileStream.map(
                i-> {
                    //public Song(Long id, String singer, String title, Integer duration, AudioType audioType)
                    //public Song(Long id, String singer, String title, Integer duration, AudioType audioType)
                    String[] s = i.split(";");
                    Song song1 = new Song(Long.parseLong(s[0]),
                                    s[1], s[2], Integer.parseInt(s[3]), AudioType.valueOf(s[4]));
                    //song.add(song1);
                    return song1;

                }).collect(Collectors.toList());

        //Using forEach
        Stream<String> fileStream1 = Files.lines(Path.of("E:\\Projects\\Spring5\\java11\\src\\com\\krishna\\stream\\songs.csv"));

        List<Song> finalSong = new ArrayList<>();
        fileStream1.forEach(
                i-> {
                    //public Song(Long id, String singer, String title, Integer duration, AudioType audioType)
                    //public Song(Long id, String singer, String title, Integer duration, AudioType audioType)
                    String[] s = i.split(";");
                    Song song1 = new Song(Long.parseLong(s[0]),
                            s[1], s[2], Integer.parseInt(s[3]), AudioType.valueOf(s[4]));
                    finalSong.add(song1);
                });

        Long count = song.stream().filter( p-> p.getDuration() > 300).count();
        System.out.println("More than 300 counts : "+count);

        Long countForEach = finalSong.stream().filter( p-> p.getDuration() > 300).count();
        System.out.println("More than 300 countsForEach : "+countForEach);

    }
}

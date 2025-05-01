package com.example.demo.artist.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import com.example.demo.album.model.Album;

@Entity
@Table(name = "artists")
@Data
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "profile_pic", columnDefinition = "TEXT")
    private String profilePic;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<Album> albums;
}

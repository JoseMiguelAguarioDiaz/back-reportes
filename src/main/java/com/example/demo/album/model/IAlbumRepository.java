package com.example.demo.album.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlbumRepository extends JpaRepository<Album, Long> {
}

package com.santanu.TastyTracks.repository;

import com.santanu.TastyTracks.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}

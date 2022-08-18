package com.capstone.MyMovies.repositories;

import com.capstone.MyMovies.models.Reply;
import com.capstone.MyMovies.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {


}

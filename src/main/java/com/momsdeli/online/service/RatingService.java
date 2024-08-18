package com.momsdeli.online.service;

import com.momsdeli.online.mapper.RatingMapper;
import com.momsdeli.online.model.Rating;
import com.momsdeli.online.repository.RatingRepository;
import com.momsdeli.online.request.RatingRequest;
import com.momsdeli.online.response.RatingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private RatingMapper ratingMapper;

    public RatingResponse addRating(RatingRequest request) {
        Rating rating = ratingMapper.requestToRating(request);
        rating = ratingRepository.save(rating);
        return (RatingResponse) ratingMapper.ratingToResponse(rating);
    }

    public RatingResponse updateRating(Long id, RatingRequest request) {
        Rating rating = ratingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rating not found"));
        ratingMapper.updateRatingFromDTO(request, rating);
        rating = ratingRepository.save(rating);
        return (RatingResponse) ratingMapper.ratingToResponse(rating);
    }

    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }

    public RatingResponse getRatingById(Long id) {
        Rating rating = ratingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rating not found"));
        return (RatingResponse) ratingMapper.ratingToResponse(rating);
    }

    public List<Object> getAllRatings() {
        return ratingRepository.findAll().stream()
                .map(ratingMapper::ratingToResponse)
                .collect(Collectors.toList());
    }
}

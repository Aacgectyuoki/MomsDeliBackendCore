package com.momsdeli.online.service;

import com.momsdeli.online.dto.ReviewDTO;
import com.momsdeli.online.mapper.ReviewMapper;
import com.momsdeli.online.model.Review;
import com.momsdeli.online.repository.ReviewRepository;
import com.momsdeli.online.request.ReviewRequest;
import com.momsdeli.online.response.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewMapper reviewMapper;

    public ReviewResponse addReview(ReviewRequest request) {
        Review review = reviewMapper.requestToReview(request);
        review = reviewRepository.save(review);
        return reviewMapper.reviewToResponse(review);
    }

    public ReviewResponse updateReview(Long id, ReviewRequest request) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        reviewMapper.updateReviewFromDTO(request, review);
        review = reviewRepository.save(review);
        return reviewMapper.reviewToResponse(review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public ReviewResponse getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        return reviewMapper.reviewToResponse(review);
    }

    public List<ReviewResponse> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(reviewMapper::reviewToResponse)
                .collect(Collectors.toList());
    }
}

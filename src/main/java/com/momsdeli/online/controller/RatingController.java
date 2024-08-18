package com.momsdeli.online.controller;

import com.momsdeli.online.request.RatingRequest;
import com.momsdeli.online.response.RatingResponse;
import com.momsdeli.online.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public RatingResponse addRating(@RequestBody RatingRequest request) {
        return ratingService.addRating(request);
    }

    @PutMapping("/{id}")
    public RatingResponse updateRating(@PathVariable Long id, @RequestBody RatingRequest request) {
        return ratingService.updateRating(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
    }

    @GetMapping("/{id}")
    public RatingResponse getRating(@PathVariable Long id) {
        return ratingService.getRatingById(id);
    }

    @GetMapping
    public List<Object> getAllRatings() {
        return ratingService.getAllRatings();
    }

//    @GetMapping
//    public List<RatingResponse> getAllRatings() {
//        return ratingService.getAllRatings();
//    }
}

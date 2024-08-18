package com.momsdeli.online.service;

import com.momsdeli.online.dto.PaymentDTO;
import com.momsdeli.online.mapper.PaymentMapper;
import com.momsdeli.online.model.Payment;
import com.momsdeli.online.repository.PaymentRepository;
import com.momsdeli.online.request.PaymentRequest;
import com.momsdeli.online.response.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    public PaymentResponse addPayment(PaymentRequest request) {
        Payment payment = paymentMapper.requestToPayment(request);
        payment = paymentRepository.save(payment);
        return paymentMapper.paymentToResponse(payment);
    }

    public PaymentResponse updatePayment(Long id, PaymentRequest request) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        paymentMapper.updatePaymentFromDTO(request, payment);
        payment = paymentRepository.save(payment);
        return paymentMapper.paymentToResponse(payment);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    public PaymentResponse getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        return paymentMapper.paymentToResponse(payment);
    }

    public List<PaymentResponse> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(paymentMapper::paymentToResponse)
                .collect(Collectors.toList());
    }
}

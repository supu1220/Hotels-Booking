package com.bookingservice.client;

import com.bookingservice.dto.ProductRequest;
import com.bookingservice.dto.StripeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "PAYMENTSERVICE")
public interface PaymentClient {

    @PostMapping("/product/v1/checkout")
    public StripeResponse checkoutProducts(@RequestBody ProductRequest productRequest) ;

}

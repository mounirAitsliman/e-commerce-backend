package com.mounir.ecomerce.CustumerController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/custumer")
@RequiredArgsConstructor
public class CustumerController {

    private final CustumerService custumerService;

    @PostMapping
    public ResponseEntity<String> createCustumer(
            @RequestBody @Valid CustumerRequest request
    ){
        return ResponseEntity.ok(custumerService.createCustumer(request));
    }
    @PutMapping
    public ResponseEntity<Void> updateCustumer(
            @RequestBody @Valid CustumerRequest request
    ){
        custumerService.updateCustumer(request);
        return ResponseEntity.accepted().build();
    }
    @GetMapping
    public ResponseEntity<List<CustumerResponse>> findAll(){
        return ResponseEntity.ok(custumerService.findAllCustumers());
    }
}

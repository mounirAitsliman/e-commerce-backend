package com.mounir.ecomerce.Cusumer;

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
    @GetMapping("/exists/{custumer-id}")
    public ResponseEntity<Boolean> existsById(
            @PathVariable("custumer-id") String custumerId
    ){
        return ResponseEntity.ok(custumerService.existsById(custumerId));
    }
    @GetMapping("/{custumer-id}")
    public ResponseEntity<CustumerResponse> findById(
            @PathVariable("custumer-id") String custumerId
    ){
        return ResponseEntity.ok(custumerService.findById(custumerId));
    }
    @DeleteMapping("/{custumer_id}")
    public ResponseEntity<Void> delete(
            @PathVariable("custumer-id") String custumerId
    ){
        custumerService.deleteCustumerById(custumerId);
        return ResponseEntity.accepted().build();
    }
}

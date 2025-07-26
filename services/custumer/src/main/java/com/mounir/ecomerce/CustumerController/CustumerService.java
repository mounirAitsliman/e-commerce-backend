package com.mounir.ecomerce.CustumerController;

import ch.qos.logback.core.util.StringUtil;
import com.mounir.ecomerce.Cusumer.Custumer;
import com.mounir.ecomerce.Exception.CustumerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustumerService {
    private final CustumerRepository custumerRepository;
    private final CustumerMapper custumerMapper;

    public String createCustumer(CustumerRequest request) {
        var custumer = custumerRepository.save(custumerMapper.toCustumer(request));
        return custumer.getId();
    }
    public void updateCustumer(CustumerRequest request) {
        var custumer = custumerRepository.findById(request.id()).orElseThrow(() -> new CustumerNotFoundException(String.format(
                "Cannot update custumer:: No custumer found with the provided ID:: %s",request.id())));
        mergerCustumer(custumer,request);
        custumerRepository.save(custumer);
    }

    private void mergerCustumer(Custumer custumer, CustumerRequest request) {
        if (StringUtils.isNotBlank(request.firstname())){
            custumer.setFirstname(request.firstname());
        }
        if (StringUtils.isNotBlank(request.lastname())){
            custumer.setFirstname(request.lastname());
        }
        if (StringUtils.isNotBlank(request.email())){
            custumer.setFirstname(request.email());
        }
        if (request.adress() != null){
            custumer.setAdress(request.adress());
        }
    }

    public List<CustumerResponse> findAllCustumers() {
    }
}

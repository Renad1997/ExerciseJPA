package com.example.exercisejpa.Service;

import com.example.exercisejpa.Model.Merchant;
import com.example.exercisejpa.Model.MerchantStock;
import com.example.exercisejpa.Repository.MerchantStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantStockService {

    private final MerchantStockRepository merchantStockRepository;

    public List<MerchantStock> getMerchantStock() {
        return merchantStockRepository.findAll();
    }

    public void addMerchantStock(MerchantStock merchantStock) {
        merchantStockRepository.save(merchantStock);
    }

    public boolean updateMerchantStock(Integer id , MerchantStock merchantStock) {
        MerchantStock ms = merchantStockRepository.getById(id);
        if(ms == null) {
            return false;
        }
        ms.setMerchantId(merchantStock.getMerchantId());
        ms.setStock(merchantStock.getStock());
        merchantStockRepository.save(ms);
        return true;
    }
    public boolean deleteMerchantStock(Integer id) {
        MerchantStock ms  =merchantStockRepository.getById(id);
        if(ms == null) {
            return false;
        }
        merchantStockRepository.delete(ms);
        return true;
    }


}

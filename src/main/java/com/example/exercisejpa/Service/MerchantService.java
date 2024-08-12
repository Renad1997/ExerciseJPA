package com.example.exercisejpa.Service;

import com.example.exercisejpa.Model.Category;
import com.example.exercisejpa.Model.Merchant;
import com.example.exercisejpa.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepository merchantRepository;

    public List<Merchant> getMerchant() {
        return merchantRepository.findAll();
    }

    public void addMerchant(Merchant merchant) {
        merchantRepository.save(merchant);
    }

    public boolean updateMerchant(Integer id ,Merchant merchant) {
        Merchant m = merchantRepository.getById(id);
        if(m == null) {
            return false;
        }
        m.setName(merchant.getName());
        m.setRate(merchant.getRate());
        merchantRepository.save(m);
        return true;
    }
    public boolean deleteMerchant(Integer id) {
        Merchant m = merchantRepository.getById(id);
        if(m == null) {
            return false;
        }
        merchantRepository.delete(m);
        return true;
    }
}
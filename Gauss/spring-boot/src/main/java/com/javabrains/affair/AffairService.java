package com.javabrains.affair;

import com.javabrains.affair.AffairRepository;
import entity.Country;
import entity.CurrentAffair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neerbans on 13/8/17.
 */

@Service
public class AffairService {

    @Autowired
    private AffairRepository affairRepository;

    public List<CurrentAffair> getCurrentAffairs (Long countryId) {
        List<CurrentAffair> currentAffairs = new ArrayList<>();
        affairRepository.findByCountryCountryId(countryId).forEach(currentAffairs::add);
        return currentAffairs;
    }

    public CurrentAffair getCurrentAffair (Long id) {
        return affairRepository.findOne(id);
    }

    public void addAfair(CurrentAffair affair) {
        affairRepository.save(affair);
    }

    public void deleteCurrentAffair(Long id) {
        affairRepository.delete(id);
    }

    public void updateCurrentAffair(CurrentAffair affair) {
        affairRepository.save(affair);
    }
}

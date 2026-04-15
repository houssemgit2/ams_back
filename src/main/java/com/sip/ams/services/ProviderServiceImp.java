package com.sip.ams.services;

import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderServiceImp implements ProviderService {

    @Autowired
    ProviderRepository providerRepository;

    @Override
    public List<Provider> getAllProvider() {
        return (List<Provider>) providerRepository.findAll();
    }

    @Override
    public Provider saveProvider(Provider p) {
        return providerRepository.save(p);
    }

    @Override
    public Optional<Provider> getProviderById(int id) {
        return providerRepository.findById(id);
    }

    @Override
    public void deleteProvider(int id) {
        providerRepository.deleteById(id);
    }

    @Override
    public Provider updateProvider(Provider p) {
        return providerRepository.save(p);
    }
}

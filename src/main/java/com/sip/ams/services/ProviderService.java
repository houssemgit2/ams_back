package com.sip.ams.services;

import com.sip.ams.entities.Provider;

import java.util.List;
import java.util.Optional;

public interface ProviderService {
    public List<Provider> getAllProvider();
    public Provider saveProvider(Provider provider);
    public Optional<Provider> getProviderById(Long id);
    public void deleteProvider(Long id);
    public Provider updateProvider(Provider provider);
}

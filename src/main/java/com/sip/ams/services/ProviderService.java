package com.sip.ams.services;

import com.sip.ams.entities.Provider;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProviderService {
    public List<Provider> getAllProvider();
    public Provider saveProvider(MultipartFile file, String name, String email, String address);
    public Optional<Provider> getProviderById(int id);
    public void deleteProvider(int id);
    public Provider updateProvider(Provider provider);

    Provider saveProvider(Provider newProvider);
}

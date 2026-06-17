package com.pluralsight.springcontrollerdemo.authentication.service;

import com.pluralsight.springcontrollerdemo.authentication.ProfileRepository;
import com.pluralsight.springcontrollerdemo.authentication.models.Profile;
import org.springframework.stereotype.Service;

@Service
public class ProfileService
{
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository)
    {
        this.profileRepository = profileRepository;
    }

    public Profile create(Profile profile)
    {
        return profileRepository.save(profile);
    }
}

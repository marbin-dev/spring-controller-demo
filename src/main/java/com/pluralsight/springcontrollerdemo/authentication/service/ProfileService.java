package com.pluralsight.springcontrollerdemo.authentication;

import org.springframework.context.annotation.Profile;
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

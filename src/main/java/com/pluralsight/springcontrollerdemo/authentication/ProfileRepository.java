package com.pluralsight.springcontrollerdemo.authentication;

import com.pluralsight.springcontrollerdemo.authentication.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer>
{
}

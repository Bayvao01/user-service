package com.user.service.bruteforce.impl;

import com.user.service.bruteforce.BruteForceProtectionService;
import com.user.service.bruteforce.FailedLogin;
import com.user.service.entities.User;
import com.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DefaultBruteForceProtectionService implements BruteForceProtectionService {
    @Value("${security.failedlogin.count}")
    private int maxFailedLogins;

    @Autowired
    UserRepository userRepository;

    @Value("${brute.force.cache.max}")
    private int cacheMaxLimit;

    private final ConcurrentHashMap<String, FailedLogin> cache;

    public DefaultBruteForceProtectionService() {
        this.cache = new ConcurrentHashMap<>(cacheMaxLimit); //setting max limit for cache
    }

    @Override
    public void registerLoginFailure(String username) {

        Optional<User> userOptional = getUser(username);
        if(userOptional.isPresent()){
            User user =userOptional.get();
            if (user.isEnabled()) {
                int failedCounter = user.getFailedLoginAttempts();
                if (maxFailedLogins < failedCounter + 1) {
                    user.setEnabled(false); //disabling the account
                } else {
                    //let's update the counter
                    user.setFailedLoginAttempts(failedCounter + 1);
                }
                userRepository.save(user);
            }
        }
    }

    @Override
    public void resetBruteForceCounter(String username) {
        Optional<User> userOptional = getUser(username);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            user.setFailedLoginAttempts(0);
            user.setEnabled(true);
            userRepository.save(user);
        }
    }

    @Override
    public boolean isBruteForceAttack(String username) {

        Optional<User> userOptional = getUser(username);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getFailedLoginAttempts() >= maxFailedLogins;
        }

        return false;
    }

    private Optional<User> getUser(final String username){
        return  userRepository.findByEmail(username);
    }
}

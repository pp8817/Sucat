package com.Sucat.global.infra.email.repository;

import com.Sucat.global.infra.email.model.VerificationCode;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class VerificationCodeRepository {
    /*
    인증 코드 객체를 인메모리에 저장
     */
    private final Map<String, VerificationCode> repository = new ConcurrentHashMap<>();

    public VerificationCode save(VerificationCode verificationCode) {
        return repository.put(verificationCode.getEmail(), verificationCode);
    }

    public Optional<VerificationCode> findByEmail(String email) {
        return Optional.ofNullable(repository.get(email));
    }

    public void remove(VerificationCode verificationCode) {
        repository.remove(verificationCode.getEmail());
    }
}

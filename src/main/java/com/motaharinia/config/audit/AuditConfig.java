package com.motaharinia.config.audit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * User: https://github.com/motaharinia<br>
 * Description: <br>
 */
@Configuration
public class AuditConfig {
    @Bean
    public AuditorAware<Integer> auditorAware() {
        return new CustomAuditAware();
    }

    public class CustomAuditAware implements AuditorAware<Integer> {

        @Override
        public Optional<Integer> getCurrentAuditor() {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            if (authentication == null || !authentication.isAuthenticated()) {
//                return null;
//            }
//            return ((User) authentication.getPrincipal()).getUsername();
            return Optional.of(1);
        }
    }
}

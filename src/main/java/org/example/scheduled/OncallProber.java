package org.example.scheduled;

import io.micrometer.core.instrument.MeterRegistry;
import org.example.service.OncallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tinkoff.kora.common.Component;
import ru.tinkoff.kora.http.common.HttpResponseEntity;
import ru.tinkoff.kora.scheduling.jdk.annotation.ScheduleAtFixedRate;

import java.time.temporal.ChronoUnit;

@Component
public class OncallProber {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MeterRegistry registry;

    private final OncallService oncallService;

    public OncallProber(MeterRegistry registry,
                        OncallService oncallService) {
        this.registry = registry;
        this.oncallService = oncallService;
    }

    @ScheduleAtFixedRate(initialDelay = 0, period = 3, unit = ChronoUnit.SECONDS)
    public void getTeamsProbe() {
        try {
            HttpResponseEntity<String> response = oncallService.getTeams();
            if (response.code() < 300) {
                logger.info("SUCCESS getTeams");
                registry.counter("oncall_sla_prober_get_teams_success").increment();
            } else {
                logger.warn("FAIL getTeams");
                registry.counter("oncall_sla_prober_get_teams_fail").increment();
            }
        } catch (Exception exception) {
            logger.error("FAIL getTeams", exception);
            registry.counter("oncall_sla_prober_get_teams_fail").increment();
        }
    }

    @ScheduleAtFixedRate(initialDelay = 5, period = 3, unit = ChronoUnit.SECONDS)
    public void createUserProbe() {
        try {
            HttpResponseEntity<?> response = oncallService.createUser("create_user_probe");
            if (response.code() < 300) {
                logger.info("User created");
                registry.counter("oncall_sla_prober_create_user_success").increment();
            } else {
                logger.warn("Problems in creating user");
                registry.counter("oncall_sla_prober_create_user_fail").increment();
            }
        } catch (Exception exception) {
            logger.error("Problems in creating user", exception);
            registry.counter("oncall_sla_prober_create_user_fail").increment();
        } finally {
            try {
                oncallService.deleteUser("create_user_probe");
            } catch (Exception ignored) {
            }
        }
    }

    @ScheduleAtFixedRate(initialDelay = 10, period = 3, unit = ChronoUnit.SECONDS)
    public void deleteUserProbe() {
        try {
            oncallService.createUser("delete_user_probe");
        } catch (Exception ignored) {
        }
        try {
            HttpResponseEntity<?> response = oncallService.deleteUser("delete_user_probe");
            HttpResponseEntity<String> userResponse = oncallService.getUser("delete_user_probe");
            if (response.code() < 300 || userResponse.code() < 300) {
                logger.info("SUCCESS deleteUser");
                registry.counter("oncall_sla_prober_delete_user_success").increment();
            } else {
                logger.warn("Problems in removing user");
                registry.counter("oncall_sla_prober_delete_user_fail").increment();
            }
        } catch (Exception exception) {
            logger.error("Problems in removing user", exception);
            registry.counter("oncall_sla_prober_delete_user_fail").increment();
        }
    }
}

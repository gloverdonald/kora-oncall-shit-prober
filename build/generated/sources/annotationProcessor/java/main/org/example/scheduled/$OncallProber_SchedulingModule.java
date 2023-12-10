package org.example.scheduled;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import ru.tinkoff.kora.common.Module;
import ru.tinkoff.kora.common.annotation.Root;
import ru.tinkoff.kora.scheduling.common.telemetry.SchedulingTelemetryFactory;
import ru.tinkoff.kora.scheduling.jdk.FixedRateJob;
import ru.tinkoff.kora.scheduling.jdk.JdkSchedulingExecutor;

@Module
public interface $OncallProber_SchedulingModule {
  @Root
  default FixedRateJob $OncallProber_getTeamsProbe_Job(SchedulingTelemetryFactory telemetryFactory,
      JdkSchedulingExecutor service, OncallProber object) {
    var telemetry = telemetryFactory.get(null, OncallProber.class, "getTeamsProbe");
    var initialDelay = Duration.of(0, ChronoUnit.SECONDS);
    var period = Duration.of(3, ChronoUnit.SECONDS);
    return new FixedRateJob(telemetry, service, object::getTeamsProbe, initialDelay, period);
  }

  @Root
  default FixedRateJob $OncallProber_createUserProbe_Job(
      SchedulingTelemetryFactory telemetryFactory, JdkSchedulingExecutor service,
      OncallProber object) {
    var telemetry = telemetryFactory.get(null, OncallProber.class, "createUserProbe");
    var initialDelay = Duration.of(5, ChronoUnit.SECONDS);
    var period = Duration.of(3, ChronoUnit.SECONDS);
    return new FixedRateJob(telemetry, service, object::createUserProbe, initialDelay, period);
  }

  @Root
  default FixedRateJob $OncallProber_deleteUserProbe_Job(
      SchedulingTelemetryFactory telemetryFactory, JdkSchedulingExecutor service,
      OncallProber object) {
    var telemetry = telemetryFactory.get(null, OncallProber.class, "deleteUserProbe");
    var initialDelay = Duration.of(10, ChronoUnit.SECONDS);
    var period = Duration.of(3, ChronoUnit.SECONDS);
    return new FixedRateJob(telemetry, service, object::deleteUserProbe, initialDelay, period);
  }
}

package io.openliberty.sample.system;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Provider;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
@ApplicationScoped
public class SystemReadinessCheck implements HealthCheck {
	/*
	 * Clase que verifica que el system no este en mantenimiento al
	 * verificar una propiedad de la configuración.
	 */
	
	private static final String readinessCheck = SystemResource.class.getSimpleName()
												+ " Readiness Check";
	
	@Inject
	@ConfigProperty(name= "io_openliberty_guides_system_inMaintenance")
	Provider<String> inMaintenance;

	@Override
	public HealthCheckResponse call() {
		if (inMaintenance != null && inMaintenance.get().equalsIgnoreCase("true")) {
			return HealthCheckResponse.down(readinessCheck);
		}
		return HealthCheckResponse.up(readinessCheck);
	}
	
}

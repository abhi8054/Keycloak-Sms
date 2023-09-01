package dasniko.keycloak.authenticator.gateway;
import org.keycloak.models.RealmModel;
import java.util.Map;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
public interface SmsService {

	void send(String phoneNumber, String message, String realmName,RealmModel realm);

}

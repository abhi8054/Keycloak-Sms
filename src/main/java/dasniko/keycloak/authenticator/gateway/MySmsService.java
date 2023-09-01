package dasniko.keycloak.authenticator.gateway;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.keycloak.models.RealmModel;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
public class MySmsService implements SmsService {


	private final String senderId;
	
	MySmsService(Map<String, String> config) {
		senderId = config.get("senderId");
	}

	@Override
	public void send(String phoneNumber, String message, String realmName ,RealmModel realm) {
		// System.out.println("REALM NAME");
		// System.out.println(realm.getName());
		// System.out.println(realm.getDisplayName());
		// System.out.println(phoneNumber);
		// System.out.println(message);
	

		try {
	
			URL url = new URL("https://api.instaalerts.zone/SendSMS/sendmsg.php?uname=KOICICI&pass=p@3BaTz!&send=KILHLP&dest=91" + phoneNumber +"&msg=One%20time%20password%20for%20Sampark-"+ realm.getDisplayName() +"%20is%20"+ message + ".%20This%20OTP%20is%20valid%20for%2010%20min%20only.%20Do%20not%20share%20with%20anyone.Thanks,%20Kochar%20Infotech%20Limited.");

			System.out.println(url);
		
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");

			connection.setRequestProperty("Content-Type", "application/text");

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			System.out.println(response.toString());

			connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

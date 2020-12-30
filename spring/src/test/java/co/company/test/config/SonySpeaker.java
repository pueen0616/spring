package co.company.test.config;

import org.springframework.stereotype.Component;

@Component //빈등록함
public class SonySpeaker implements Speaker{

	@Override
	public void volumeup() {
		System.out.println("볼륨업");
	}

}

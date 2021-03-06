package com.kaev.IEscheduler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("spring.mail")
public class EmailService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private JavaMailSender javaMailSender;
	private String username;
	private String activationURL="http://localhost:9000/activation/";
	private String loginURL="http://localhost:9000/login";
	private String admin = "attila.kiszelik@gmail.com";
	
	@Autowired
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendRegMessage(String name, String email, String activation_key) {
		SimpleMailMessage message = null;
		
		try {
			message = new SimpleMailMessage();
			message.setFrom(username);
			message.setTo(email);
			message.setSubject("Sikeres regisztráció");
			message.setText("Kedves " + name + "!\n"
							+ "\n"
							+ "Köszönjük, hogy regisztráltál!\n"
							+ "\n"
							+ "Regisztrációd aktiváláshoz kattints az alábbi linkre:\n"
							+ activationURL + activation_key + "\n"
							+ "\n"
							+ "Üdvözlettel,\n"
							+ "az Inter-Épfu csapata");
			javaMailSender.send(message);
		} catch (Exception e) {
			log.error("Hiba e-mail küldéskor: " + e);
		}
		
	}
	
	public void sendActMessage(String name, String email) {
		SimpleMailMessage message = null;
		
		try {
			message = new SimpleMailMessage();
			message.setFrom(username);
			message.setTo(email);
			message.setSubject("Sikeres aktiválás");
			message.setText("Kedves " + name + "!\n"
							+ "\n"
							+ "Regisztrációd aktiválása megtörtént!\n"
							+ "\n"
							+ "Tájékoztatunk, hogy az időpont foglaló felületet csak az Inter-Épfu Kft. adminisztrátorának jóváhagyása után tudod majd használni.\n"
							+ "\n"
							+ "A jóváhagyás megtörténtéről egy újabb e-mailben fogunk tájékoztatni, addig is szíves türelmedet kérjük.\n"
							+ "\n"
							+ "Üdvözlettel,\n"
							+ "az Inter-Épfu csapata");
			javaMailSender.send(message);
		} catch (Exception e) {
			log.error("Hiba e-mail küldéskor: " + e);
		}
/*		
		try {
			message = new SimpleMailMessage();
			message.setFrom(username);
			message.setTo(admin);
			message.setSubject("Új ügyfél regisztráció");
			message.setText("Kedves Admin!\n"
							+ "\n"
							+ "Új jóváhagyásra váró ügyfél regisztráció történt az alábbi e-mail címmel:\n"
							+ "\n"
							+ email + "\n"
							+ "\n"
							+ "Az időpont foglaló rendszer Regisztrációk jóváhagyása menüpontjában engedélyezheted a felület használatát az ügyfél részére.");
			javaMailSender.send(message);
		} catch (Exception e) {
			log.error("Hiba e-mail küldéskor: " + e);
		}
*/		
	}
	
	public void sendUnlMessage(String name, String email) {
		SimpleMailMessage message = null;
		
		try {
			message = new SimpleMailMessage();
			message.setFrom(username);
			message.setTo(email);
			message.setSubject("Felhasználói fiók jóváhagyása");
			message.setText("Kedves " + name + "!\n"
							+ "\n"
							+ "Regisztrációd jóváhagyásra került az Inter-Épfu Kft. által, az alábbi linkre kattintva most már használhatod az időpont foglaló rendszert!\n"
							+ "\n"
							+ loginURL + "\n" 
							+ "\n"
							+ "Üdvözlettel,\n"
							+ "az Inter-Épfu csapata");
			javaMailSender.send(message);
		} catch (Exception e) {
			log.error("Hiba e-mail küldéskor: " + e);
		}
		
	}

	public void sendDelMessage(String name, String email) {
		SimpleMailMessage message = null;
		
		try {
			message = new SimpleMailMessage();
			message.setFrom(username);
			message.setTo(email);
			message.setSubject("Felhasználói fiók visszautasítása");
			message.setText("Kedves " + name + "!\n"
							+ "\n"
							+ "Regisztrációd visszautasításra került az Inter-Épfu Kft. által. Ha az ügyfelünk vagy, kérlek vedd fel velünk a kapcsolatot!\n"
							+ "\n"
							+ "Üdvözlettel,\n"
							+ "az Inter-Épfu csapata");
			javaMailSender.send(message);
		} catch (Exception e) {
			log.error("Hiba e-mail küldéskor: " + e);
		}
		
	}
	
}
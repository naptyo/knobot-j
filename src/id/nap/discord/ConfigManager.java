package id.nap.discord;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

import id.nap.discord.model.Config;

public class ConfigManager {
	private static ConfigManager instance;
	private final Path propFile = new File(".").toPath().resolve("config.properties");
	private Config config;
	
	public static ConfigManager getInstance() {
		if (instance == null) {
			instance = new ConfigManager();
		}
		
		return instance;
	}

	public Config getConfig() {
		return config;
	}
	
	private ConfigManager() {
		if (!propFile.toFile().exists()) {
			System.out.println("Unable to find the config.properties file.");
			System.exit(Knobot.NO_CONFIG_FOUND);
		}
		
		this.config = loadConfiguration();
	}
	
	private Config loadConfiguration() {
		InputStream input = null;
		Properties prop = new Properties();
		
		try {
			input = new FileInputStream(propFile.toFile());
			prop.load(input);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(Knobot.NO_CONFIG_FOUND);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(Knobot.IO_ERROR);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.exit(Knobot.BAD_UNICODE_ESCAPE);
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(Knobot.IO_ERROR);
			}
		}
		
		if (!prop.isEmpty()) {
			
		}
		
		return new Config(prop.getProperty("discord_token"), prop.getProperty("calendar_key"));
	}
}

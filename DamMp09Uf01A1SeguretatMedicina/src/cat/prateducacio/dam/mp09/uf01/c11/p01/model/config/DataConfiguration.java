package cat.prateducacio.dam.mp09.uf01.c11.p01.model.config;

import java.io.FileReader;
import java.util.Properties;

import cat.prateducacio.dam.mp09.uf01.c11.p01.model.security.EnumAlgoritmeEncriptacio;

public class DataConfiguration {

	private final String KEY_ALGORITME_SEGURETAT = "algoritme_seguretat";

	private DataConfiguration() throws Exception {
		properties = new Properties();
		try {
			properties.load(new FileReader("configuracions/data.properties"));
		} catch (Exception e) {
			throw e;
		}
	}

	private static DataConfiguration instance;

	public static DataConfiguration getInstance() throws Exception {
		if (instance == null) {
			instance = new DataConfiguration();
		}
		return instance;
	}

	private Properties properties;

	public EnumAlgoritmeEncriptacio getAlgoritmeSeguretat() {
		EnumAlgoritmeEncriptacio result = EnumAlgoritmeEncriptacio.UNKNOWN;

		String algoritme = properties.getProperty(KEY_ALGORITME_SEGURETAT);

		if (algoritme.equals("aes")) {
			result = EnumAlgoritmeEncriptacio.AES;
		} else if (algoritme.equals("md5")) {
			result = EnumAlgoritmeEncriptacio.MD5;
		} else if (algoritme.equals("sha256")) {
			result = EnumAlgoritmeEncriptacio.SHA256;
		}

		return result;
	}
}

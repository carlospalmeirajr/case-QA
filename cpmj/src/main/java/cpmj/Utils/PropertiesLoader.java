package cpmj.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

	private Properties props;

	protected PropertiesLoader() {
		props = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("./dados.properties");
			props.load(file);
			file.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected String getValor(String chave) {
		return (String) props.getProperty(chave);
	}
}

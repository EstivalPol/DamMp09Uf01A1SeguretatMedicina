package cat.prateducacio.dam.mp09.uf01.c11.p01.model.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class EncriptacioMD5 implements IEncriptacio {
	
	private EncriptacioMD5() {

	}

	private static EncriptacioMD5 instance;

	static EncriptacioMD5 getInstance() {
		if (instance == null) {
			instance = new EncriptacioMD5();
		}

		return instance;

	}
	
	@Override
	public String encripta(String valorOriginal) {
		String resultado = null;

		try {
			MessageDigest md = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
			md.update(valorOriginal.getBytes());
			byte[] digestBytes = md.digest();

			resultado = Base64.getEncoder().encodeToString(digestBytes);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultado;
	}

	
}

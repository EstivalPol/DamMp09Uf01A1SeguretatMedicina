package cat.prateducacio.dam.mp09.uf01.c11.p01.model.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class EncriptacioSha256 implements IEncriptacio {

	private EncriptacioSha256() {

	}

	private static EncriptacioSha256 instance;

	static EncriptacioSha256 getInstance() {
		if (instance == null) {
			instance = new EncriptacioSha256();
		}

		return instance;

	}

	@Override
	public String encripta(String valorOriginal) {
		String resultado = null;

		try {
			MessageDigest md = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
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

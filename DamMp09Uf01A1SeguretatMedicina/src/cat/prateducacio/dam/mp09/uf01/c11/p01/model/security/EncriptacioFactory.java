package cat.prateducacio.dam.mp09.uf01.c11.p01.model.security;

public class EncriptacioFactory {

	private EncriptacioFactory() {

	}

	private static EncriptacioFactory instance;

	public static EncriptacioFactory getInstance() {
		if (instance == null) {
			instance = new EncriptacioFactory();
		}
		return instance;
	}

	public IEncriptacio getAlgoritme(EnumAlgoritmeEncriptacio algoritme) {
		IEncriptacio encriptacio = null;
		if (algoritme == EnumAlgoritmeEncriptacio.AES) {
			encriptacio = EncriptacioAES.getInstance();
		} else if (algoritme == EnumAlgoritmeEncriptacio.MD5) {
			encriptacio = EncriptacioMD5.getInstance();
		} else if (algoritme == EnumAlgoritmeEncriptacio.SHA256) {
			encriptacio = EncriptacioSha256.getInstance();
		} else if (algoritme == EnumAlgoritmeEncriptacio.UNKNOWN) {
			// No fem res, retornarà null a l'algoritme d'encriptació
		}

		else {
			throw new RuntimeException("Algoritme desconegut");
		}

		return encriptacio;
	}

}

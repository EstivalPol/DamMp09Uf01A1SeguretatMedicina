package cat.prateducacio.dam.mp09.uf01.c11.p01.model.security;

public interface IEncriptacio {

	String encripta(String valor);

	public default String desencripta(String valor)
	{
		throw new RuntimeException("Aquest algoritme no permet desencriptar");
	}

}

package appCarregarCertificado;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Responsavel por listar os certificados que estao no repositorio do Windows
 * 
 * @author diego.almeida
 *
 */
public class AppCarregarCertificado {

	private static void carregarCertificados() {

		KeyStore ks = null;
		List<String> certificados = null;
		Enumeration<String> apelidos = null;

		try {

			ks = KeyStore.getInstance("Windows-MY", "SunMSCAPI");
			ks.load(null, null);
			apelidos = ks.aliases();
			certificados = new ArrayList<String>();

			while (apelidos.hasMoreElements()) {
				String alias = apelidos.nextElement();
				certificados.add(alias);
			}

			if (!certificados.isEmpty()) {
				
				System.out.println("LISTA DE CERTIFICADOS INSTALADOS NA MAQUINA:\n");
				
				for (String cert : certificados) {
					System.out.println(cert);
				}
			} else {
				System.out.println("NAO EXISTEM CERTIFICADOS INSTALADOS NA MAQUINA");
			}

		} catch (KeyStoreException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO: handle exception
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
		} catch (CertificateException e) {
			// TODO: handle exception
		} catch (NoSuchProviderException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		
		AppCarregarCertificado.carregarCertificados();
	}
}

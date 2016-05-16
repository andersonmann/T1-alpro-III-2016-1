/**
 * 
 */
package alpro_III.Trabalho1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author amann
 *
 */
public class Reader<E> {

	public ArrayList<String> lista;

	public Reader() {
		lista = new ArrayList();
	}

	/**
	 * Method carregaJogos.
	 * 
	 * @return - Metodo que faz a leitura do arquivo e salva em uma lista.
	 */
	public void carregaJogos() throws IOException {
		Path path = Paths.get("0.txt");
		try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
			String linha = null;
			while ((linha = br.readLine()) != null) {
				String dados[] = linha.split(",");
				int capacidade = Integer.parseInt(dados[0]);
				String data = dados[1];
				String local = dados[2];
				String time1 = dados[3];
				String time2 = dados[4];
				double valor = Integer.parseInt(dados[5]);
				lista.add(new Jogo(capacidade, data, local, time1, time2, valor));
			}
		} catch (IOException e) {
			System.err.println("Erro de E/S: " + e);
		}
		// Exibe o tamanho da lista
		// System.out.println("Tamanho " + lista.count);
	}

	@Override
	public String toString() {
		if (lista.isEmpty()) {
			return ("Lista vazia !!");
		} else {
			StringBuilder sb = new StringBuilder();
			for (Jogo p : lista) {
				sb.append(p.toString());
				sb.append("\n");
			}
			return (sb.toString());
		}
	}

}
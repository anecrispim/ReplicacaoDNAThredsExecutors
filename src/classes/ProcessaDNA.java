package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProcessaDNA {
	private String arquivoDNA;
	
	public ProcessaDNA(String arquivoDNA) {
		this.arquivoDNA = arquivoDNA;
	}
	
	public String getArquivoDNA() {
		return arquivoDNA;
	}

	public void lerArquivoDNA() {
		long id = (Thread.currentThread().getId() - 14);
		try {
            BufferedReader reader = new BufferedReader(new FileReader(arquivoDNA));
            String line;
            
            String nomeArquivoGerado = "arquivosProcessados/dna-"+id+"-processado.txt";
            FileWriter writer = new FileWriter(nomeArquivoGerado);
            
            int lineNumber = 0;
            int totalInvalidas = 0;
            int totalValidas = 0;
            ArrayList<Integer> linhasInvalidas = new ArrayList<Integer>();

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                
                if (validaDNA(line)) {
                	
                	String complementar = line
                            .replaceAll("A", "t")
                            .replaceAll("T", "a")
                            .replaceAll("G", "c")
                            .replaceAll("C", "g")
                            .toUpperCase(); // Converter para maiúsculas
                        // Gravar a sequência complementar em um arquivo
                	writer.write(complementar + System.lineSeparator());
                
                	totalValidas++;
                } else {
                	writer.write("***FITA INVÁLIDA - " + line + System.lineSeparator());
                	
                	totalInvalidas++;
                	linhasInvalidas.add(lineNumber);
                }
            }
            writer.close();

            reader.close();
            
            System.out.println("Processado arquivo "+arquivoDNA);
            System.out.println("O total de fitas é "+lineNumber);
            System.out.println("O total de fitas validas é "+totalValidas);
            System.out.println("O total de fitas inválidas é "+totalInvalidas);
            if (linhasInvalidas != null) {
            	System.out.println("O total de fitas inválidas é "+linhasInvalidas.toString());
            }
            System.out.println("Gerado arquivo "+nomeArquivoGerado);
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}
	
	public boolean validaDNA(String fita) {
		// Verificar se a sequência é composta apenas por 'A', 'C', 'G' e 'T'
        if (!fita.matches("[ACGT]+")) {
            return false;
        }

        // Se passou por todas as verificações, a sequência é válida
        return true;
	}
	
}

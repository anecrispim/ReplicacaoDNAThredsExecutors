package classes;

import java.security.SecureRandom;

public class PrintTask implements Runnable {
	private static final SecureRandom generator = new SecureRandom ();
	// tempo de adormecimento aleatorio para a thread
	private final int sleepTime ;
	private ProcessaDNA processaDNA;
	
	
	// construtor
	public PrintTask ( String arquivo ){
		this.processaDNA = new ProcessaDNA(arquivo);
		// seleciona tempo de adormecimento
		// aleatorio entre 0 e 5 segundos
		sleepTime = generator . nextInt (5000); // milissegundos
	}
	public void run (){
		// coloca a thread para dormir pela quantidade
		// de tempo sleepTime
		
		try {
			
			processaDNA.lerArquivoDNA();
			// coloca a thread para dormir
			Thread.sleep(sleepTime);
		} catch ( InterruptedException exception){
			exception.printStackTrace();
			// reinterrompe a thread
			Thread.currentThread().interrupt();
		}
	}
}

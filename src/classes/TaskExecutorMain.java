package classes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutorMain {

	public static void main(String[] args) {
		// cria e nomeia cada executavel
		PrintTask arquivo1 = new PrintTask("arquivosDNA/dna-0.txt");
		PrintTask arquivo2 = new PrintTask("arquivosDNA/dna-1.txt");
		PrintTask arquivo3 = new PrintTask("arquivosDNA/dna-2.txt");
		PrintTask arquivo4 = new PrintTask("arquivosDNA/dna-3.txt");
		PrintTask arquivo5 = new PrintTask("arquivosDNA/dna-4.txt");
		PrintTask arquivo6 = new PrintTask("arquivosDNA/dna-5.txt");
		PrintTask arquivo7 = new PrintTask("arquivosDNA/dna-6.txt");
		PrintTask arquivo8 = new PrintTask("arquivosDNA/dna-7.txt");
		PrintTask arquivo9 = new PrintTask("arquivosDNA/dna-8.txt");
		PrintTask arquivo10 = new PrintTask("arquivosDNA/dna-9.txt");
		System.out.println(" Starting Executor ");
		// cria ExecutorService para gerenciar threads
		ExecutorService executorService = Executors . newCachedThreadPool ();
		
		// inicia as tres PrintTasks
		executorService.execute(arquivo1);
		executorService.execute(arquivo2);
		executorService.execute(arquivo3);
		executorService.execute(arquivo4);
		executorService.execute(arquivo5);
		executorService.execute(arquivo6);
		executorService.execute(arquivo7);
		executorService.execute(arquivo8);
		executorService.execute(arquivo9);
		executorService.execute(arquivo10);

		// fecha ExecutorService -- ele decide quando fechar threads
		executorService.shutdown();

		System.out.printf(" Tasks started , main ends .%n%n");
	}

}

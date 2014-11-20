package br.ufpb.educservice.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class GeradorID {
	private long contadorID;
	private final String ARQUIVO = "PersistenciaID.txt";
	private List <Integer> listaDeID = new LinkedList();
	private static GeradorID singleton = null;
	
	private GeradorID(){
		
	}
	public static GeradorID getInstance(){
		if(singleton == null){
			synchronized(GeradorID.class){
				if(singleton == null){
					singleton = new GeradorID();
				}
			}
		}
		
		return singleton;
	}
	
	public List<Integer> getIDs(){
		return this.listaDeID;
	}
	
	public long gerarID(){
		try {
			this.carregarID(ARQUIVO);
		} catch (ArquivoInexistenteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		try {
			this.contadorID++;
			this.listaDeID.add((int) this.contadorID);
			GravadorID gravador = new GravadorID();
			gravador.gravarID(ARQUIVO, this.contadorID);
			
			System.out.println("Gerado com sucesso!");
			
			
		} catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return 0;
		
	}
	
	
	
	
	
	public void carregarID(String nomeDoArquivo) throws ArquivoInexistenteException, IOException{
		BufferedReader leitor = null;
		List<Integer> IDs = new LinkedList();

		try{
			leitor = new BufferedReader(new FileReader(nomeDoArquivo));
			
			do{
				this.contadorID = Integer.parseInt(leitor.readLine());
				
			} while(leitor.ready());
			
		} finally {
			if(leitor != null){
				this.listaDeID = IDs;
				leitor.close();
			}
		}	
	}
	
	
	
}

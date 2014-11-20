package br.ufpb.educservice.persistencia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
* Autor: Anderson da Silva Quintão
* Email: anderson.silva@dce.ufpb.br
*
*/

public class GravadorID {
	public void gravarID(String nomeDoArquivo, long id) throws ArquivoInexistenteException, IOException{
		String idConvert = Long.toString(id);
		BufferedWriter gravador = null;
		String ID;
		try{
			
			gravador = new BufferedWriter(new FileWriter(nomeDoArquivo));
			gravador.write(idConvert);
			gravador.newLine();
			
		} finally {
			
			if(gravador != null){
				gravador.close();
			}
		}			
	}
	
}



package br.com.isidrocorp.acme.factory;

import br.com.isidrocorp.acme.core.Chefe;
import br.com.isidrocorp.acme.core.Comissionado;
import br.com.isidrocorp.acme.core.Empreiteiro;
import br.com.isidrocorp.acme.core.Horista;
import br.com.isidrocorp.acme.root.Funcionario;
import br.com.isidrocorp.exceptions.DadosInvalidosException;
import br.com.isidrocorp.exceptions.EstruturaDeFuncionarioInvalida;
import br.com.isidrocorp.exceptions.TipoFuncionarioInvalidoException;

public class FabricaDeFuncionario {

	public static Funcionario createFromCSV(String linha) {
		try {
			String[] dados = linha.split(";");
			switch (dados[0].trim()) {
			case "1":
				return new Chefe(Integer.parseInt(dados[1].trim()), 
							     dados[2].trim(),
						         Double.parseDouble(dados[3].trim()), 
						         Double.parseDouble(dados[4].trim()),
						         Double.parseDouble(dados[5].trim()));
			case "2":
				return new Comissionado(Integer.parseInt(dados[1].trim()), 
						                dados[2],
						                Double.parseDouble(dados[3].trim()), 
						                Double.parseDouble(dados[4].trim()));
			case "3":
				return new Horista(Integer.parseInt(dados[1].trim()), 
						           dados[2], 
						           Integer.parseInt(dados[3].trim()),
						           Double.parseDouble(dados[4].trim()));
			case "4":
				return new Empreiteiro(Integer.parseInt(dados[1].trim()), 
								       dados[2],
								       Double.parseDouble(dados[3].trim()));
			default:
				throw new TipoFuncionarioInvalidoException("Tipo Invalido");
			}
		} 
		catch(NumberFormatException ex) {
			throw new DadosInvalidosException("Erro ao converter informacoes do funcionario");
		}
		catch(ArrayIndexOutOfBoundsException ex) {
			throw new EstruturaDeFuncionarioInvalida("Dados incompletos para o funcionario");
		}
		catch (Exception ex) {
			throw new RuntimeException("Erro desconhecido");
		}
		
	}

}

package br.com.isidrocorp.imposto.userinterface;

import br.com.isidrocorp.imposto.model.Contribuinte;
import br.com.isidrocorp.imposto.model.PessoaFisica;
import br.com.isidrocorp.imposto.model.PessoaJuridica;

public class SecretariaDaFazenda {
	public static void main(String[] args) {
		
		Contribuinte lista[] = new Contribuinte[5];
		
		lista[0] = new PessoaFisica(100012, "Leca","Rua da Leca, 1", "9876545", 85000, 2 );
		lista[1] = new PessoaFisica(100022, "Rogerio", "Rua do Rogerio 1","11233", 150000, 15);
		lista[2] = new PessoaFisica(100033, "Duh", "Rua do Duh s/n","45687", 180000, 3);
		lista[3] = new PessoaJuridica(200011, "IsidroCorp", "Silycon Ave 123", "9854721", 200000);
		lista[4] = new PessoaJuridica(200022, "IsiFLIX", "Silycon Ave 456","4875213",600000);
		
		for (Contribuinte c: lista) {
			System.out.println(c);
			System.out.println(c.getNome()+" - Imposto Devido R$ "+String.format("%.2f", c.calcularImposto()));
			System.out.println();
		}
		
		
	}
}

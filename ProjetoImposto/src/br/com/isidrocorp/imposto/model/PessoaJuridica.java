package br.com.isidrocorp.imposto.model;

import br.com.isidrocorp.imposto.userinterface.sistemaSeguranca;

public class PessoaJuridica extends Contribuinte  implements sistemaSeguranca{
	private String cnpj;
	private double faturamento;
	
	public PessoaJuridica(int numeroCadastral, String nome, String endereco, String cnpj, double faturamento) {
		super(numeroCadastral, nome, endereco);
		this.cnpj = cnpj;
		this.faturamento = faturamento;
	}

	
	@Override
	public String toString() {
		return "PessoaJuridica [numeroCadastral=" + numeroCadastral + ", nome=" + nome + ", endereco=" + endereco
				+ ", cnpj=" + cnpj + ", faturamento=" + faturamento + "]";
	}


	@Override
	public double calcularImposto(){
		double imposto;
		if (faturamento < 100000) {
			imposto = 0.0;
		}
		else if (faturamento < 250000) {
			imposto = faturamento * 0.06;
		}
		else if (faturamento < 450000) {
			imposto = faturamento * 0.15;
		}
		else {
			imposto = faturamento * 0.25;
		}
		return imposto;
		
		
//		throw new UnsupportedOperationException("Logica ainda n�o implementada");
		
		
	}
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public double getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(double faturamento) {
		this.faturamento = faturamento;
	}


	@Override
	public boolean validaSenha(int valor) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}

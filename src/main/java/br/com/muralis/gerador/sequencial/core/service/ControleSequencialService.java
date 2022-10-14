package br.com.muralis.gerador.sequencial.core.service;

public interface ControleSequencialService {

	Long gerarSequencial(String nome);

	Long gerarSequencial(String nome, Integer tamanho, Integer inicio);

	Long obterSequencial(String nome);

}

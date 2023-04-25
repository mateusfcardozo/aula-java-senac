/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancotaurus;

/*
 * @author mateus
 */
public class Conta{
   
    private String nome;
    private String cpf;
     private String senha;
    private String celular;
    private int numero;
    private double saldo;
    

    public Conta(String nome, String cpf, String senha, int numero, String celular, double saldo) {
        this.numero = numero;
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.saldo = saldo;
        this.senha = senha;
    }
     public int getNumero() {
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
     public String getSenha() {
        return senha;
    }
      public void setSenha(String senha) {
        this.senha = senha;
    }
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void maisSaldo(double valorAdicionado) {
        this.saldo += valorAdicionado;
    }

    public void menosSaldo(double valorRetirado) {
        this.saldo -= valorRetirado;
    }
    }
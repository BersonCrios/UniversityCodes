#!/usr/local/bin/python3
import os

import self as self
import py_compile
import compileall

self.alfabeto = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

#FUNÇÃO PRINCIPAL ONDE CONTÉM O MENU E A CHAMADA PARA AS FUNÇÕES
def main():


    op = -1

    while op != 0:
        print("========== MENU ==========")
        print("1 - Encriptar")
        print("2 - Decriptar")
        print("0 - sair")
        print("==========================")

        try:
            op = int(input("\nOpção: "))
        except:
            print("\nOpção inválida! Digite apenas valores numéricos.\n")
            quit()

        if op == 1:
            encripta(self)
        elif op == 2:
            decripta(self)
        else:
            print ("Encerrando...")



#FUNÇÃO DE ENCRIPTAR
def encripta(self,chave=4+2):
        #ENTRADA DA FRASE
        print("==========================")
        fraseInicial = input("Entre com o texto claro: ")

        #TRANFORMA EM MAIUSCULO E TRANSFORMA EM ARRAY DE LETRAS
        fraseInicial = list(fraseInicial.upper()[::-1])

        #VERIFICA TAMANHO DA FRASE
        tamanhoFrase = len(fraseInicial);

        #PEGA A PRIMEIRA E ULTIMA LETRA
        primeiraPosicao = fraseInicial[0]
        ultimaPosicao = fraseInicial[tamanhoFrase-1]

        #REMOVE A PRIMEIRA E ULTIMA LETRA DO ARRAY
        fraseInicial.remove(primeiraPosicao)
        fraseInicial.remove(ultimaPosicao)

        #INSERE A PRIMEIRA E ULTIMA LETRA E POSICOES CONTRARIAS
        fraseInicial.insert(0, ultimaPosicao)
        fraseInicial.insert(tamanhoFrase, primeiraPosicao)

        fraseRemontada = ''.join(fraseInicial)

        #JUNTA AS LETRAS EMBARALHADAS
        fraseEmbaralhada = ''.join(fraseInicial).lower()

        for ch in fraseRemontada:
            if ch in self.alfabeto:
                i = self.alfabeto.find(ch) + chave
                if i >= 26:
                    i -= 26
                fraseEmbaralhada += self.alfabeto[i]
                fraseCriptografada = fraseEmbaralhada[tamanhoFrase:]

            else:
                fraseEmbaralhada += ch

        print("Mensagem Criptografada: ",fraseCriptografada)
        print("==========================")



#FUNÇÃO DE DECRIPTAR
def decripta(self, chave=4 + 2):
        # ENTRADA DA FRASE
        print("==========================")
        fraseInicial = input("Entre com o texto criptografado: ")

        # TRANFORMA EM MAIUSCULO E TRANSFORMA EM ARRAY DE LETRAS
        fraseInicial = list(fraseInicial.upper()[::-1])

        # VERIFICA TAMANHO DA FRASE
        tamanhoFrase = len(fraseInicial);

        # PEGA A PRIMEIRA E ULTIMA LETRA
        primeiraPosicao = fraseInicial[0]
        ultimaPosicao = fraseInicial[tamanhoFrase - 1]

        # REMOVE A PRIMEIRA E ULTIMA LETRA DO ARRAY
        fraseInicial.remove(primeiraPosicao)
        fraseInicial.remove(ultimaPosicao)

        # INSERE A PRIMEIRA E ULTIMA LETRA E POSICOES CONTRARIAS
        fraseInicial.insert(0, ultimaPosicao)
        fraseInicial.insert(tamanhoFrase, primeiraPosicao)

        fraseRemontada = ''.join(fraseInicial)

        # JUNTA AS LETRAS EMBARALHADAS
        fraseEmbaralhada = ''.join(fraseInicial).lower()

        for ch in fraseRemontada:
            if ch in self.alfabeto:
                i = self.alfabeto.find(ch) - chave
                if i >= 26:
                    i -= 26
                fraseEmbaralhada += self.alfabeto[i]
                fraseCriptografada = fraseEmbaralhada[tamanhoFrase:]

            else:
                fraseEmbaralhada += ch

        print("Mensagen decriptada: ",fraseCriptografada)
        print("==========================")

compileall.compile_file('main.py',force=True)
main()
os.system("PAUSE")

package com.mariaeduarda;

import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;

import java.util.Scanner;

public class ChatSimples {
    public static void main(String[] args) {
        // Conectar ao Ollama
        OllamaAPI ollama = new OllamaAPI("http://localhost:11434");
        ollama.setRequestTimeoutSeconds(120);

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   CHAT COM OLLAMA");
        System.out.println("=================================");
        System.out.println("Digite suas perguntas (ou 'sair' para encerrar)\n");

        while (true) {
            System.out.print("Você: ");
            String pergunta = scanner.nextLine();

            // Verificar se quer sair
            if (pergunta.equalsIgnoreCase("sair") ||
                    pergunta.equalsIgnoreCase("exit")) {
                System.out.println("\nAté logo! 👋");
                break;
            }

            // Verificar se digitou algo
            if (pergunta.trim().isEmpty()) {
                continue;
            }

            try {
                System.out.print("\nIA: ");

                // Fazer a pergunta ao modelo (com streaming)
                ollama.generate(
                        "llama3.2",  // Modelo instalado
                        pergunta,
                        new OptionsBuilder()
                                .setTemperature(0.7)
                                .build(),
                        (resposta) -> {
                            // Imprimir cada parte da resposta conforme chega
                            System.out.print(resposta);
                        }
                );

                System.out.println("\n");

            } catch (Exception e) {
                System.err.println("\n Erro: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
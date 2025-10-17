package com.mariaeduarda;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(java.time.Duration.ofSeconds(120))
                .build();

        System.out.println("=================================");
        System.out.println("   CHAT COM OLLAMA");
        System.out.println("=================================");
        System.out.println("Digite suas perguntas (ou 'sair' para encerrar)\n");

        while (true) {
            System.out.print("Você: ");
            String pergunta = scanner.nextLine();

            if (pergunta.equalsIgnoreCase("sair") ||
                    pergunta.equalsIgnoreCase("exit")) {
                System.out.println("\nAté logo! 👋");
                break;
            }

            if (pergunta.trim().isEmpty()) {
                continue;
            }

            try {
                System.out.println("\n[DEBUG] Enviando pergunta para o Ollama...");

                // Criar o JSON da requisição
                JSONObject json = new JSONObject();
                json.put("model", "llama3.2:latest");
                json.put("prompt", pergunta);
                json.put("stream", false);

                System.out.println("[DEBUG] JSON enviado: " + json.toString());

                // Criar a requisição HTTP
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:11434/api/generate"))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                        .build();

                // Enviar e receber resposta
                System.out.println("[DEBUG] Aguardando resposta...");
                HttpResponse<String> response = client.send(request,
                        HttpResponse.BodyHandlers.ofString());

                System.out.println("[DEBUG] Status code: " + response.statusCode());
                System.out.println("[DEBUG] Resposta completa: " + response.body());

                // Processar resposta
                JSONObject resposta = new JSONObject(response.body());
                String textoResposta = resposta.getString("response");

                System.out.print("\nIA: ");
                System.out.println(textoResposta);
                System.out.println();

            } catch (Exception e) {
                System.err.println("\nErro: " + e.getMessage());
                System.err.println("Certifique-se de que o Ollama está rodando!");
                System.err.println("Execute: ollama serve");
                System.err.println();
            }
        }

        scanner.close();
    }
}

# ENGENHARIA DE SOFTWARE

## ATIVIDADE 1 – Comentário sobre o primeiro trecho do livro *Software Engineering at Google*

O trecho estabelece uma distinção entre três conceitos frequentemente confundidos: **programação, ciência da computação e engenharia de software**.  
O texto questiona o que realmente significa *engenharia de software* e por que o Google teria uma perspectiva única sobre o tema. Os autores observam que, embora os termos "programação" e "engenharia de software" sejam usados como sinônimos na indústria, eles carregam significados diferentes:  

- **Programação**: estudantes de ciência da computação aprendem a escrever código e atuam como programadores.  
- **Engenharia de software**: sugere algo mais sério, a aplicação de conhecimento teórico para construir algo concreto e preciso.  

O ponto crucial é que, ao contrário de engenharias tradicionais, que seguem diretrizes rígidas, a prática de programação historicamente não seguiu padrões tão rigorosos. Os autores argumentam que, à medida que o software se torna mais integrado às nossas vidas, precisamos adotar métodos de engenharia mais **rígidos e confiáveis**, tratando o desenvolvimento de software com a mesma seriedade das engenharias tradicionais.

---

## ATIVIDADE 2 – Comentário sobre o segundo trecho do livro *Software Engineering at Google*

Os autores aprofundam o conceito anterior e definem engenharia de software como **não apenas escrever código**, mas todo o ecossistema de **ferramentas, processos e práticas** que uma organização utiliza para construir e **manter** o código ao longo do tempo.  

A frase-chave do trecho é: **“software engineering is programming integrated over time”**. Ou seja, é pensar no código como algo que deve ser sustentável e adaptável durante todo seu ciclo de vida: da concepção à manutenção e eventual descontinuação.  

O livro organiza esse conceito em três princípios fundamentais:  

1. **Tempo e Mudança** – Como o código precisa se adaptar durante sua vida útil.  
2. **Escala e Crescimento** – Como a organização evolui à medida que cresce.  
3. **Trade-offs e Custos** – Como tomar decisões equilibrando os dois pontos anteriores.  

O foco central é a **sustentabilidade do software**, garantindo que ele continue útil e adaptável frente às mudanças e crescimento da organização.

---

## ATIVIDADE 3 – Análise de dilemas de engenharia de software

### 1. Monólito vs Microsserviços
**Dilema:** manter tudo em uma aplicação única ou dividir em serviços independentes?  

**Monólito:**  
- Vantagens: simples de desenvolver, depurar e deployar; fluxo fácil de rastrear; transações diretas.  
- Desvantagens: difícil manutenção em sistemas grandes; mudanças podem impactar tudo; escalabilidade limitada.  

**Microsserviços:**  
- Vantagens: times independentes; escalabilidade seletiva; falhas isoladas; tecnologias variadas por serviço.  
- Desvantagens: complexidade operacional; comunicação entre serviços; latência; monitoramento e deployments complexos.  

**Exemplo:** Netflix usa microsserviços para escalar streaming e recomendações independentemente. Startups pequenas podem se beneficiar mais de um monólito bem estruturado.

---

### 2. Segurança vs Usabilidade
**Dilema:** priorizar segurança máxima ou experiência do usuário fluida?  

**Segurança máxima:**  
- Vantagens: proteção de dados; autenticação forte; criptografia completa.  
- Desvantagens: fricção para o usuário; experiência pode ficar frustrante.  

**Usabilidade máxima:**  
- Vantagens: login rápido; zero barreiras; experiência agradável.  
- Desvantagens: maior risco de ataques; menor proteção de dados.  

**Exemplo:**  
- App bancário → prioriza segurança.  
- Jogo mobile casual → prioriza usabilidade.

---

### 3. Build vs Buy (Construir vs Comprar)
**Dilema:** desenvolver internamente ou usar soluções prontas?  

**Build (construir):**  
- Vantagens: total controle; customização; sem dependência de terceiros.  
- Desvantagens: alto custo de tempo e manutenção; reinvenção de soluções existentes.  

**Buy (comprar):**  
- Vantagens: solução rápida; suporte; atualizações automáticas; foca no core business.  
- Desvantagens: custo contínuo; dependência do fornecedor; menor flexibilidade.  

**Exemplo:**  
- Sistema de pagamentos → comprar (Stripe).  
- Algoritmo de recomendação → construir internamente se for diferencial competitivo.

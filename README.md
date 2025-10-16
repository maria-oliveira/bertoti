# ENGENHARIA DE SOFTWARE 💻

## ATIVIDADE 1
Comentar com suas palavras o primeiro trecho do livro Software Engineering at Google, Oreilly.
"What precisely do we mean by software engineering? What distinguishes “software engineering” from “programming” or “computer science”? And why would Google have a unique perspective to add to the corpus of previous software engineering literature written over the past 50 years? The terms “programming” and “software engineering” have been used interchangeably for quite some time in our industry, although each term has a different emphasis and different implications. University students tend to study computer science and get jobs writing code as “programmers.” “Software engineering,” however, sounds more serious, as if it implies the application of some theoretical knowledge to build something real and precise. Mechanical engineers, civil engineers, aeronautical engineers, and those in other engineering disciplines all practice engineering. They all work in the real world and use the application of their theoretical knowledge to create something real. Software engineers also create “something real,” though it is less tangible than the things other engineers create. Unlike those more established engineering professions, current software engineering theory or practice is not nearly as rigorous. Aeronautical engineers must follow rigid guidelines and practices, because errors in their calculations can cause real damage; programming, on the whole, has traditionally not followed such rigorous practices. But, as software becomes more integrated into our lives, we must adopt and rely on more rigorous engineering methods. We hope this book helps others see a path toward more reliable software practices."

O trecho estabelece uma distinção entre três conceitos que frequentemente se confundem: programação, ciência da computação e engenharia de software.
O texto questiona o que realmente significa "engenharia de software" e por que o Google teria uma perspectiva única sobre o tema. Os autores observam que, embora os termos "programação" e "engenharia de software" sejam usados como sinônimos na indústria, eles carregam pesos diferentes. Enquanto estudantes universitários aprendem ciência da computação e trabalham como "programadores", o termo "engenharia de software" sugere algo mais sério, a aplicação de conhecimento teórico para construir algo concreto e preciso.
O ponto crucial é que, ao contrário dessas engenharias tradicionais que seguem diretrizes rígidas, a prática de programação historicamente não seguiu padrões tão rigorosos. Os autores argumentam que, à medida que o software se torna cada vez mais integrado às nossas vidas, precisamos adotar métodos de engenharia mais rigorosos e confiáveis. É uma chamada para profissionalizar e amadurecer a área, tratando o desenvolvimento de software com o mesmo nível de seriedade e metodologia das engenharias estabelecidas.

---

## ATIVIDADE 2
 Comentar com suas palavras o segundo trecho do livro Software Engineering at Google, Oreilly.(vou postar abaixo)

"Programming Over Time
We propose that “software engineering” encompasses not just the act of writing code, but all of the tools and processes an organization uses to build and maintain that code over time. What practices can a software organization introduce that will best keep its code valuable over the long term? How can engineers make a codebase more sustainable and the software engineering discipline itself more rigorous? We don’t have fundamental answers to these questions, but we hope that Google’s collective experience over the past two decades illuminates possible paths toward finding those answers. One key insight we share in this book is that software engineering can be thought of as “programming integrated over time.” What practices can we introduce to our code to make it sustainable—able to react to necessary change—over its life cycle, from conception to introduction to maintenance to deprecation?
The book emphasizes three fundamental principles that we feel software organizations should keep in mind when designing, architecting, and writing their code:

Time and Change
-How code will need to adapt over the length of its life
-Scale and Growth
-How an organization will need to adapt as it evolves
-Trade-offs and Costs
How an organization makes decisions, based on the lessons of Time and Change and Scale and Growth"

Neste segundo trecho, os autores aprofundam o conceito que começaram a desenvolver anteriormente, trazendo uma definição bem clara do que seria engenharia de software na visão do Google.
A sacada principal é essa: engenharia de software não é só sentar e escrever código. É todo o ecossistema de ferramentas, processos e práticas que uma organização usa pra construir e, principalmente, **manter** esse código funcionando ao longo do tempo.
Eles trazem uma frase que resume tudo: engenharia de software é **"programação integrada ao longo do tempo"**. É pensar: eu escrevi o código hoje, mas e daqui a 2 anos? E quando precisar mudar? E quando a equipe crescer? O código vai continuar fazendo sentido? Vai ser fácil de modificar?
A questão central é sobre sustentabilidade, como fazer um código que consiga reagir às mudanças inevitáveis durante todo seu ciclo de vida, desde quando é só uma ideia até quando precisa ser descontinuado.

Pra organizar esse pensamento, o livro se estrutura em torno de três princípios fundamentais:
1. **Tempo e Mudança** - Como o código vai precisar se adaptar durante sua vida útil
2. **Escala e Crescimento** - Como a organização vai precisar evoluir conforme cresce
3. **Trade-offs e Custos** - Como tomar decisões levando em conta os dois primeiros pontos

---

## ATIVIDADE 3
**1. Monolito vs Microsserviços**
O dilema: Manter tudo em uma aplicação única ou dividir em serviços independentes?
Trade-offs envolvidos:

Monolito é mais simples de desenvolver, deployar e debugar. Tudo está junto, você consegue rastrear o fluxo facilmente, não precisa lidar com comunicação entre serviços, e as transações são diretas. Mas conforme o sistema cresce, fica mais difícil de manter, qualquer mudança pode afetar tudo, e você não consegue escalar partes específicas independentemente.
Microsserviços permitem que times trabalhem independentemente, você escala só o que precisa, pode usar tecnologias diferentes para problemas diferentes, e falhas ficam isoladas. Porém, a complexidade operacional explode - você precisa gerenciar comunicação entre serviços, latência de rede, consistência distribuída, monitoramento complexo, e deployments coordenados.

Na prática: Netflix usa microsserviços porque precisa escalar streaming independentemente de recomendações. Mas uma startup com 3 desenvolvedores provavelmente vai sofrer tentando gerenciar 20 microsserviços quando um monolito bem feito resolveria.


**2. Segurança vs Usabilidade**
O dilema: Tornar o sistema super seguro ou super fácil de usar?
Trade-offs envolvidos:

Segurança máxima significa autenticação de dois fatores, senhas complexas, timeout curto de sessão, criptografia em tudo, múltiplas confirmações para ações sensíveis. Seus dados estão protegidos, mas os usuários vão reclamar de tanta fricção - "por que preciso colocar senha de novo?" ou "essa senha precisa ter 20 caracteres?".
Usabilidade máxima é login social com um clique, sessões que nunca expiram, lembrar todas as preferências, zero barreiras. Os usuários adoram a experiência fluida, mas você aumenta drasticamente a superfície de ataque e os riscos de segurança.

Na prática: Um app bancário vai pesar mais pra segurança - melhor ter usuários incomodados que contas invadidas. Já um jogo casual mobile pode priorizar usabilidade - ninguém quer ficar colocando senha toda vez que abre o jogo. O truque é encontrar o equilíbrio: segurança onde importa, sem adicionar fricção desnecessária.


**3. Build vs Buy**
O dilema: Desenvolver uma solução própria ou usar algo pronto do mercado?
Trade-offs envolvidos:

Build (construir) te dá controle total, customização perfeita pro seu caso, sem dependência de terceiros, e você não paga licenças. Mas consome muito tempo e recursos, você precisa manter e evoluir a solução, tem que lidar com todos os bugs, e provavelmente vai reinventar a roda em muitos aspectos.
Buy (comprar) significa solução rápida, suporte profissional, atualizações automáticas e best practices embutidas. Você foca no seu core business em vez de problemas já resolvidos. Porém, você paga continuamente (custos de licença), fica preso ao vendor, tem menos flexibilidade pra customizar, e depende da roadmap de outra empresa.

Na prática: Não faz sentido construir seu próprio sistema de pagamentos quando Stripe existe. Mas o algoritmo de recomendação que é o diferencial competitivo da sua empresa? Aí talvez valha construir. Amazon construiu AWS porque precisava, mas usa serviços terceiros pra coisas como email marketing. A pergunta é sempre: "isso é core pro nosso negócio ou é commodity?" ARRUME O READEME
- Algoritmo de recomendação → construir internamente se for diferencial competitivo.

---

## ATIVIDADE 4
<img width="803" height="445" alt="image" src="https://github.com/user-attachments/assets/dabb0075-7d04-48f1-b6af-a601e6fbb150" />

---

## ATIVIDADE 5
<img width="625" height="834" alt="image" src="https://github.com/user-attachments/assets/9b4e9be3-2de4-4a2c-b2a8-85f78211e4f9" />
<img width="493" height="968" alt="image" src="https://github.com/user-attachments/assets/4e90a364-a034-4d3b-9bec-8a62001575ab" />

---

## ATIVIDADE 6
<img width="805" height="883" alt="image" src="https://github.com/user-attachments/assets/f90a38ab-1b3a-4006-9e1d-3a6ada07b2f8" />

# ATIVIDADE 7
 Integração com SQLite [Integração com SQLite](./engenhariadesoftware/Atividade7)

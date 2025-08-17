# 📘 Livro *Software Engineering at Google*

---
## 🔹 Primeiro Trecho
Embora muitas vezes sejam tratados como iguais cada termo tem um peso diferente, programação e a atividade de escrever códigos
e engenharia de software é a aplicação de princípios e boas práticas para projetar e manter sistemas de software de forma confiável e sustentável.
O paralelo com outras áreas da engenharia evidencia que a engenharia também envolve responsabilidade prática, criar algo que funcione no mundo
real e que tenha impacto na vida das pessoas, o software mesmo intangível, também carrega essa responsabilidade.
O ponto que o autor defende se torna cada vez mais valido, devemos tratar o desenvolvimento de software com a mesma seriedade das outras engenharias,
afinal o impacto do software é cada vez maior na sociedade.

---

## 🔹 Segundo Trecho
O valor do software não e dado para o funcionamento atual e sim em se manter útil e sustentável ao longo do tempo. Para que isso aconteça práticas que considerem processos, ferramentas e cultura organizacional são exigidas, não somente algoritmos e sintaxes.
Programação é o ato imediato, mas engenharia de software é o resultado de programação mais tempo, isso significa refletir sobre como o código lida com mudanças inevitáveis,como permanece compreensível para novos desenvolvedores e como evolui sem acumular
dívidas técnicas que comprometam sua qualidade. Nessa perspectiva, a manutenção deixa de ser uma atividade secundária e passa a ocupar um papel essencial no ciclo de vida do software.
Os três princípios fundamentais destacados pelo autor são Tempo e Mudança, Escala e Crescimento e Compensações e Custos. O primeiro ressalta que um código que não muda está morto, 
pois todo software relevante precisa evoluir para atender novas necessidades ou corrigir falhas, e o grande desafio é projetar sistemas capazes de mudar sem se quebrar.
O segundo princípio mostra que o software não cresce sozinho, mas junto com a organização, já que times aumentam, produtos se expandem e a complexidade se multiplica, por isso, 
são necessárias práticas de coordenação, padrões de qualidade e ferramentas de colaboração que sustentem esse crescimento. O terceiro princípio lembra que toda decisão 
em engenharia envolve custos, seja de tempo, desempenho, complexidade ou dinheiro. Nem sempre a solução mais elegante é a melhor, e por isso é fundamental que as escolhas sejam feitas de forma consciente, 
considerando o contexto, as prioridades e os efeitos de longo prazo.

---

## 🔹 Exemplos de Trade-offs

1. **🚀 Velocidade vs. Qualidade**  
Às vezes a equipe precisa decidir: entregamos logo ou fazemos com mais cuidado? Entregar rápido ajuda a mostrar resultados imediatos, mas pode deixar o código cheio de “remendos” que dão trabalho depois.
Já caprichar na qualidade leva mais tempo, mas evita dores de cabeça no futuro.

2. **⚡ Performance vs. Facilidade de manutenção**
Um código super rápido costuma ser mais complicado e difícil de entender. Já um código simples é fácil de mexer, mas pode gastar mais recursos da máquina. 
A escolha depende da situação: em alguns casos, velocidade é essencial; em outros, clareza é o que mais importa.

3. **🔗 Centralização vs. Flexibilidade**  
Concentrar tudo em um único serviço deixa o sistema mais fácil de controlar, mas cria um ponto de falha. Dividir em vários serviços independentes dá mais flexibilidade e resistência, só que também traz mais complexidade para coordenar.

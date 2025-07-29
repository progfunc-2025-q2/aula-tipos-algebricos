# Tipos Algébricos em Scala

Este projeto demonstra o uso de **tipos algébricos** na linguagem Scala, abordando conceitos fundamentais de programação funcional como tipos produto, tipos soma, e estruturas de dados imutáveis.

## O que são Tipos Algébricos?

Tipos algébricos são tipos definidos pela combinação de outros tipos usando duas operações principais:

- **Tipos Produto** (Product Types): Combinam múltiplos valores em uma única estrutura (como tuplas e case classes)
- **Tipos Soma** (Sum Types): Representam uma escolha entre diferentes alternativas (como sealed traits com case classes)

## Estrutura do Projeto

### Arquivos de Código

#### 1. `Tuple.scala` - Tipos Produto com Tuplas
Demonstra o uso de tuplas como tipos produto simples:
- Tuplas de diferentes aridades (2-tupla, 3-tupla)
- Acesso aos elementos usando `._1`, `._2`, etc.
- Imutabilidade e criação de novas tuplas
- Tuplas heterogêneas (com tipos diferentes)

**Como executar:**
```bash
sbt "runMain testPoint"
sbt "runMain testMixedTuple"
```

#### 2. `CaseClass.scala` - Tipos Produto com Case Classes
Explora case classes como uma forma mais estruturada de tipos produto:
- Definição e instanciação de case classes
- Métodos automáticos (`toString`, `equals`, `hashCode`)
- Método `copy` para atualizações imutáveis
- Acesso direto aos campos

**Como executar:**
```bash
sbt "runMain testPoint"
```

#### 3. `Result.scala` - Tipos Soma Customizados
Implementa um tipo soma customizado para tratamento de resultados:
- Definição de sealed trait com múltiplas variantes
- Pattern matching exaustivo
- Tratamento explícito de erros sem exceções
- Variantes: `Success`, `Failure`, `Pending`

**Como executar:**
```bash
sbt "runMain testResult"
sbt "runMain runResultExample"
```

#### 4. `Try.scala` - Tipos Soma da Biblioteca Padrão
Demonstra o uso do tipo `Try` da biblioteca padrão do Scala:
- Tratamento automático de exceções
- Tipos `Success` e `Failure`
- Operações seguras que podem falhar

**Como executar:**
```bash
sbt "runMain run"
```

#### 5. `List.scala` - Estruturas de Dados Recursivas
Implementa uma lista ligada customizada usando tipos algébricos:
- Definição recursiva com `sealed trait`
- Casos base (`MyNil`) e recursivo (`Cons`)
- Funções recursivas (`sum`, `concat`)
- Demonstração de pattern matching em estruturas recursivas

**Como executar:**
```bash
sbt "runMain runListSum"
sbt "runMain runListConcat"
```

## Conceitos Abordados

### Tipos Produto
- **Tuplas**: Estruturas simples para agrupar valores
- **Case Classes**: Estruturas nomeadas com funcionalidades extras
- **Imutabilidade**: Valores não podem ser modificados após criação
- **Acesso estrutural**: Acesso direto aos componentes

### Tipos Soma
- **Sealed Traits**: Hierarquias fechadas de tipos
- **Pattern Matching**: Análise exaustiva de casos
- **Tratamento de Erros**: Alternativa funcional às exceções
- **Variantes**: Diferentes casos de um mesmo tipo abstrato

### Recursão e Estruturas de Dados
- **Definições Recursivas**: Tipos que se referenciam
- **Funções Recursivas**: Processamento recursivo de estruturas
- **Casos Base**: Condições de parada da recursão

## Executando o Projeto

### Compilar todos os arquivos:
```bash
sbt compile
```

### Executar um arquivo específico:
```bash
sbt "runMain <nomeDaFuncaoMain>"
```

### Executar no REPL interativo:
```bash
sbt console
```

## Ambiente de Desenvolvimento

Este projeto utiliza **DevContainer** para garantir um ambiente consistente de desenvolvimento.

### Usando GitHub Codespaces (Recomendado)
1. Clique em **"Code"** no repositório GitHub
2. Selecione **"Open with Codespaces"**
3. Aguarde a inicialização automática do ambiente
4. Use o terminal integrado para executar os comandos

### Usando Localmente com Docker
1. Instale [Docker](https://www.docker.com/) e [VS Code](https://code.visualstudio.com/)
2. Instale a extensão [Dev Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers)
3. Abra o projeto no VS Code
4. Use o comando **"Reabrir no Container"**

### Ferramentas Incluídas
- **Scala**: Compilador e runtime
- **SBT**: Ferramenta de build
- **Metals**: Language server para suporte avançado no VS Code

## Exercícios Sugeridos

1. **Tuplas**: Crie tuplas representando diferentes entidades (pessoa, produto, coordenada 3D)
2. **Case Classes**: Implemente case classes para modelar um domínio específico
3. **Pattern Matching**: Adicione novos casos aos tipos soma existentes
4. **Recursão**: Implemente funções recursivas adicionais para `MyList`
5. **Combinação**: Use tipos produto e soma juntos para modelar estruturas complexas

## Recursos Adicionais

- [Documentação Oficial do Scala](https://docs.scala-lang.org/)
- [Guia de Case Classes](https://docs.scala-lang.org/tour/case-classes.html)
- [Pattern Matching and Sealed Classes](https://docs.scala-lang.org/tour/pattern-matching.html)

---

# aula-tipos-algebricos

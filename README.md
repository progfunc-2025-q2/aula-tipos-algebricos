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

#### 6. `GuardPatterns.scala` - Pattern Matching com Guards
Demonstra o uso de guard patterns para adicionar condições ao pattern matching:
- Guards com `if` para condições extras nos padrões
- Categorização de itens baseada em faixas de preços
- Combinação de extração de valores e lógica condicional
- Tratamento de múltiplas condições com operadores lógicos

**Como executar:**
```bash
sbt "runMain guardPatterns.main"
```

#### 7. `Unapply.scala` - Extractors Customizados
Explora a implementação manual de extractors e o método `unapply`:
- Implementação de `apply` e `unapply` para classes regulares
- Diferenças entre case classes e classes com extractors manuais
- Desestruturação customizada em pattern matching
- Sintaxe conveniente para criação e extração de valores

**Como executar:**
```bash
sbt "runMain testPoint2"
```

#### 8. `PatternFlavors.scala` - Variações de Pattern Matching
Demonstra diferentes tipos e técnicas de pattern matching:
- Desestruturação de variáveis com case classes
- Pattern matching exaustivo com tipos soma
- Pattern matching com listas (head::tail)
- Pattern matching aninhado com estruturas complexas
- Processamento de estruturas de dados recursivas

**Como executar:**
```bash
sbt "runMain variableDestructuring"
sbt "runMain runAreaCalculations"
sbt "runMain parameterDestructuring"
sbt "runMain runListExample"
sbt "runMain runCustomerExample"
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

### Pattern Matching Avançado
- **Guard Patterns**: Condições extras com `if` no pattern matching
- **Extractors Customizados**: Implementação manual de `unapply`
- **Desestruturação**: Extração de valores de estruturas complexas
- **Pattern Matching Aninhado**: Extração de múltiplos níveis
- **Wildcard Patterns**: Tratamento de casos padrão com `_`

### Recursão e Estruturas de Dados
- **Definições Recursivas**: Tipos que se referenciam
- **Funções Recursivas**: Processamento recursivo de estruturas
- **Casos Base**: Condições de parada da recursão
- **Pattern Matching Recursivo**: Análise de estruturas como listas

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
4. **Guard Patterns**: Implemente classificações usando guards com múltiplas condições
5. **Extractors**: Crie extractors customizados para suas próprias classes
6. **Recursão**: Implemente funções recursivas adicionais para `MyList`
7. **Pattern Matching Aninhado**: Modele estruturas complexas com múltiplos níveis
8. **Combinação**: Use tipos produto e soma juntos para modelar estruturas complexas

## Recursos Adicionais

- [Documentação Oficial do Scala](https://docs.scala-lang.org/)
- [Guia de Case Classes](https://docs.scala-lang.org/tour/case-classes.html)
- [Pattern Matching and Sealed Classes](https://docs.scala-lang.org/tour/pattern-matching.html)
- [Extractor Objects](https://docs.scala-lang.org/tour/extractor-objects.html)

---

# aula-tipos-algebricos

# Graph Report - pix  (2026-06-10)

## Corpus Check
- 23 files · ~3,197 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 82 nodes · 76 edges · 16 communities (4 shown, 12 thin omitted)
- Extraction: 79% EXTRACTED · 21% INFERRED · 0% AMBIGUOUS · INFERRED: 16 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Community Hubs (Navigation)
- [[_COMMUNITY_Community 0|Community 0]]
- [[_COMMUNITY_Community 1|Community 1]]
- [[_COMMUNITY_Community 2|Community 2]]
- [[_COMMUNITY_Community 3|Community 3]]
- [[_COMMUNITY_Community 4|Community 4]]
- [[_COMMUNITY_Community 5|Community 5]]
- [[_COMMUNITY_Community 6|Community 6]]
- [[_COMMUNITY_Community 7|Community 7]]
- [[_COMMUNITY_Community 8|Community 8]]
- [[_COMMUNITY_Community 9|Community 9]]
- [[_COMMUNITY_Community 10|Community 10]]
- [[_COMMUNITY_Community 11|Community 11]]
- [[_COMMUNITY_Community 12|Community 12]]
- [[_COMMUNITY_Community 13|Community 13]]
- [[_COMMUNITY_Community 14|Community 14]]
- [[_COMMUNITY_Community 15|Community 15]]

## God Nodes (most connected - your core abstractions)
1. `ChavePixCad` - 7 edges
2. `ChavePixTest` - 6 edges
3. `ChavePixApplicationTests` - 5 edges
4. `Projeto de Gerenciamento e API PIX (Padrão BACEN)` - 5 edges
5. `CobController` - 4 edges
6. `ChavePix` - 4 edges
7. `PixController` - 3 edges
8. `ValidaBanco` - 3 edges
9. `Getting Started` - 3 edges
10. `PixApplication` - 2 edges

## Surprising Connections (you probably didn't know these)
- None detected - all connections are within the same source files.

## Communities (16 total, 12 thin omitted)

### Community 0 - "Community 0"
Cohesion: 0.14
Nodes (3): ChavePix, ChavePixApplicationTests, ChavePixTest

### Community 2 - "Community 2"
Cohesion: 0.17
Nodes (4): ValidaChave, ValidadorCnpj, ValidadorCPF, ValidadorTelefone

### Community 3 - "Community 3"
Cohesion: 0.33
Nodes (5): Como Executar, Estrutura do Projeto, Objetivo, Projeto de Gerenciamento e API PIX (Padrão BACEN), Tecnologias Utilizadas

### Community 6 - "Community 6"
Cohesion: 0.50
Nodes (3): Getting Started, Guides, Reference Documentation

## Knowledge Gaps
- **12 isolated node(s):** `java.compile.nullAnalysis.mode`, `Cobranca`, `PixTransaction`, `Cadpix`, `CobrancaRepository` (+7 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **12 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **What connects `java.compile.nullAnalysis.mode`, `Cobranca`, `PixTransaction` to the rest of the system?**
  _12 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Community 0` be split into smaller, more focused modules?**
  _Cohesion score 0.1437908496732026 - nodes in this community are weakly interconnected._
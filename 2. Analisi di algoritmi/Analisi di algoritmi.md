## analisi di algoritmi
### analisi di algoritmi
- Studia **efficienza** e **efficacia** algoritmo
- Valuta ==complessità==
	- **tempo**
	- spazio
- Valuta ==correttezza==
	- terminazione
	- **soluzione** del **problema** **computazionale**
### complessità in tempo
- La ==complessità in tempo== di un algoritmo è una stima del suo tempo di esecuzione
- A livello sperimentale, il tempo dipende anche da:
	- **istanza di input**
		-  a parità di taglia potrebbero esserci tempi diversi
	- ambiente **HW**
	- ambiente **SW**
- **Requisiti** per l'**analisi** della complessità:
	- considerare **tutti** gli input
	- permettere di **confrontare** algoritmi
	- deve poter essere eseguita anche con **pseudocodice**
- **Approccio**:
	- **analisi al caso pessimo** in funzione della **taglia** dell'istanza
		- in alternativa: analisi al caso medio, analisi probabilistica
	- **conteggio passi elementari modello RAM**
	- **analisi asintotica** (semplifica conteggio)
#### definizione di complessità al caso pessimo
- La ==complessità (in tempo) al caso pessimo== di $A$ è la funzione $t_A(n)$ come il massimo numero di operazioni che $A$ esegue per risolvere un istanza di taglia $n$
- Sia $t_{A,i}=\,$numero di operazioni eseguite da $A$ per eseguire l'istanza $i$
- Allora $t_A(n) = \max \left\{ t_{A,i} : i \in \mathcal{I}, \ i \ \text{è di taglia} \ n \right\}.$
#### calcolo complessità
- Difficoltà:
	- difficile identificare l'istanza peggiore di n
	- difficile contare in maniera precisa il numero
- Non serve determinare esattamente $t_{A}(n)$
- Basta calcolare **limite superiore** e **inferiore** di $t_{A}(n)$
#### upper e lower bound alla complessità
![[Pasted image 20241003153609.png|400]]
- Legenda
	- pallini: 
		- diversi tipi di istanza di taglia n
		- scuro: istanza pessima
	- la posizione sulle y dipende da tempo di esecuzione
		- calcolato con modello RAM
- $t_u$
	- **Upper bound**
	- limite superiore di $t_A(n)$ valido per ogni istanza
	- $\forall i, t_{A,i} \leq t_u$
- $t_l$
	- **Lower bound**
	- limite inferiore di $t_A(n)$ valido per ogni istanza
	- $\forall i, t_{A,i} \geq t_l$
	- viene incluso nel calcolo anche il caso migliore quindi non è molto utile
- $t_L$
	- limite inferiore valido per almeno un'istanza (considerando quella caso peggiore o più vicina a caso peggiore)
	- dà limite inferiore più stretto valido per ogni istanza
	- $\exists i, t_{A,i} \geq t_l$
#### analisi asintotica
- Si ignorano fattori moltiplicativi costanti
- Si ignorano termini additivi non dominanti
- Si esprime attraverso **ordini di grandezza**
#### ordini di grandezza
- Integra da slides, latex fa schifo

### analisi complessità in pratica
- Algoritmo $A$ con complessità $t_A(n)$
- Si cercano bound più vicini possibili alla complessità di $A$
	- $f(n)$ più semplice possibile solo con elementi essenziali
#### limite superiore
- $t_{A(n)}\in O(f(n))$
- deve valere per tutte le istanze
#### limite inferiore
- $t_{A(n)}\in \Omega(f(n))$
- esiste almeno per un istanza

### terminologia per complessità
- Logaritmica
- lineareQuadratica
- Cubica
- Polimoniale
- Esponenziale
- Polilogaritmica
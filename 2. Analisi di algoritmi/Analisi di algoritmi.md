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
- La ==complessità in tempo== di un algoritmo è una **stima** del suo **tempo** di **esecuzione**
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
### definizione di complessità al caso pessimo di a
-  $t_A(n)$ = massimo numero di **operazioni** che $A$ esegue per **risolvere** un istanza di taglia $n$
	- sia $t_{A,i}(n)=\,$numero di operazioni eseguite da $A$ per l'istanza $i$ di taglia $n$
	- allora $t_A(n) = \max \left\{ t_{A,i}(n) : i \in \mathcal{I} \right\}$
- In altre parole, si considera il tempo di esecuzione nel **caso peggiore**
#### calcolo complessità
- Difficoltà:
	- difficile **identificare** l'istanza peggiore di n
	- difficile **contare** in maniera precisa il numero
- Non serve determinare esattamente $t_{A}(n)$
	- è comunque una stima, il tempo di esecuzione reale dipende anche da HW
- Basta calcolare **limite superiore** e **inferiore** di $t_{A}(n)$
### upper e lower bound alla complessità
![[Pasted image 20241003153609.png|400]]
- Legenda
	- pallini: 
		- diversi tipi di istanza di taglia n
		- scuro: istanza nel caso peggiore
	- la posizione sulle y dipende da tempo di esecuzione
		- stimato con modello RAM
- $t_u$
	- **limite superiore** di $t_A(n)$ valido per **ogni istanza** (upper bound)
	- $\forall i, t_{A,i} \leq t_u$
- $t_l$
	- **limite inferiore** di $t_A(n)$ valido per **ogni istanza**
		- di solito è determinato dal **caso migliore**
	- $\forall i, t_{A,i} \geq t_l$
- $t_L$
	- **limite inferiore** di $t_A(n)$ valido per almeno un'istanza
		- si trova considerando il limite inferiore nel **caso peggiore**
		- dà limite inferiore più stretto rispetto a quello valido per ogni istanza
	- $\exists i, t_{A,i} \geq t_l$
### analisi asintotica
- Non è necessaria una quantificazione precisa delle operazioni elementari
	- si ignorano fattori moltiplicativi costanti
	- si ignorano termini additivi non dominanti
- Si esprime attraverso **ordini di grandezza**
### ordini di grandezza
- Integra da slides, latex fa schifo

### analisi complessità attraverso ordini di grandezza
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
- Lineare
- Quadratica
- Cubica
- Polimoniale
- Esponenziale
- Polilogaritmica
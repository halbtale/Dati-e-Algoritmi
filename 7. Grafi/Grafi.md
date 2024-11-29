## grafi
### definizione di grafo
- Si definisce ==grafo== $G=(V,E)$
	- $V=$ insieme di **vertici/nodi**
		- in inglese: **node/vertices**
	- $E =$ collezione di **archi** (coppie di vertici) 
		-  in inglese: **edge/arcs**
- Un grafo è:
	- **diretto**
		- ogni arco $(u,v)\in E$ è una coppia ordinata $u \rightarrow v$  
	- **indiretto**
		- ogni arco $(u,v)\in E$ è una coppia non ordinata $u - v$
![[Pasted image 20241127093153.png|600]]
#### nota
- $V$ è un **insieme** (tutti elementi distinti)
- $E$ è una **collezione** (ammette elementi duplicati)
	- archi multipli
- **Self loop**: archi del tipo $(u, u)$
- **Grafo semplice**
	- grafo senza archi multipli e senza self loop
- **Grafo pesato**
	- archi/vertici sono associati a dei pesi
![[Pasted image 20241128090404.png|300]]
### esempi di grafi
- Reti di comunicazione
- Web graph
- Reti sociali
- Reti biologiche
- Chimica
- Reti stradali
- Reti wireless/sensori
<div style="page-break-after: always;"></div>
## grafi semplici e non diretti
### terminologia generale
- Dato $e=(u,v)\in E$, si dice che
	- **arco** $e$ è ==incidente== su $u$ e $v$
	- **vertici** $u,v$ sono ==adiacenti==
- Si definiscono ==vicini== di un vertice $v\in V$:
	- tutti i **vertici adiacenti** a $v$
	- $\{u : \exists e=(v, u)\in E\}$
- Si definisce ==grado== di un vertice $v\in V$
	- $degree(v)=$ numero di archi di $E$ **incidenti** su $v$
![[Pasted image 20241128091451.png|400]]
### definizione di cammino
- Si definisce ==cammino== una **sequenza** $u_{1},u_{2},\dots,u_{k}$ di **vertici** tale che
	- $\exists (u_{i},u_{i+1})\in E, \forall i: 1\leq i <k$ 
	- ogni **vertice** del cammino è **adiacente** al successivo
![[Pasted image 20241128091709.png|200]]
#### lunghezza del cammino
- **Numero** di **archi** $(u_{i},u_{i+1})=k-1$
- Nel caso di archi pesati, **somma** dei **pesi** degli archi $(u_{i},u_{i+1})$
#### cammino semplice
- **Sequenza** $u_{1},u_{2},\dots u_{k}$ di vertici **tutti distinti** tale che
	- $\exists (u_{i},u_{i+1})\in E, \forall i: 1\leq i <k$ 
- Il cammino non ripassa mai sullo stesso nodo
### definizione di ciclo
- Si definisce ==ciclo== una sequenza $u_{1},u_{2},\dots,u_{k}$ tale che 
	- $\exists (u_{i},u_{i+1})\in E, \forall i: 1\leq i <k$ 
	- $u_{k}=u_{1}$
- Cammino che termina nel vertice di partenza
![[Pasted image 20241128091958.png|200]]
#### lunghezza del ciclo
- Corrisponde a quella del rispettivo cammino
#### ciclo semplice
- **Sequenza** $u_{1},u_{2},\dots u_{k}$ di vertici **tutti distinti** tale che
	- $\exists (u_{i},u_{i+1})\in E, \forall i: 1\leq i <k$ 
	- $u_{1}=u_{k}$
- Il ciclo non ripassa mai sullo stesso nodo
### definizione di sottografo
- $G'=(V',E')$ è ==sottografo== di un grafo $G=(V,E)$ se:
	- $V'\subseteq V$
	- $E' \subseteq E$
	- $\forall (u,v)\in E': u,v\in V'$
		- gli archi di $E'$ incidono solo su $V'$
![[Pasted image 20241128092404.png|200]]
#### spanning subgraph (sottografo di compertura)
- Sottografo $G'=(V',E')$ di $G=(V,E)$ tale che $V'=V$
	- includo **tutti** i **nodi** e solo un **sottoinsieme** di **archi**
![[Pasted image 20241128092522.png|200]]
### definizione di grafo connesso e disconnesso
#### grafo connesso
- Un $G=(V,E)$ si dice ==connesso== se:
	- $\forall u, v \in V$ esiste un cammino in $G$ che inizia in $u$ e termina in $v$
![[Pasted image 20241128092624.png|200]]
#### grafo disconnesso
- Un $G=(V,E)$ si dice ==disconnesso== se:
	- $\exists u, v \in V$ dove non esiste un cammino in $G$ che inizia in $u$ e termina in $v$
![[Pasted image 20241128092705.png|200]]

<div style="page-break-after: always;"></div>

### definizione di componenti connesse
- Le ==componenti connesse== di $G=(V,E)$ sono:
	-  una **partizione** di $G$ in **sottografi** $\{G_{1},G_{2}\dots G_{k}\}$, $G_{i}=(V_{i},E_{i})$
	- $G_{i}=(V_{i},E_{i})$ **connesso** $\forall i: 1\leq i \leq k$
	- $V=V_{1}\cup V_{2}\cup\dots\cup V_{k}$
	- $E=E_{1}\cup E_{2}\cup\dots\cup E_{k}$
	- $\forall i≠j$ non esistono archi tra $V_{i}$ e $V_{j}$

>[!info] Osservazione
>- Se $G$ è connesso, $k=1$
>- La partizione di $G$ in componenti connesse è **univoca**
>- $G_{1}\dots G_{k}$ sono sottografi connessi **massimali**

### alberi visti come grafi
#### definizione di albero radicato
- Un ==albero radicato== è un **grafo** $G=(V,E)$ tale che:
	- $\exists r$ vertice **radice**
	- $\forall u\in V, u≠r, \exists \text{! } p(u)\in V \text{ padre di } u$
	- $\forall u\in V$, andando di padre in padre, si raggiunge $r$
#### definizione di albero libero
- Un ==albero libero== è un **grafo** $G=(V,E)$ tale che:
	- **connesso**
	- **senza cicli semplici**
- Corrisponde a un albero radicato dove **non** viene specificata la **radice**
#### definizione di foresta
- Una ==foresta== è un **grafo** $G=(V,E)$ tale che:
	- **senza cicli semplici**
- Insieme di **alberi liberi disgiunti**

![[Pasted image 20241128094051.png|400]]

>[!info] Osservazione
>- Ogni albero radicato è un albero libero 
>- Ogni albero libero è albero radicato se viene specificata la radice

### spanning tree e forest
#### definizione di spanning tree
- Si definisce ==spanning tree== di un grafo $G$:
	- **sottografo** **connesso** e **senza cicli**
	- è quindi un **albero libero**
![[Pasted image 20241128094432.png|200]]
#### definizione di spanning forest
- Si definisce ==spanning forest== di un grafo $G$:
	- sottografo **senza cicli**
	- è quindi una **foresta**
![[Pasted image 20241128094508.png|200]]

>[!info] Osservazione
>- Spanning tree esiste solo per grafi connessi
>- Spanning forest esiste sempre

### primitive importanti
- **Trasversal**
- **Connettività**
- **Identificazione delle componenti connesse**
- **Ricerca dei cammini minimi**
- **Ricerca minimum spanning tree**
- **Stima distanza media/massima**

<div style="page-break-after: always;"></div>

### rappresentazione grafi - strutture dati di base
- Sia $G=(V,E)$ grafo con
	- $n$ vertici (numerati da $1$ a $n$)
	- $m$ archi
- **Lista di vertici** $L_{V}$
	- ogni nodo della lista contiene **vertice** $v\in V$ e eventuali informazioni aggiuntive
- **Lista di archi $L_{E}$
	- ogni nodo della lista contiene **arco** $e=(u,v)\in E$ e eventuali informazioni aggiuntive
	- contiene **puntatori** a $u$ e $v$
![[Pasted image 20241128151120.png|500]]

>[!warning] Criticità
>Non è efficiente perché, dato un nodo, non si può accedere direttamente ai vicini

<div style="page-break-after: always;"></div>

### rappresentazione di grafi - liste di adiacenza
- **Lista di adiacenza**
	- per ogni vertice $v\in V$ si ha una lista $I(v)$ di **puntatori** agli **archi** **incidenti** su $v$
![[Pasted image 20241128151749.png|400]]
#### analisi
- Rappresenta $G$ in **spazio lineare** nella taglia del grafo:
	- $\Theta(n+\sum_{v} degree(v))= \Theta(n+m)$
- Consente accesso sequenziale ai **vicini** di un vertice $v$ in **tempo lineare** al grado di $v$
	- $\Theta(degree(v))$

### rappresentazione di grafi - matrice di adiacenza
- **Matrice di adiacenza** $A$
	- matrice  $n×n$
	- vertici in corrispondenza 1-1 con righe e colonne
![[Pasted image 20241129130136.png|500]]

![[Pasted image 20241128153724.png|400]]
#### analisi
- Richiede rappresentazione **vertici** tramite **interi**
- Matrice è **simmetrica** (nei grafi non diretti)
- Rappresenta $G$ in **spazio superlineare** $\Theta(n^2)$
- Consente accesso in **tempo costante** a ogni arco
- Usato per **grafi densi** (per non avere troppi spazi vuoti)

### implementazione in java
- Librerie **grafi**:
	- JGraphT
	- JUNG
### graph trasversal
- Procedura sistematica per **esplorare** $G$ a partire da un vertice $s$ visitando tutti i vertici
- Approcci:
	- ==breadth-first search== (BFS)
		- visita in larghezza
		- dopo la visita di un vertice si visitano prima tutti i vicini prima di passare ai vicini dei vicini
	- ==depth-first search== (DFS)
		- visita in profondità
		- dopo la visita di un vertice, si visita un vicino, poi il vicino di quel vicino, ecc

>[!info] Osservazioni
>- BFS e DFS costituiscono **design pattern** per risolvere vari problemi
>- Sfruttano liste di adiacenza

### bfs - notazioni e definizioni
- $G=(V,E)$ **grafo** semplice non diretto
- $C_{s} \subseteq G =$ **componente connessa** di $G$ contente $s \in V$
- $d(x,y) =$ **minima lunghezza** di un cammino da $x$ a $y$ con $x,y \in V$
	- $d(x,y)=+\infty$ se $x,y$ sono in **componenti** **connesse** **distinte**
- Ogni vertice $v\in V$ contiene un campo $v.ID$
	-$v.ID=$ {**1** se è stato visitato; **0** se non è stato ancora visitato}
- Ogni arco $e \in E$ contiene un campo $e.label$
	- $e.label=$ {**null** se non è ancora stato visitato, **DISCOVERY EDGE**, **CROSS EDGE**}
### bfs - algoritmo
- **Visita** tutti i **vertici** di $C_{s}$
- **Etichetta** tutti gli **archi** di $C_{s}$
- **Partiziona** i vertici di $C_{s}$ in **livelli** $L_{i}$ in base alla loro distanza $i$ da $s$

>[!info] Info
>- Si assume che prima di invocare BFS tutti i vertici siano non visitati e gli archi non etichettati
#### helper functions
- ```incidentEdges(v)```
	- restituisce iteratore archi adiacenti a $v$ (da lista adiacenza)
- ```opposite(v,e)```
	- restituisce vertice di $e$ opposto a $v$
#### algoritmo - implementazione
![[Pasted image 20241128155215.png|500]]
![[Pasted image 20241128155243.png|500]]
#### analisi complessità
- Considero chiamata ```BFS(G,s)```
- Si definisce:
	- $n_{s}=$ numero vertici in $C_{s}$
	- $m_{s}=$ numero di archi in $C_{s}$
- Ciclo _for_ esterno:
	- eseguito complessivamente $n_{s}$ volte (una per ogni nodo in $C_{s}$)
- Ciclo _for_ interno:
	- eseguito $degree(v)$ volte
- Operazioni all'interno del ciclo _for_ interno
	- complessità $\Theta(1)$
- **Complessità complessiva**:
	- $\Theta(\sum_{v\in C_{s}} degree(v))=\Theta(m_{s})$
- Se $G$ è connesso, ha complessità $\Theta(|E|)$

<div style="page-break-after: always;"></div>

### bfs - applicazioni 
- Dato $G=(V,E)$ con $|V|=n$ e $|E|=m$, i seguenti problemi possono essere risolti in $O(m+n)$
	- testare se $G$ è **connesso**
	- trovare le **componenti connesse** di $G$
	- trovare uno **spanning tree** di $G$ se $G$ è connesso
	- trovar un **cammino minimo** tra 2 vertici $s$ e $t$ se esiste
	- trovare un **ciclo**, se esiste
### bfs - visita di tutto il grafo
- Algoritmo che **visita** tutti i **nodi** del grafo attraverso chiamate a ```BFS```
#### implementazione
![[Pasted image 20241129100205.png|300]]
#### analisi complessità
- Primo ciclo for: enumera i vertici attraverso lista $L_{V}$: $O(n)$
- Secondo ciclo for: esegue $k$ chiamate a ```BFS```
	- ```BFS```: $O(m_{v})$ 
		- $m_{v}=$ numero di archi in $C_{v}$
	- viene eseguita **una sola** chiamata a BFS per ogni componente connessa
- **Totale**: $O(n+\sum_{i=1}^{k}m_{v_{i}})=O(n+m)$

### bfs - connettività
- Algoritmo che salva su ogni vertice l'**id** della componente connessa e restituisce il **numero** di **componenti connesse**
#### modifica di bfs
![[Pasted image 20241129101144.png|500]]
#### implementazione
![[Pasted image 20241129101155.png|250]]
#### analisi complessità
- Primo ciclo for: enumera i vertici attraverso lista $L_{V}$: $O(n)$
- Secondo ciclo for: esegue $k$ chiamate a ```BFS```
	- ```BFS```: $O(m_{v})$ 
		- $m_{v}=$ numero di archi in $C_{v}$
	- viene eseguita **una sola** chiamata a BFS per ogni componente connessa
- **Totale**: $O(n+\sum_{i=1}^{k}m_{v_{i}})=O(n+m)$
### bfs - spanning tree
- Algoritmo che, dato un **grafo connesso**, restituisce uno **spanning tree** costituito dai **vertici** e dai **discovery edge**
#### implementazione
![[Pasted image 20241129183505.png|500]]
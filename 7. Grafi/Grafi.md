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

<div style="page-break-after: always;"></div>

### bfs - cammino minimo
- Algoritmo che, dato $G=(V,E)$ e due vertici $s,t \in V$, restituisce il **cammino** di **lunghezza minima** tra $s$ e $t$ (o null se non esiste)
#### modifica di bfs
![[Pasted image 20241203145442.png|500]]
#### implementazione
- Si esegue ```BFS(G, s)```
- Se il vertice $t$ non viene visitato $\Rightarrow$ non esiste cammino 
	- restituisco null
- Se il vertice $t$ viene visitato $\Rightarrow$ esiste cammino minimo
	- parendo da $t$, si costruisce il cammino risalendo di padre in padre fino a $s$
#### analisi complessità
- Complessità $O(m_{s})$
	- visita tutti i nodi della componente connessa 

### bfs - ciclicità
- Algoritmo che, dato $G=(V,E)$, restituisce un **ciclo** (se esiste) o null
#### modifica bFS
- Quando **arco** $(v,u)$ viene etichettato come _DISCOVERY EDGE_:
	- $u.\text{parent}\leftarrow v$
- Il campo ID del **vertice** viene impostato da:
	- $w.ID \leftarrow i+1$
		- con $i=$ livello

<div style="page-break-after: always;"></div>

#### implementazione
- Eseguo ```BFS```su ogni **componente** **connessa** del grafo
- Si esegue un **ciclo** su tutti gli **archi**
- Non appena trovo un _CROSS EDGE_ $(u, v)$
	- $\exists$ sicuramente un ciclo contenente $(u,v)$
	- se non trovo nessun _CROSS EDGE_ restituisco null
- Calcolo $x\leftarrow$```LCA(u,v)```
	- antenato comune più profondo di $u$, $v$ in ```BFS-Tree``` $T$
	- risalgo in maniera **sincrona** sfruttando i livelli
- Ciclo trovato: $u \rightarrow v \rightarrow x \rightarrow u$ 
#### analisi complessità
- $O(n+m)$
	- viene effettuata la visita di tutto il grafo attraverso ```BFS```
	- viene ricostruita la sequenza di nodi del ciclo
### dfs
- Algoritmo **ricorsivo** che **visita** tutti i **vertici** della **componente connessa** $C_{s}$ ed **etichetta** tutti i **vertici** e **archi** di essa 

>[!info] Info
>- Si assume che nella **prima invocazione** DFS tutti i vertici siano non visitati e gli archi non etichettati
>- In una chiamata successiva di DFS alcuni vertici e archi potrebbero essere già stati etichettati
#### notazioni e definizioni
- Ogni vertice $v\in V$ contiene un campo $v.ID$
	- $v.ID=$ {**1** se è stato visitato; **0** se non è stato ancora visitato}
- Ogni arco $e\in E$ contiene un campo $e.label$
	- $e.label=$```{null, DISCOVERY EDGE, BACK EDGE}```
- $u$ è **discoverable** da $v$
	- $\exists$ cammino da $v$ a $u$ fatto di nodi non ancora visitati
- $G=(V,E)$ **grafo** semplice non diretto
- $C_{s} \subseteq G =$ **componente connessa** di $G$ contente $s \in V$
#### helper functions
- ```incidentEdges(v)```
	- restituisce iteratore archi adiacenti a $v$ (da lista adiacenza)
- ```opposite(v,e)```
	- restituisce vertice di $e$ opposto a $v$
#### implementazione
![[Pasted image 20241203154502.png|380]]
#### analisi complessità
- Considero chiamata ```DFS(G,s)```
- Si definisce:
	- $n_{s}=$ numero vertici in $C_{s}$
	- $m_{s}=$ numero di archi in $C_{s}$
- Considero **albero ricorsione**
	- nodi = invocazioni ```DFS```
		- una invocazione per ogni vertice di $C_{s}$
	- ogni invocazione esegue tante operazioni quante gli archi incidenti su $v$
		- costo: $\Theta(degree(v))$
- Totale complessità:
	- $\Theta(\sum_{v\in C_{s}} degree(v))=\Theta(m_{s})$

>[!info] Osservazione
>- Poiché $C_{s}$ è connesso, $m_{s}\geq n_{s}-1 \Rightarrow m_{s}=\Omega(n_{s})$

<div style="page-break-after: always;"></div>

### dfs - proprietà
- Sia $G=(V,E)$ non ancora visitato, $n=|V|$, $m=|E|$
- Alla fine dell'esecuzione si avrà:
1. Tutti $v\in C_{s}$ sono stati **visitati** e tutti $e \in C_{s}$ sono stati **etichettati** come _DISCOVERY EDGE_ o _BACK EDGE_
2. I _DISCOVERY EDGE_ formano uno **spanning tree** in $T$ di $C_{s}$ radicato in $s$
#### dimostrazione
- Analoga a BFS

### dsf - applicazioni
- Dato $G=(V,E)$ con $|V|=n$ e $|E|=m$, i seguenti problemi possono essere risolti in $O(m+n)$
	- **visitare** tutto il grafo
		- eseguendo ```BFS```per ogni componente connessa
	- testare se $G$ è **connesso** e trovare le **componenti connesse** di $G$
		- attraverso ```BFS(G,v,k)```modifica di ```BFS```
	- trovare uno **spanning tree** di $G$ se $G$ è connesso
		- restituendo spanning subgraph formato dai vertici e _DISCOVERY EDGE_
	- trovare un **cammino** tra 2 vertici $s$ e $t$ se esiste
		- **s-t reachability**
		- **NON** necessariamente cammino minimo
	- trovare un **ciclo**, se esiste
		- usando back edge e risalendo al ```LCA(u,v)```
#### dimostrazione
- Analoga a BFS

<div style="page-break-after: always;"></div>

### definizione di grafo pesato
- Sia $G=(V,E,w)$ un grafo **non diretto** e ==pesato==:
	- $V$: insieme dei vertici
	- $E:$ insieme degli archi
	- $w: E \rightarrow \mathbb{R}$ funzione che associa un peso reale a ciascuna arco
![[Pasted image 20241204084644.png|500]]
### definizione di cammino minimo su grafo pesato
- La ==lunghezza di un cammino== $u_{1},u_{2}\dots u_{k}$ è data dalla somma dei pesi degli archi del cammino:
	- $\sum^{k-1}_{i=1}w(u_{i},u_{i+1})$
- Se $w(e)=1 \,\forall e \in E$, la lunghezza di un cammino è pari al numero di archi
	- definizione per grafi pesati è **generalizzazione** definizione per grafi non pesati
- La ==distanza== $d(u,v)$ tra due vertici $u,v \in V$ è la ==minima lunghezza== di un cammino da $u$ a $v$
	- tale cammino è detto ==cammino minimo==

<div style="page-break-after: always;"></div>

### single-source shortest paths
- Il problema dei ==Single-Source Shortest Paths== (**SSSP**) richiede di determinare **tutte le distanze** tra $s$ e gli altri vertici di $V$ e i relativi **cammini minimi**
	- in $G=(V,E,w)$ grafo semplice non diretto

>[!info] Osservazione
>- Se il grafo non è pesato, basta sfruttare la ```BFS```
>- $G$ **NON** contiene cicli di **peso negativo**
>	- esisterebbero cammini di lunghezza negativa arbitrariamente piccola

### algoritmo di dijkstra per sssp

#### idea
- $G=(V,E,w)$ grafo non diretto e pesato
	- esecuzione algoritmo a partire da **vertice sorgente** $s \in V$
	- obiettivo: calcolo **distanza** e **cammini minimi** di tutti i vertici rispetto a $s$
- ==Cloud==
	- $=\{s\}$ inizialmente
	- insieme di vertici le cui **distanze** e **cammini minimi** da $s$ sono stati **identificati**
- $\forall v \in V$ si mantiene:
	- la **distanza corrente** da $v$ a $s$ relativa a **cammini interni** alla **cloud**
	- il puntatore al **predecessore** nel cammino minimo corrente da $v$ a $s$
- I **vertici esterni** alla **cloud** $\in$ **Priority Queue**
	- in base alla loro **distanza corrente** da $s$
- Ad ogni iterazione:
	- viene aggiunto al **cloud** il **vertice** esterno alla cloud con distanza corrente minima
	- vengono **ricalcolate** le **distanze** correnti

<div style="page-break-after: always;"></div>

#### specifiche
- Si richiede che i **pesi** **non** siano **negativi**
- Per ogni $v \in V$ si utilizzano i campi:
	- ```v.D```: **distanza corrente** da $s$
	- ```v.parent```: **predecessore** di $v$ nel **cammino minimo corrente** da $s$ a $v$
- Non appena aggiungo un nuovo vertice $u$ alla cloud, devo **aggiornare** tutte le distanze minime correnti per ogni vertice esterno $v$ vicino di $u$:
	- verifico se il cammino passante per $u$ è più breve rispetto a quello corrente 
![[Pasted image 20241204094622.png|250]]
- Una **entry** di $Q$ associata a un vertice $v$ ha:
	- **chiave**: $v.D$
	- **valore**: puntatore a oggetto associato a $v$
		- include anche puntatore alla entry 
#### implementazione
![[Pasted image 20241204095332.png|600]]
<div style="page-break-after: always;"></div>

### algoritmo di dijkstra - analisi complessità
- La complessità dipende dall'implementazione scelta per la Priority Queue $Q$
![[Pasted image 20241205154758.png|600]]
#### ottimizzazione
- Implementazione tramite ==Fibonacci Heap== (lista di heap)
	- aggiornamento chiave: $O(1)$ (analisi ammortizzata)
- Complessità algoritmo:
	- $O(m+n \log n)$

<div style="page-break-after: always;"></div>

## grafi semplici e diretti
### terminologia
- **Archi uscenti** da $v$
	- archi $(v,u)$
- **Archi entranti** in $v$
	- archi $(u,v)$
- **Grado uscente** di $v$
	- $outdegree(v)=$ numero archi uscenti da $v$
- **Grado entrante** di $v$
	- $indegree(v)=$ numero archi entranti in $v$
- **Proprietà gradi**:
	- $\sum_{v\in V} outdegree(v)=\sum_{v \in V} indegree(v)=|E|=m$
### definizione di cammino e ciclo
- Analogo a grafi indiretti
- Le sequenze dei vertici attraversati devono rispettare **direzionalità** archi
![[Pasted image 20241211100158.png|200]]

<div style="page-break-after: always;"></div>

### definizione di vertici raggiungibili
- Dato $v \in V$, si definisce ==insieme== di ==vertici raggiungibili== da $v$:
	- $reachable(v)=$ tutti i vertici $u \in V$ tali che $\exists$ cammino da $v$ a $u$
#### esempio
![[Pasted image 20241211100343.png|200]]
```python
reachable(x) = {u, v, w, x, y, z} = V
reachable(z) = {z}.
```

### definizione di grafo trasposto
- Sia $G=(V,E)$ grafo diretto
- Si definisce ==grafo trasposto== di $G$ il grafo che si ottiene invertendo la direzione di ogni arco
	- $G^{T}=(V,E^{T})$ tale che $(u,v) \in E^{T} \Leftrightarrow (v,u)\in E$ 
![[Pasted image 20241211100811.png|400]]

<div style="page-break-after: always;"></div>

### definizione di versione non diretta di un grafo diretto
- Sia $G=(V,E)$ grafo diretto
- Si definisce ==versione non diretta di un grafo diretto== un **grafo non diretto** tale che si ottiene ignorando la direzione di ogni arco $(u,v)\in E$
	- $G^{U}=(V,E\cup E^T)$

![[Pasted image 20241211100954.png|400]]
### definizione di grafo fortemente e debolmente connesso
- Sia $G=(V,E)$ diretto
- $G$ è ==grafo fortemente connesso== se
	- $\forall u,v \in V$, $\exists$ cammino in $G$ che inizia in $u$ e termina in $v$
- $G$ è ==grafo debolmente connesso== se
	- $\forall u,v \in V$, $\exists$ cammino in $G^{U}$ che inizia in $u$ e termina in $v$ $\Leftrightarrow$ $G^{U}$ connesso

### rappresentazione degli archi: liste di adiacenza
- $\forall v \in V$ si può mantenere la **lista di adiacenza**:
	- $out(v)=$ puntatore agli **archi** $(v,u)\in E$ **uscenti** da $v$

![[Pasted image 20241211101558.png|300]]

>[!info] Osservazione
>- Permette di rappresentare $G$ in spazio **lineare** della taglia del grafo: $\Theta(n+m)$
>- Consente l'accesso sequenziale ai vicini di $v$ in tempo **lineare** del grado uscente di $v$
>- Analogamente si può definire anche $in(v)$ come puntatore agli **archi entranti**

### algoritmi su grafi diretti
- Modifiche:
	- ```incidentEdges(v)```:
		- iteratore solo a **archi uscenti** da $v$
		- derivato da lista di adiacenza $out(v)$
	- nelle visite a $e=(u,v)$, ```e.label={DISCOVERY EDGE, ALTRO}```
	- archi _ALTRO_ corrispondono a:
		- _BACK EDGE_ ($v$ è antenato di $u$ in spanning tree)
		- _FORWARD EDGE_ ($v$ è discendente di $u$ in spanning tree)
		- _CROSS EDGE_ 
- L'algoritmo di Dijkstra si applica direttamente ai grafi diretti pesati
### analisi di bfs e dfs
- Considero esecuzione ```BFS(G,s)``` e ```DFS(G,s)``` 
#### reachability
- $R_{s}=$ $reachable(s)=$ insieme dei **vertici raggiungibili** da $s$
- $m_{s}=\sum_{v\in R_{s}}outdegree(v)$
#### analisi complessità
- Complessità $\Theta(m_{s})$ 
#### proprietà
- Al termine dell'esecuzione si ha:
	- tutti i **vertici** di $R_{s}$ e i loro **archi uscenti** sono stati visitati/etichettati
	- ```DISCOVERY EDGE``` formano **spanning tree** $T$ di $R_{s}$ radicato in $s$

<div style="page-break-after: always;"></div>

#### applicazioni
- (_BFS+DFS_) Determinare $R_{s}$
	- complessità $\Theta(m_{s})$
- (_DFS_) Determinare se $G$ è **fortemente connesso**
	- complessità $\Theta(|V|+|E|)$
- (_DFS_) Determinare un **ciclo diretto** in $G$, se esiste
	- $\exists$ ciclo diretto in $G$ $\Leftrightarrow$ $\exists$ arco **back edge** al termine della visita
	- complessità $\Theta(|V|+|E|)$
- (_BFS_) Trovare **distanze** e **cammini minimi** da $s$ a ogni $v \in R_{s}$
	- complessità $\Theta(m_{s})$
### definizione di grafo diretto aciclico (dag)
- Si definisce ==grafo diretto aciclico== (_direct acyclic graph_) un grafo **privo** di **cicli**
![[Pasted image 20241213092444.png|250]]

### ordinamento topologico
- **Ordinamento** dei **vertici** $v_{1}\dots v_{n}$ tale che $\forall (v_{i},v_{j})\in E$, vale $i<j$ in un _DAG_
#### osservazione
- Si ordinano i vertici in modo tale che gli **archi** puntino in una **sola direzione**: uscente dal vertice precedente ed entrante nel vertice successivo

>[!tip] Applicazioni
>- Trovare scheduling insieme di task con dipendenze funzionali
>	- gli archi orientati indicano le dipendenze
>	- prima di eseguire la task di un vertice, devo aver già eseguito tutte le sue dipendenze (che puntano verso quel vertice)

<div style="page-break-after: always;"></div>

### algoritmo per ordinamento topologico
- **Inizializzazione**:
	- $S$ **lista** di **vertici** con $indegree(v)=0$
		- vertici del grafo di cui sono già state risolte tutte le dipendenze
	- $L$ **coda** inizialmente vuota
		- vertici estratti dal grafo secondo ordinamento topologico
- Ad ogni **iterazione**:
	- estrae vertice $v$ da $S$
	- aggiunge $v$ in una coda $L$
	- rimuove tutti gli archi uscenti $(v,u)$ uscenti da $v$
	- se $indegree(u)=0$, inserisco $u$ in $S$
- Alla **fine**:
	- $L$ contiene ordinamento topologico di $V$
#### implementazione
![[Pasted image 20241213093020.png|500]]

<div style="page-break-after: always;"></div>

#### analisi complessità
- Osservazione:
	- ciascun vertice $v\in V$ viene **inserito** ed **estratto** da $S$ una e **una sola** volta
- Inizializzazione $v.indeg$, $\forall v$
	- complessità $O(n+m)$
- Ciclo while:
	- $n$ iterazioni, una per ogni vertice $v$
	- per ogni iterazione:
		- complessità: $O(1+outdegree(v))$
- Complessità totale:
	- $O(n+m+\sum_{v \in V}(1+outdegree(v)))=O(n+m)$
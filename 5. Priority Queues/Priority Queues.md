## priority queues
### definizione di entry
- Si definisce ==entry== una coppia (chiave, valore)
	- **chiave** $\in$ dominio K
	- **valore** $\in$ dominio V
#### interfaccia
![[Pasted image 20241026090639.png|300]]
### definizione di priority queues
- Si definisce ==priority queue== una **collezione di entry**
	- **chiavi** (non necessariamente distinte) rappresentano **priorità**
	- chiavi $\in$ **universo** totalmente **ordinato** $K$
		- **Chiave minima** = **massima priorità**
	- interleaving ingressi/uscite arbitrario
	- ingressi con priorità non ordinate
![[Pasted image 20241025095607.png|500]]
#### interfaccia
![[Pasted image 20241026090842.png|350]]
### applicazioni
- Gestione **liste d'attesa**
- **Scheduling** processi sistema operativo con priorità diverse
- **Simulazione** discreta a eventi
- Estrazione di **Top-k Pattern**
	- es: **Top-key entry**
		- estrazione $k$ entry con chiave maggiore
- **Strutture dati** per algoritmi
<div style="page-break-after: always;"></div>

### albero binario completo
- Si definisce ==albero binario completo== $T$ di altezza $h$ un **albero binario** dove:
	- livello $i$, $\forall i, 0\leq i \leq h-1$
		- ha $2^i$ nodi (massimo numero di nodi possibile)
	- livello $h-1$
		- tutti i **nodi interni** sono a **sx**
		- tutti i **nodi interni** eccetto quello più a dx hanno **2 figli**
		- il **nodo interno** più a **dx** può avere **1** o **2** **figli**
![[Pasted image 20241031153554.png|700]]
### altezza albero binario completo
- Un albero binario completo con $n$ nodi ha **altezza** $\lfloor log_{2}n \rfloor$
<div style="page-break-after: always;"></div>

### definizione di heap
- Si definisce ==min-heap== (o **heap**) un **albero binario completo** in cui:
	- i nodi memorizzano **entry**
	- vale **heap-order property**: $k1\leq \min\{k2,k3\}$
![[Pasted image 20241031154635.png|150]]

>[!info] Info
>- Esiste anche la ```max-heap```dove la disuguaglianza è rovesciata
>- Heap significa _mucchio_

### definizione di nodo last
- Si definisce ==nodo last== in un heap altezza $h$:
	- **nodo** più a **destra** al **livello** $h$
### proprietà heap
- **Radice** contiene entry con chiave **minima**
	- ```min()```$\in O(1)$
- Preso un **cammino** dalla **radice** verso le **foglie**
	- sequenza **non decrescente**
	- $e_{u}$.getKey() $\geq$ $e_{v}$.getKey(), $u$ discendente di $v$
- Se le chiavi sono tutte distinte, la chiave **massima** si trova in una **foglia** dello heap
- Poiché è **albero binario completo**
	- $h=\Theta(\log n)$

<div style="page-break-after: always;"></div>

### realizzazione di un heap tramite array
- Posso mapparlo in maniera ordinata livello per livello
	- approccio efficiente a livello di accesso e di spazio
![[Pasted image 20241031155531.png|600]]

#### level numbering
- **Radice**
	- $P[0]$
- **Figli** di $P[i]$
	- sx: $P[2i+1]$
	- dx: $P[2i+2]$
- **Padre** di $P[i]$
	- $P[\lfloor\frac{i-1}{2}\rfloor]$

>[!info] Osservazione
>- Level numbering ha senso solo per alberi binari completi

### proprietà level numbering
- Dato albero binario completo, $h$ altezza, $P$ array su cui è mappato con level numbering:
1. Nodi livello i: $\forall i, 0\leq i \leq h-1$:
	- $2^i$ nodi 
	- mappati da sx a dx in $P[j], 2^{i}-1\leq j \leq 2(2^{i}-1)$ 
2. Nodi livello $h$:
	- mappati da sx a dx in $P[j], 2^{h}-1\leq j \leq n - 1$
	- nodo **last** in posizione $n-1$
<div style="page-break-after: always;"></div>

### complessità metodi priority queue tramite heap
- ```size()```: $\Theta(1)$
- ```isEmpty()```: $\Theta(1)$
- ```min()```: $\Theta(1)$
- ```insert(k,v)```: $\Theta(\log n)$
	- tramite **up-heap bubbling**
- ```removeMin()```: $\Theta(\log n)$
	- tramite **down-heap bubbling**

>[!info] Osservazione
>Chiavi duplicate sono Ammesse

<div style="page-break-after: always;"></div>

### priority queue in java
- ```PriorityQueue<E>```
	- classe in ```java.util```
- Implementa priority queue tramite heap
- Non contiene coppie chiave-valore ma oggetti di tipo ```E```
	- ```E``` deve implementare interfaccia ```Comparable```
### esempio domande di teoria
![[Pasted image 20241109104220.png|650]]
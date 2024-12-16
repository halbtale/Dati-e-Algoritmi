## ordinamento
### definizione problema di ordinamento
- **Input**:
	- sequenza chiavi da universo ordinato
- **Output**
	- sequenza $S$ ordinata in senso crescente
- **Problema computazionale**:
	- $\mathcal{I}=$ {sequenze $S=S[0]S[1]\dots S[n-1]$ di $n\geq 0$ chiavi da universo ordinato}
	- $\mathcal{S}=$ {sequenze $S$ di $n\geq 0$ chiavi, ordinate in senso crescente} 
	- $\Pi\subset \mathcal{I} \times \mathcal{S}=$ {coppie $(S,\overline{S})$, $S\in \mathcal{I}$, $\overline{S}\in \mathcal{S}$, $\overline{S}$ contiene le stesse chiavi di $S$ con le stesse eventuali ripetizioni}
### algoritmo di ordinamento basato su confronti
- $\forall S$ di input, **ordinamento** **chiavi** determinato esclusivamente da:
	- **confronti** tra **coppie** di **chiavi** $S[i]$ e $S[j]$
#### notazione
- Sequenza $S$ rappresentata attraverso notazione degli array
	- si suppone accesso ad ogni elemento in $O(1)$
### design pattern: devide-and-conquer
- Particolare caso di **ricorsione** composto di **3 fasi**
- ==Divide==:
	- istanze di taglia $n\leq n_{0}$
		- **soluzione diretta** (caso base)
	- istanze di taglia $n>n_{0}$
		- **suddivisione** in istanze di taglia $<n$
- ==Conquer==:
	- **soluzione** delle istanze più **piccole**
- ==Combine==:
	- **combinazione** delle **soluzioni** delle istanze più **piccole** per ottenere la soluzione dell'istanza di taglia $n$

<div style="page-break-after: always;"></div>

### algoritmo merge-sort
- Applica strategia **Divide-and-Conquer**
- **Divide**
	- caso base $n_{0}=1$ (sequenza già ordinata)
	- $S_{1}\leftarrow$ sottosequenza con prima metà di $S$
	- $S_{2}\leftarrow$ sottosequenza con seconda metà di $S$
- **Conquer**
	- ordina ricorsivamente sottosequenze
	- ```Mergesort(S1)``` e ```Mergesort(S2)```
- **Combine**
	- $S \leftarrow$ fusione di $S_{1}$ e $S_{2}$
#### implementazione
![[Pasted image 20241213101255.png|550]]
#### merge
![[Pasted image 20241213101329.png|600]]
![[Pasted image 20241213165443.png|500]]
### analisi complessità merge-sort
#### complessità di merge
- ```Merge(S1,S2,S)``` con $n=|S|=|S_{1}|+|S_{2}|$
- Tre cicli while
	- ad ogni iterazione
		- **costo costante**
		- una chiave viene memorizzata **definitivamente** nella sequenza $S$ di output
	- $n$ iterazioni complessive
- Complessità totale: $\Theta(n)$
#### albero ricorsione merge sort - caso 1
- ```MergeSort(S)```, $|S|=n$
- Caso $n=2^{d},d\geq 0$
	- $d=\log_{2} n$
- **Albero ricorsione:**
	- livello $i\in[0,d]$ ha $2^{i}$ **nodi** 
		- infatti, scendendo di un livello, ho il **doppio** dei nodi del livello precedente
	- istanze di **taglia** $\frac{n}{2^{i}}$
		- infatti, scendendo di un livello, la taglia di ogni nodo viene **dimezzata**
		- costo per merge di tale istanza è $\Theta(\frac{n}{2^i})$
- Complessità totale:
$$\Theta(\sum_{i=0}^{d}2^{i}\frac{n}{2^{i}})=\Theta(\sum_{i=0}^dn)=\Theta(n \cdot d)=\Theta(n \log n)$$
![[Pasted image 20241216125007.png|300]]
#### albero ricorsione merge sort - caso 2
- ```MergeSort(S)```, $|S|=n$
- Caso $2^{d}<n<2^{d+1}, d\geq 0$
	- $d=\Theta(\log n)$
- **Osservazioni**:
	- le foglie **NON** sono tutte allo stesso livello
	- ogni livello ha $2^{i}$ nodi eccetto eventualmente l'ultimo
	- taglie delle istanze **NON** sono tutte uguali per tutti i nodi allo stesso livello
	- $d=\Theta(n)$
![[Pasted image 20241216170823.png|200]]
- **Albero ricorsione**:
	- livello $i \in [0,d]$ ha $2^{i}$ **nodi**
		- istanze di **taglia** $\in[\frac{2^d}{2^i},\frac{2^{d+1}}{2^i}]$
	- livello $d+1$ ha $x\leq n$ **nodi** 
		- istanze di **taglia** $1$
	- costo per un'istanza di taglia $X$ è $\Theta(X)$
- Complessità totale:
$$\Theta((\sum_{i=0}^{d}2^{i}\frac{2^d}{2^i})+{x\cdot 1})=\Theta(n\cdot d)=\Theta(n\log n)$$
#### analisi complessità merge-sort
- La complessità di ```MergeSort(S)```, $|S|=n$ è $\Theta(n \log n)$
#### analisi attraverso relazione di ricorrenza
- La complessità può essere espressa tramite la relazione di ricorrenza:
![[Pasted image 20241216125905.png|400]]
- Attraverso **Master Theorem** si può dimostrare che $t_{ms}(n)=\Theta(n \log n)$
### quicksort
- Applica strategia **Divide-and-Conquer**
- **Divide**
	- caso base: taglia $n\leq 1$ (già ordinato)
	- $p \leftarrow S[n-1]$
		- detto **pivot**
		- ultimo elemento di s
	- si partiziona $S$ in tre sottoinsiemi:
		- $L \leftarrow$ {chiavi $<p$ in $S$}
		- $E \leftarrow$ {chiavi $= p$ in $S$}
		- $G \leftarrow$ {chiavi $>p$ in $S$}
- **Conquer**
	- ordinamento ricorsivo di $L$ e $G$
	- ```QuickSort(L)```e ```QuickSort(G)```
	- N.B. non serve riordinare $E$ perché è già ordinata
- **Combine**
	- $S \leftarrow L◦E◦G$
	- $S$ è il risultato della concatenazione dei tre insiemi
#### implementazione in-place
![[Pasted image 20241216132422.png|600]]
![[Pasted image 20241216132938.png|250]]

>[!info] Osservazioni:
>- L'algoritmo è in-place: richiede $O(1)$ memoria aggiuntiva 
>- ```QuickSortInPlace(S,0,n-1)``` ordina tutta la sequenza
#### algoritmo partition
 - ```Partition(S,a,b)``` **riorganizza** le **chiavi** in $S[a÷b]$ intorno a un **pivot** $p=S[b]$
	 - riposiziona:
		 - chiavi $\leq p$ (prima)
		 - p (in mezzo)
		 - chiavi $\geq p$ (dopo)
	- restituisce $l$ (posizione finale pivot)

![[Pasted image 20241216133223.png|560]]
#### analisi correttezza
- La correttezza di ```QuickSortInPlace```deriva direttamente da quella di ```Partition```
- **Invariante** correttezza di ```Partition(S,a,b)``` (alla fine di ciascuna iterazione while esterno):
	- $S[j]\leq p, \forall j\in[a,l[$
	- $S[j]\geq p, \forall j\in]r,b-1]$
	- $l \leq r+1$
### analisi complessità quicksort
#### complessità partition
- ```Partition(S,a,b)``` 
- Ogni due iterazioni del ciclo **while** esterno:
	- $l$ cresce, $r$ decresce (o entrambi)
- Numero **totale** di **incrementi**/**decrementi** è $|S|=b-a+1$
	- numero di operazioni eseguito è **proporzionale** a incrementi/decrementi di $l$ e $r$
- **Complessità**: $\Theta(b-a+1)$

>[!faq] Perché "2 iterazioni del ciclo esterno?"
>Se $S[l]>p$ e $S[r]<p$, gli elementi vengono scambiati senza incrementare $l$ e $r$. Ciò avverrà solo nella iterazione successiva
#### complessità quicksort
- Chiamata ```QuickSortInPlace(S,0,n-1)```
- **Albero ricorsione**:
	- ad ogni livello **almeno** una chiave viene sistemata **definitivamente** (pivot)
	- livello $i\rightarrow$ somma taglie (```Partition```) $\leq n-i$
		- costo livello: $O(n-i)$
	- $\leq n$ livelli
- **Upper bound**: 
	- $O(\sum_{i=0}^{n-1}n-i)=O(n^2)$
- **Lower bound**:
	- istanza pessima: già ordinata
	- $\Omega(n^2)$
- **Complessità** totale: $\Theta(n^2)$
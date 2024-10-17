## alberi
### cos'è un albero?
- Struttura costituita da:
	- collezione di ==nodi==
	- ==collegamenti== 
		- minimali
		- garantiscono la connessione
		- di tipo **padre-figlio** (padre sopra, figlio sotto)
	- struttura **gerarchica**
- La lista è un caso estremo di albero
### campi applicativi
- **Strutture dati**: mappe, priority queue
- **Esplorazione risorse** in struttura gerarchica: filesystem
- **Sistemi distribuiti** e **reti** di comunicazione
- **Analisi di algoritmi**: es. albero ricorsione
- **Compressione** di dati: codici di Huffman
- **Alberi di decisione**
- **Biologia computazionale**
### definizione di albero
- Un ==albero radicato== $T$ è una **collezione di nodi** che, se non è vuota, soddisfa le seguenti proprietà:
	- $\exists$ un nodo speciale $r \in T$ ($r=$ radice)
	- $\forall v \in T, v ≠ r: \exists!u \in T: u \text{ è padre di } v \text{ è figlio di }u$
	- $\forall v \in T, v≠r,$ risalendo di padre in padre si arriva a $r$
		- ovvero ogni nodo è discendente dalla radice
![[Pasted image 20241017160028.png|400]]
### definizione di antenati
- $x$ è ==antenato== di $y$ se $x=y$ oppure $x$ è antenato del padre di $y$
	- es $u$ antenato di $w$
	- definizione ricorsiva
### definizione di discendenti
- $x$ è ==discendente== di $y$ se $y$ è antenato di $x$
### definizione di nodi interni
- $x$ è ==nodo interno== se ha $\geq 1$ figli
### definizione di nodi esterni
- $x$ è ==nodo esterno== se **NON** ha figli
- Definito anche **nodo foglia**
### sottoalbero
- Si definisce ==sottoalbero== con radice $v$:
	- $T_{v}$ = albero formato da tutti i discendenti di $v$
### albero ordinato
- $T$ è un ==albero ordinato== se per ogni  nodo interno $v \in T$ è definito un ordinamento lineare tra i figli $u_{1}, u_{2}, \dots, u_{k}$
- Esempio:
	- ordinamento da sinistra verso destra
	- $w$ precedente $z$
### definizione ricorsiva di albero
- Un ==albero radicato== $T$ è una collezione di nodi che, se non è vuota, risulta partizionata in questo modo:
	- $T=\{r\} \cup T_{1} \cup T_{2} \cup \dots \cup T_{k}, k\geq 0$
	- $r$ è radice con figli $u_{1}, u_{2}, \dots, u_{k}$
	- $\forall i, 1\leq i \leq k: T_{i}$ albero radicato non vuoto con radice $u_{i}$
- Se $k=0$, $T$ contiene solo $r$
### definizione di profondità
#### definizione
- $depth_{T}(v)=|antenati(v)|-1$
#### definizione ricorsiva
- $depth_T(v)=1+depth_T(padre(v))$

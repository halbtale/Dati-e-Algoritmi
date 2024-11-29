## mappe e dizionari
### definizione generale di mappe/dizionari
- **Collezione di entry** che supporta, come metodi principali:
	- **ricerca**
	- **inserimento**
	- **rimozione**
![[Pasted image 20241108085120.png|600]]
### implementazioni
- **Tabelle Hash**
	- implementare mappe non ordinate
- **Alberi binari di Ricerca/Multi-way Search Tree**
	- implementazione di mappe/dizionari ordinati
### applicazioni
- Database
- Compilatori
- Motori di ricerca
- Conteggio di frequenze di oggetti

<div style="page-break-after: always;"></div>

### definizione di mappa
- Si definisce ==mappa== una **collezione di entry**:
	- con **chiavi distinte** provenienti da un dominio per cui è definito l'operatore **=**
	- supporta metodi **get, put, remove**

>[!info] Osservazioni
>- dominio non necessariamente ordinato
>- può essere vista come **array associativo**: la chiave corrisponde all'indice

### interfaccia mappa
![[Pasted image 20241108090241.png|300]]
- Specifiche metodi:
	-  **get(key)**
		- se $\exists$ (key, x): restituisce x
		- altrimenti: null
	- **put(key, value)**
		- se $\exists$ (key, x): mette value al posto di x e restituisce x
		- altrimenti: inserisce (key, value) e restituisce null
	-  **remove(key)**
		- se $\exists$ (key, x): rimuove entry e restituisce x
		- altrimenti: restituisce null
#### in java.util
- Interfaccia ```Map<K,V>``` e ```Map.Entry<K,V>```
- Classe ```HashMap<K,V>
	- implementazione mappa tramite tabella di hash con separate chaining
- Classe ```TreeMap<K,V>```
	- implementazione mappa tramite Red-Black Tree
### implementazione tramite doubly-linked list
- Lista concatenata dove ogni nodo contiene una entry
#### metodo get
- Cerco una entry con chiave $key$ scorrendo la lista
- Complessità: $\Theta(n)$
#### metodo put
- Devo scorrere la lista per controllare se è già presente una entry con quella $key$ prima di poter inserire il nuovo elemento
- Complessità: $\Theta(n)$
#### metodo remove
- Devo scorrere la lista per rimuovere, se esiste, la entry con chiave $key$
- Complessità: $\Theta(n)$
### tabella di hash
- **Funzione hash** $h$
	- $h: U = \{\text{chiavi}\} \rightarrow [0, N-1]$
- **Bucket array** $A$ di capacità $N$, $N<<|U|$
	- $A[i]$: contiene entry tali che $h(k)=i$
	- presa una chiave $k \in U$, $h(k)$ è l'**indice** dell'array associato alla chiave $k$
- Può succedere che più chiavi vengano mappate allo stesso hash
	- se $h(k)=h(k'), k≠k'\Rightarrow$ avviene una **collisione**
### funzione hash
![[Pasted image 20241109150632.png|500]]
#### obiettivi
- Associa a ogni $k\in U$ un intero su $[0,N-1]$ 
- $h$ deve assomigliare il più possibile a un processo random (**uniform hashing**):               $\forall k≠k'\in U,\,\forall i,j \in [0,N-1]$:
	- $Pr[h(k)=i]=\frac{1}{N}$
		- ciascun hash ha la stessa probabilità
	- $Pr[h(k)=i|h(k')=j]=Pr[h(k)=i]=\frac{1}{N}$
		- ciascun hash è indipendente dall'altro
- $h$ deve essere **veloce** da calcolare
### hash code in java
- Metodo ```hashCode()```
	- restituisce ```int``` che dipende dalla **rappresentazione in memoria dell'oggetto**
	- **NON** è un mapping _puro_ deterministico da $U$ a ```int```
		- hashcode non legato all'oggetto ma dipende dall'esecuzione del programma
- Si può effettuare un overloading per adattarlo al nostro utilizzo
#### hash code per chiavi numeriche
- ```byte, short, char, int``` $\rightarrow$ ```int (cast)```
	- mapping 1-1, no collisioni
- ```float```$k \rightarrow$ ```Float.floatToIntBits(k)```
	- mapping 1-1, no collisioni
- ```long```$k$
	- soluzione banale: _cast_ a int
		- approccio non molto uniforme
		- tutti i long con gli stessi primi 32 bit avrebbero lo stesso hash
	- approccio più uniforme: ```(int) ((k >> 32)+(int k))
		- somma primi 32 con i secondi 32 bit
		-  combina informazione di tutti i bit
- ```double k``` $\rightarrow$ ```Double.doubleToLongBits(k)``` $\rightarrow$ ```int```
	- ```Double.doubleToLongBits```restituisce un ```long```
	- il ```long```deve essere convertito a ```int```come sopra
#### hash code per stringhe di char
- $S=s_{0}s{1}\dots s_{k-1}$
	- stringa di caratteri (a ciascuno corrisponde un valore numerico)
- $h(S)=\sum_{i=0}^{k-1}s$
	- non è un buon hash code
	- stringhe con stessi caratteri in ordine diverso hanno stesso hashcode
- $h(S)=\sum_{i=0}^{k-1}s_{i}\cdot a^{k-1-i}$
	- **polynomial hashcode**
	- dipende anche dall'**ordine**
	- $a=31$ costante usata in Java
- **Cyclic shift**
	- si sommano i singoli caratteri applicando, dopo ogni addizione, un cyclic shift alla somma parziale
![[Pasted image 20241108095013.png|600]]
![[Pasted image 20241109151932.png|600]]
### compression function
#### division method
- $i\rightarrow i \mod{N}$
	- $i=$ intero prodotto da hashcode
	- $N=$ capacità bucket array

>[!tip] Importante
>- Scegliere $N$ primo distante da una potenza di 2
>- Se $N$ non è primo, si rischia che vengano mantenute correlazioni:
>	- $N=2^{p}\Rightarrow i \mod{N}$ equivale a prendere i $p$ bit meno significativi
>	- voglio invece che l'informazione dipenda da **tutti** i bit
#### mad (multiply-add-divide) method
- $i \rightarrow [(ai+b)\mod{p}]\mod{N}$
	- $p>N$, $p$ primo
	- $a,b \in [0,p-1]$ scelti a caso, $a>0$

<div style="page-break-after: always;"></div>

### risoluzione delle collisioni
- **Collisione**: $<k_1,v_1>,<k_2,v_2>$ con $k_1≠k_2$ e $h(k_1)=h(k_2)$
#### separate chaining
- Ogni bucket è visto come una Map più piccola implementata tramite lista
![[Pasted image 20241108095704.png|300]]
### definizione di load factor
- Per una tabella hash, si definisce ==load factor== come:
	- $\lambda=\frac{n}{N}$
		- $n$ = numero entry
		- $N$ = dimensione array associato

>[!info] Osservazione
> - $\lambda$ corrisponde a lunghezza media singolo bucket

### implementazione metodi mappa con tabella hash
#### metodo get
![[Pasted image 20241108100054.png|400]]
#### metodo put
![[Pasted image 20241108100114.png|350]]
#### metodo remove
![[Pasted image 20241108100215.png|350]]
### analisi complessità al caso pessimo tabella hash
- Al **caso pessimo**, la hash function mappa tutte le entry sullo stesso bucket
	- deve scorrere tutta la lista
	- complessità: $\Theta(n)$
### analisi complessità media tabella hash
- Sotto l'ipotesi di hashing uniforme, la ==complessità media== di **get**, **put**, **remove** è:
	- $O(1+\lambda)$
#### dimostrazione
- Il bucket all'indice $h(k)$ contiene $\lambda$ elementi (in media): devo scorrere i $\lambda$ elementi
- Caso **ricerca senza successo** (_chiave non presente_):
	- si media su tutti i possibili valori di $h(k)$ considerati equiprobabili
- Caso **ricerca con successo** (_chiave presente_):
	- media su tutte le chiavi presenti considerate equiprobabili per la ricerca

>[!info] Osservazione
>- Consigliato imporre $\lambda < 0.9$
>- Complessità media metodi tabella hash $\in O(1)$
<div style="page-break-after: always;"></div>

### rehashing
- Si esegue quando $\lambda$ va sopra la soglia prefissata
	- bucket array è troppo piccolo
- Approccio:
	- creazione **nuovo bucket** array di taglia $N'\geq 2N$
	- scelta di una **nuova hash** function $h'$
	- **inserimento** delle **entry** nella nuova tabella hash
- Costo: $\Theta(n)$
	- chiavi distinte

>[!info] Osservazione
>- Crescita esponenziale bucket array ammortizza costo rehashing

<div style="page-break-after: always;"></div>

### teorema su complessità metodi
- Sotto l'ipotesi di hashing uniforme, e $\lambda=1$, la complessità in _alta probabilità_ di get, put, remove è:
	-  $O(\frac{\log n}{\log(\log n)})$
- Per **alta probabilità** si intende:
	- la probabilità che accada è $\geq 1-\frac{1}{n}$
#### dimostrazione
- Analisi problema **balls in bins**
	- $n$ contenitore
	- $n$ palline da assegnare in modo casuale ai contenitori
	- si può dimostrare che il numero massimo di palline in un contenitore è  $O(\frac{\log n}{\log(\log n)})$
### vantaggi e svantaggi tabelle di hash
#### pros
- **Facili** da implementare
- Buone **prestazioni**
- **Non** richiede che le chiavi vengano da un universo **ordinato**
#### cons
- **Complessità** elevata al caso **pessimo**
- **Incertezza** qualità funzione di hash
- Spreco di **spazio** (per mantenere load factor piccolo)
<div style="page-break-after: always;"></div>

## mappa tramite alberi
### definizione di albero binario di ricerca
- Si definisce ==albero binario di ricerca== un **albero binario proprio**
	- nodi **interni** memorizzano entry
	- per ogni nodo interno $v$ con chiave $k$:
		- $k \in$ universo ordinato
		- sottoalbero **sx**: chiavi $<k$
		- sottoalbero **dx**: chiavi $>k$
#### esempio
![[Pasted image 20241114160453.png|350]]
### treesearch
- Parto dal nodo radice e scendo finché non trovo la chiave trovata o arrivo a nodo foglia
#### implementazione
![[Pasted image 20241114160652.png|600]]
#### analisi complessità
- Costo singola chiamata ricorsiva: $\Theta(1)$
- Algoritmo invocato per un cammino $\leq h$
	- esistono istanze in cui il cammino vale $h$ 
- **Complessità complessiva**: $\Theta(h)$
	- si intende $\Theta(h+1)$ che copre il caso $\Theta(h)$
![[Pasted image 20241115085408.png|500]]
>[!warning] Attenzione
>È un albero binario proprio (non completo): $h \in O(n)$

### metodo get mappa attraverso albero binario di ricerca
![[Pasted image 20241115090352.png|400]]
#### analisi complessità
- Complessità: $\Theta(h)$

<div style="page-break-after: always;"></div>

### metodo put mappa attraverso albero binario di ricerca
![[Pasted image 20241115090555.png|550]]
![[Pasted image 20241115090633.png|150]]

#### analisi complessità
- Complessità: $\Theta(h)$

>[!info] Osservazione
>- Ordini di inserimento diversi portano ad alberi binari diversi

<div style="page-break-after: always;"></div>

### metodo remove mappa attraverso albero binario di ricerca
![[Pasted image 20241115093307.png|600]]
#### caso 1: w interno e padre almeno di una foglia
![[Pasted image 20241115093549.png|300]]
- **Procedimento**:
	- cancello $w$ e collego $u$ a $v$
	- funziona sia se $w$ è padre di una o due foglie
	- se $w$ era nodo radice, $u$ diventa nuovo nodo radice
#### caso 2: w interno e padre di due nodi interni
![[Pasted image 20241115094124.png|500]]
- **Procedimento**:
	- prendo sottoalbero sinistro di $w$
	- cerco $k'$, chiave massima $<k$ 
		- la trovo scendendo di figlio dx in figlio dx nel sottoalbero sinistro di $w$
	- prendo $k'$ e la sposto al posto di $w$
	- elimino $y$ (applicando caso 1)
- $y=$ predecessore _interno_ di $w$ nella visita inorder
- $k'=$ predecessore di $k$ nell'ordine crescente delle chiavi
#### analisi complessità
- Complessità singole operazioni:
	- treesearch: $\Theta(h)$
	- caso 1: $\Theta(1)$
	- caso 2: $\Theta(h)$
- Totale complessità: $\Theta(h)$

<div style="page-break-after: always;"></div>

## multi-way search tree
### definizione di multi-way search tree
- Un ==MWS-Tree== $T$ è un **albero ordinato** tale che:
	- ogni nodo **interno** ha $d\geq 2$ **figli**
		- è detto **d-node**
	- ogni nodo interno memorizza $d-1$ entry
		- $(k_{1}, x_{1}),\dots (k_{d-1}, x_{d-1})$
		- $k_{1}<k_{2}<\dots<k_{d-1}$
	- Presa ogni entry $e$ memorizzata in $T_{v_{i}}\,\,\, \forall i: 1\leq i \leq d$ 
		- $k_{k-1} <$ ```e.getKey()``` $< k_{i}$
		- $k_{0}=-\infty$
		- $k_{d}=+\infty$
- Per convenzione le foglie **NON** memorizzano entry
#### esempio: 4-node
![[Pasted image 20241120084755.png|400]]
#### esempio: multi-way search tree
![[Pasted image 20241120085047.png|400]]
<div style="page-break-after: always;"></div>
<div style="page-break-after: always;"></div>

### albero d-ario
- Fissato $d$, **albero** in cui **tutti** i **nodi** interni sono **d-node**
- $n$ entry e $m$ foglie
	- $n=(\text{\# nodi interni})\cdot (d-1)$
	- $m=n+1=(\text{\# nodi interni})\cdot (d-1)+1$
### ricerca in mws
![[Pasted image 20241120092317.png|600]]
<div style="page-break-after: always;"></div>

### metodo geT
![[Pasted image 20241120093745.png|400]]
#### analisi complessità
- Dati
	- $d_{max}=$ numero massimo di figli di un nodo di $T$
	- $h$ = altezza di $T$
- ```MWSearchTree```
	- segue cammino $\leq h$ 
	- per ogni nodo deve scorrere fino a $d_{max}$ entry
- Trovato il nodo corretto, devo scorrere tutte le entry: $O(d_{max})$
- Complessità complessiva: $O(d_{max}\cdot h)$
### definizione di (2,4)-tree
- Si definisce ==(2,4)-Tree== un MWS-Tree tale che:
	- ogni nodo interno è un **d-node** con $2\leq d \leq 4$
	- tutte le foglie hanno la **stessa profondità**
#### esempio
![[Pasted image 20241120094732.png|500]]

<div style="page-break-after: always;"></div>

<div style="page-break-after: always;"></div>

### metodo search/get: complessità
- Complessità generale di un MWSTree è $\Theta(d_{max}\cdot h)$
	- $d_{max}\in \Theta(1)$
	- $h\in \Theta(\log n)$
- Allora, $\Theta(d_{max}\cdot h)=\Theta(\log h)$
### metodo put
![[Pasted image 20241121143959.png|600]]
#### analisi complessità
- Esecuzione ```MWTreeSearch```: $\Theta(\log n)$
- Esecuzione ```split```: $\Theta(\log n)$
- Totale: $\Theta(\log n)$

>[!info] Osservazione
>L'albero cresce in altezza dalla radice

<div style="page-break-after: always;"></div>

### metodo remove
![[Pasted image 20241121155510.png|400]]
#### analisi complessità
- ```MWTreeSearch```: $\Theta(\log n)$
- Chiamate ricorsive a ```Delete```: percorso lungo al più $\Theta(\log n)$
- Complessità totale: $\Theta(\log n)$

>[!info] Osservazione
>L'albero decresce dalla radice

<div style="page-break-after: always;"></div>

## red-black tree
### definizione di red-black tree
- Si definisce ==Red-Black Tree== $T$ un albero binario di ricerca in cui i colori hanno un colore rosso o nero in cui valgono le seguenti proprietà:
	- **Root Property**
		- la radice è nera
	- **External Property**
		- le foglie sono nere
	- **Red Property**
		- i figli di un nodo rosso sono neri
	- **Depth Property**
		- tutte le foglie hanno la stessa _black depth_, ovvero il numero di antenati propri neri
![[Pasted image 20241122093104.png|400]]
>[!info] Osservazione
>A differenza del caso generale, i red-black tree hanno sempre **altezza logaritmica**

<div style="page-break-after: always;"></div>

### corrispondenza (2,4)-tree in red-black tree
![[Pasted image 20241122093200.png|500]]
### proprietà
- Seguono dal mapping con i $(2,4)$-Tree
- Red-Black Tree con $n$ entry ha **altezza** $\Theta(\log n)$
- I metodi **get**, **put**, **remove** hanno complessità $\Theta(\log n)$
- Utilizzati da java per implementare ```TreeMap<k,V>```

<div style="page-break-after: always;"></div>

## dizionario o multimap
### definizione
- Mappe che ammettono la presenza di $>1$ entry con la **stessa** chiave
### implementazione
- Mappa in cui le entry sono $(k, L_{k})$
	- $k$: chiave
	- $L_{k}$: collezione di valori associati alla chiave
		- implementabile con double-linked list o altre strutture dati
### metodi caratterizzanti
- ```get(k)```
	- restituisce **collezione** con tutti i **valori** associati a entry con chiave $k$
- ```put(k, v)```
	- inserisce **sempre** nuova entry $(k, v)$ 
	- non intacca altre entry con chiave $k$
	- no output
- ```delete(k, v)```
	- rimuove una entry $(k, v)$ se tale entry esiste
	- no output
#### analisi complessità
- ```get(k)```
	- $\Theta(h)$
- ```put(k, v)```
	- $\Theta(h)$
- ```remove(k, v)```
	- $\Theta(h+s)$ con $s=|L_{k}|$
	- il termine additivo $s$ tiene conto della ricerca della entry con chiave $k$ nella collezione per rimuoverla

<div style="page-break-after: always;"></div>

### riepilogo complessità
![[Pasted image 20241122094435.png|500]]
### domande di teoria
![[Pasted image 20241122094718.png|600]]
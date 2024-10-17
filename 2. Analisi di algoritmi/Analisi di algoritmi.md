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
<div style="page-break-after: always;"></div>

### analisi complessità attraverso ordini di grandezza
- Algoritmo $A$ con complessità $t_A(n)$
- Si cercano bound più vicini possibili alla complessità vera di $A$ (**tight bound**)
- $f(n)$ più **semplice** possibile
#### limite superiore (upper bound)
- $t_{A(n)}\in O(f(n)) \Leftrightarrow \forall i, t_{A,i} \leq c f(n)$
#### limite inferiore (lower bound)
- $t_{A(n)}\in \Omega(f(n)) \Leftrightarrow \exists i, t_{A,i} \geq cf(n)$
#### terminologia per complessità
- **Logaritmica**: $\Theta(\log_{b} n),b>1$
- **Lineare**: $\Theta(n)$
- **Quadratica**: $\Theta(n^2)$
- **Cubica**: $\Theta(n^3)$
- **Polinomiale**: $\Theta(n^{c}),c>0$
- **Esponenziale**: $\Omega(a^{n}),a>1$
- **Polilogaritmica**: $\Theta((\log n)^{c}),c>0$
<div style="page-break-after: always;"></div>

### regole di buon senso
- Due classi di algoritmi:
	- complessità **polinomiale**
		- efficiente
	- complessità **esponenziale**
		- inefficiente
![[Pasted image 20241010090153.png]]
### esempio: sicurezza in internet
- ==Crittografia a chiave pubblica==
- Due persone vogliono inviare un messaggio $m$
	- Bob: chiave privata $k1$, chiave pubblica $k2$
	- Alice: invia $m$ a Bob cifrato con $k2$
		- $f_{k2}(m)=\overline{m}$
	- Bob: riceve $\overline{m}$ e lo decripta con la chiave privata
		- $f_{k1}(\overline{m})=m$
#### algoritmo rsa (rivest, shamir, adleman)
- $N=p \cdot q$
	- $p,q$ numeri primi grandi
	- $p,q \in \Omega(\sqrt{N})$
- Chiave **pubblica**:
	- $N, e$ ($e < N$, e funzione di $p,q$)
- Chiave **privata**:
	- $N,d$ ($d < N$, $d$ funzione di $p, q$)
- **Messaggio** $m$
	- cifratura: $m \rightarrow m^{e}\mod{N}=\overline{m}=f_{k2}(m)$
	- decifratura: $\overline{m}=\overline{m}^d\mod{N}=m=f_{k1}(\overline{m})=m$
- Per conoscere la chiave privata contenente $d$, devo conoscere $p, d$ da $N$
	- estremamente difficile da ottenere
#### fattorizzazione numeri primi
- Taglia dell'istanza = numero di bit di $N = \lfloor\log_2(N)\rfloor+1=n$
- Algoritmo banale (bruteforce):
![[Pasted image 20241009092029.png|400]]
- Complessità è $\Omega(\sqrt(N))=\Omega(2^{\frac{n}{2}})$
- Esistono anche algoritmi più efficienti ma sempre con complessità esponenziale.
### caveat analisi asintotica: costanti grandi
- Algoritmi $A, B$ che risolvono $\Pi$
- $t_A(n),t_B(n)$ complessità di $A,B$ al caso pessimo
- $t_A(n)\in o(t_B(n))$
	- $A$ è _asintoticamente più efficiente_ di B
	- attenzione: questa relazione potrebbe avvenire solo a partire solo da istanze molto grandi
#### esempio
- $t_A(n)=10^{100}n \in \Omega(n)$
- $t_{B}(n)=n^{2}\in \Omega(n^2)$
- In realtà $t_A(n)<t_{B}(n)$ solo se $n > 10^{100}$

>[!warning] Attenzione ad algoritmi con costanti molto grandi
>- Soluzione: dare una stima delle costanti nel caso siano molto grandi

### caveat analisi asintotica: istanze patologiche
- Eccetto **casi pessimi** molto **improbabili**, l'algoritmo potrebbe essere efficiente
- Soluzioni:
	- 1. restringere dominio delle istanze
	- 2. analisi del caso medio o cambiare probabilisticamente l'esecuzione
<div style="page-break-after: always;"></div>

### analisi della correttezza
#### proprietà di terminazione
- Assicurarsi che i clicli e l'eventuale ricorsione abbia termine
#### soluzione del problema computazionale
- **Approccio generale:**
	- individuare **stato iniziale/finale** algoritmo
	- decomporre A in **segmenti** 
		- per ciascuna porzione definire stati intermedi (==checkpoint==)
	- dimostrare che, a partire dallo stato iniziale, si raggiungono in successione i checkpoint
		- lo **stato finale** dell'ultimo checkpoint deve coincidere con stato finale desiderato
- **Segmenti notevoli:**
	- cicli (for, while, repeat-until)
### analisi di cicli
#### terminologia
- Esecuzione ==ciclo== consiste di $\geq 0$  ==iterazioni== delle istruzioni contenute in esse (**corpo del ciclo**)
![[Pasted image 20241010144310.png|300]]
#### correttezza del ciclo
- Approccio
	- dimostrare che al termine del ciclo vale una certa **proprietà** $L$, che rappresenta uno **stato**
	- si usa ==invariante==
#### definizione di invariante
- **Proprietà** espressa in **funzione** della **variabili** usate nel ciclo
	- descrive lo **stato** in cui si trova l'esecuzione alla **fine** di una generica **iterazione** del ciclo
- **Approccio** per dimostrare che alla fine del ciclo vale proprietà $L$:
	- invariante vale all'**inizio** (prima che il ciclo inizi)
	- invariante vale alla **fine** di ciascuna **iterazione**
		- si utilizza **induzione**
	- invariante vale alla **fine** del **ciclo** $\Rightarrow$ vale $L$

![[Pasted image 20241012144332.png|600]]
### ricorsione
#### definizione di algoritmo ricorsivo
- Algoritmo che **invoca se stesso** su istanze sempre più piccole
- La **soluzione** di una istanza di taglia $n$ è ottenuta:
	- direttamente:
		- se $n \in \{n_{0}, n_{0}+1, ...,n_{0}+k\}$ (casi base)
	- ricorrendo a soluzione di $\geq 1$ istanze di taglia $\lt n$ 
		- se $n > n_{0}+k$
#### albero della ricorsione
- Struttura che permette di analizzare la topologia della ricorsione
	- ==nodo==
		- **invocazione** **ricorsiva** **distinta** fatta durante l'esecuzione dell'algoritmo
	- ==radice== dell'albero 
		- **prima** invocazione
	- i ==figli== di un **nodo** $x$ 
		- **associati** alle invocazioni fatte direttamente da $x$
	- le ==foglie== dell'albero
		- rappresentano i **casi base**
		- non fanno ulteriori chiamate ricorsive
![[Pasted image 20241012104556.png|400]]
#### esecuzione di un algoritmo ricorsivo (in java) - spazi di memoria
- ==STACK==
	- **spazio** destinato a **variabili locali** e **riferimenti** a **oggetti**
	- per ogni **invocazione** viene inserito un ==RA== (**Record di attivazione**)
		- contiene variabili/riferimenti relativi a quella invocazione
	- **RA** eliminato al termine dell'invocazione di un metodo
	- politica LIFO
- ==HEAP==
	- spazio destinato a **memorizzare oggetti**
![[Pasted image 20241012104750.png|500]]

### complessità algoritmi ricorsivi
#### metodo attraverso albero della ricorsione
- Complessità si stima tramite **Albero della Ricorsione**
	- associato all'esecuzione di $A$ su un'istanza $i$ di taglia $n$
	- ==costo== associato ad ogni **nodo**
		- numero di operazioni eseguite (eccetto invocazioni ricorsive)
	- **numero totale operazioni**
		- si somma costo di tutti i nodi
- Ricavare **upper bound** a $t_A(n)$
	- stima per eccesso numero operazioni valida per tutte le istanze $i$ di taglia $n$
- Ricavare **lower bound** a $t_A(n)$
	- stima per tutte le istanze o caso particolare (peggiore)
#### metodo attraverso induzione
- Ipotizzo upper/lower bound e lo provo per induzione (**guess**)
#### metodo attraverso relazioni di ricorrenza
- Utilizzo **Master theorem** per risoluzione delle relazioni di ricorrenza

![[Pasted image 20241012144556.png]]
![[Pasted image 20241012144649.png|700]]
### correttezza algoritmi ricorsivi
- **Approccio** seguito per dimostrare correttezza di $A$ di taglia $n$
	- Correttezza **casi base**
		- $n \in [n_{0}, n_{0}+k]$
	- **Ipotesi induttiva**
		- $A$ risolve correttamente istanze taglia $m\in[n_{0},n]$, $n\geq n_{0}+k$ fissato
	- Si dimostra **correttezza** di $A$ per taglia $n+1$
### domande di teoria
![[Pasted image 20241012105654.png|600]]

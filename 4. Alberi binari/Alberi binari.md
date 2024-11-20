## alberi binari
### arietà
- Per ==arietà== di un albero si intende il **massimo** numero di **figli** di un nodo interno
### definizione di albero binario
- Si definisce ==albero binario== $T$ un albero ordinato in cui:
	- ogni nodo ha $\leq 2$ **figli**
	- ogni nodo radice è etichettato come ==figlio sinistro== (sx) o ==figlio destro== (dx)
		- se c'è solo un figlio, si assume che sia un figlio sx
	- nell'ordinamento, il figlio sinistro viene prima del figlio destro
- Deriva direttamente anche la definizione di **sottoalbero sx** e **sottoalbero dx**
### alberi binari propri
- Si definisce ==albero binario proprio== $T$ un albero binario tale che:
	- ogni nodo interno ha **esattamente 2 figli**
- Definiti anche alberi **pieni** (full)
![[Pasted image 20241024144744.png|400]]
### interfaccia
![[Pasted image 20241025182408.png|400]]
<div style="page-break-after: always;"></div>

### visite alberi binari
- Oltre alla visita preorder e postorder, si definisce anche la ==visita inorder==
- Si visita rispettivamente:
	- $T_1$ (sottoalbero sx)
	- $v$ (padre)
	- $T_2$ (sottoalbero dx)
#### pattern algoritmico
![[Pasted image 20241024153246.png|400]]
>[!info] Osservazione
>La prima chiamata è ```inorder(T.root())```
#### complessità visita inorder
- Stessa analisi di pre-order e post-order
- $\Theta(n+\sum_{u \in T}t_{u})$
	- $n$ numero di nodi
	- $t_{u}$ tempo visita $u$
### definizione di espressione aritmetica in notazione infissa
- Una espressione **fully parenthesized in notazione infissa** è costituita da:
	- una costante o variabile $a$
	- $(E_{1}\text{ Op }E_{2})$ 
		- $E_1,E_2$ espressioni fully parenthesized in notazione infissa
		- $Op$ operatore binario
#### esempio
- $((10+5)*(3-(1/2)))$
<div style="page-break-after: always;"></div>

### parse tree
- ==Parse Tree== $T$ associato a una espressione aritmetica $E$ (contenente solo operatori binari)
	- **albero binario**
		- nodi foglia: contengono costanti/variabili di $E$
		- nodi interni: contengono operatori di $E$
	- se $E=a$
		- $T$ è costituito da un'unica foglia contenente $a$
	- se $E=(E_{1}\text{ Op }E_{2})$
		- radice di $T$ contiene Op
		- sottoalbero sx contiene parsetree di $E_1$, dx di $E_2$

![[Pasted image 20241025193351.png|500]]
>[!info] Osservazioni
>- se ammette **operatori unari**, l'albero non è più proprio
>- utilizzato anche nei compilatori
#### valutazione dell'espressione
- Visita in **postorder**
![[Pasted image 20241026085932.png|450]]
>[!info] Osservazioni
>- Complessità: $\Theta(n)$
>- Chiamata iniziale: ```evalutateExpression(T.root())```
#### generazione dell'espressione
- Visita in **inorder**
![[Pasted image 20241026090126.png|450]]
>[!info] Osservazioni
>- Complessità: $\Theta(n)$
>- Chiamata iniziale: ```infix(T.root())```

### decision tree
- **Machine learning**
	- modelli per apprendere pattern presenti nei dati e fare predizioni
- **Classification (supervised learning)**
	- modello che predica la classe (etichetta) a partire dalle feature (caratteristiche)
- **Decision tree**
	- modelli usati per la classificazione
	- forniscono buona accuratezza
	- sono descrittivi e interpretabili
#### esempio
![[Pasted image 20241025084659.png|400]]
### domande di teoria
![[Pasted image 20241026090403.png|600]]

## introduzione agli algoritmi
### problema computazionale
#### definizione
- Un **problema computazionale** $\Pi$ è un insieme di coppie $(i,s)$ dove:
	- i (**istanza**) appartiene a $I$ (dominio delle istanze) 
	- s (**soluzione**) appartiene a $S$ (dominio delle soluzioni).
- Si richiede che per ogni istanza $i \in I$ esistano ≥ 1 soluzioni $s \in S$ tali che $(i,s)\in \Pi$
- Si osservi che $\Pi \subseteq I \times S$ (prodotto cartesiano)
![[Pasted image 20241002094010.png]]
#### esempio: somma di interi
- Definizione del problema computazionale
	- $I = \{(x,y): x,y \in Z\}$
	- $S=Z$
	- $\Pi = \{((x,y),s):(x,y)\in I, s\in S, s=x+y\}$
- Esempi:
	- $((1,9),10)\in \Pi$
	- $((2,2),5)\notin \Pi$
<div style="page-break-after: always;"></div>
#### esempio: ordinamento di array di interi
- Definizione del problema computazionale
	- $I=\{A:A=\text{array di interi}\}$
	- $S=\{B:B=\text{array ordinato di interi}\}$
	- $\Pi=\{(A,B):A\in I,B\in S, \text{B contiene gli stessi elementi di A}\}$
- Esempi
	- $((5,2,1000,70), (2,5,70,1000))\in \Pi$
	- $((23, 11, 45), (11, 23,45))\in \Pi$
	- $((1,2,3), (1,2,7))\notin \Pi$
#### ordinamento di array di interi (v2)
- Definizione del problema computazionale
	- $I=\{A:A=\text{array di interi}\}$
	- $S=\{P:P=\text{permutazioni}\}$
	- $\Pi=\{(A,P):A\in I,P\in S, \text{P ordina gli interi di A}\}$
- Esempi:
	- $((43,16,16,2),(4,2,3,1))\in \Pi$
	- $((43,16,16,2),(4,3,2,1))\in \Pi$
	- $((43,16,16,2),(1,2,4,3))\notin \Pi$

>[!info] Osservazioni
>- Una soluzione può essere associata a più istanze diverse
>- Un'istanza può avere più soluzioni

### algoritmo e modello di calcolo
#### definizione di algoritmo
- **Procedura computazionale** ben definita
	- transforma un **input** in un **output**
	- esegue sequenza **finita** di **passi elementari**
- Fa riferimento a un **modello di calcolo**
	- astrazione che definisce l'insieme dei passi elementari
#### modello ram (random access machine)
- Input, ouput, dati intermedi, programma: in **memoria**
- **Passi elementari** (operazioni primitive):
	- assegnamento
	- operazione logica
	- operazione aritmetica
	- indicizzazione array
	- restituzione valore da parte di un metodo
#### quando un algoritmo risolve un problema computazionale?
- Algoritmo $A$ risolve $\Pi \subseteq I \times S$ 
	- riceve **input** istanze $i \in I$
	- produce **output** soluzioni $s \in S$
	- dato input $i\in I$ **produce** output $s$ tale che $(i, s) \in \Pi$
	- funzione che mappa ogni istanza in una soluzione di tale istanza
### pseudocodice
- Prevede la struttura:
```
Algoritmo nome_algoritmo (parametri di input)
Input: breve descrizione dell'istanza di input
Output: breve descrizione della soluzione restituita in output

Descrizione dei passi elementari dell'algoritmo tramite di mix di costrutti dei linguaggi di programmazione e di linguaggio naturale
```
<div style="page-break-after: always;"></div>
#### costrutti
- $\leftarrow$ 
	- operazione di ==assegnazione== di un valore ad una variabile
- $A[i]$
	- indicizzazione di array
- **if** (_condizione_) **then** {...} **else** {...}
- **for** _variabile_ $\leftarrow$ _valore iniziale_ **to** valore finale **do** {...}
- **foreach** _elemento di un iteratore_ **do** {...}
- **while** (_condizione_) **do**
- **repeat** {...} **until** (_condizione_)
- **return** _valori_
- _scambia_
	- sequenza di istruzioni elementari ben definita
	- $temp \leftarrow A[i,j]$
	- $A[i,j] \leftarrow A[j,i]$
	- $A[j,i] \leftarrow temp$
#### esempio
![[Pasted image 20241004183728.png|300]]

### taglia di un'istanza
- **Funzione** che **mappa** ogni **istanza** in uno o più valori che forniscono una **misura** della sua **grandezza**
- **Partiziona** universo istanze in sottoinsiemi costituiti da istanze **simili** e **confrontabili**
	- in questo modo l'analisi di algoritmi può essere espresso in maniera parametrica rispetto a essa
- Esempio: dimensione $n$ di un array
	- posso confrontare algoritmi di ordinamento a parità di elementi da ordinare
### strutture dati
#### definizione 
- Una ==struttura dati== è una collezioni di **oggetti** corredata da **metodi** per accedere/modificare la collezione
#### livelli di astrazione
- **Livello logico**:
	- gerarchia di _interfacce_
	- organizzazione logica degli oggetti della collezione
	- relazioni input/output che caratterizza ciascun metodo
	- es: nella pila: ordinamento elementi e metodi di accesso/inserimento
- **Livello fisico**:
	- gerarchia di _classi_
	- layout fisico dei dati
	- implementazione dei metodi tramite degli opportuni algoritmi
	- es: nella pila array e algoritmo utilizzato
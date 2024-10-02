## nozioni di base
### problema computazionale
#### definizione
- Un problema computazionale Π è un insieme di coppie (i,s) dove:
	- i (istanza) appartiene a I (dominio delle istanze) 
	- s (soluzione) appartiene a S (dominio delle soluzioni).
- Si richiede che per ogni istanza i ∈ I esistano ≥ 1 soluzioni s ∈ S tali che (i,s) ∈ Π.
- Si osservi che Π ⊆ I × S (prodotto cartesiano)
![[Pasted image 20241002094010.png]]
#### somma di interi
- Definizione del problema computazionale
	- $I = \{(x,y): x,y \in Z\}$
	- $S=Z$
	- $\Pi = \{((x,y),s):(x,y)\in I, s\in S, s=x+y\}$
- Esempi:
	- $((1,9),10)\in \Pi$
	- $((2,2),5)\notin \Pi$
#### ordinamento di array di interi
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


# Prove Props. 2.10, 2.21, 2.33. Do Project 2.28. Prove Props. 2.18(iii) by induction, and 2.18.1(i, ii).  

> **Prop. 2.10.**  
> The equation $x^2=-1$ has no solution in $\mathbb{Z}$.  

> **Prop. 2.21.**  
> There exists no integer $x$ such that $0<x<1$.  

> **Prop. 2.33.**  
> Let $A \subseteq \mathbb{Z}, A\neq\emptyset$.  Let $b\in\mathbb{Z}$ such that $(\forall a \in A) \space b \leq a$.  Then $A$ has a smallest element.  

> **Project 2.28.**  
> Determine for which natural numbers $k^2-3k\geq 4$. Prove it.  




> **Prop. 2.18(iii).**  
> $\forall k\in\mathbb{N}, \space k^3+5k$ is divisible by 6.

Proof.  
$m$ is divisible by $n$ if there exists an $j\in\mathbb{Z}$ such that $m=jn$.  

$P(k)=k^3+5k$ is divisible by 6.  

Prove $P(1)$.  
$(1)^3+5(1)=1+5=6$.  
$6$ is divisible by $6$, therefore $P(1)$ is true.  

Assume $P(k)$ is true for some $k\in\mathbb{N}$:  
There exists a $n\in\mathbb{Z}$ such that $k^3+5k=6n$  

Prove $P(k+1)$.  
Show there exists a $m\in\mathbb{Z}$ where $(k+1)^3+5(k+1)=6n$.  
We rewrite the left-hand side:  
$(k+1)^3+5(k+1)$
$=k^3+3k^2+3k+1+5k+5$   
$=(k^3+5k)+3k^2+3k+6$  
$=6n+3k^2+3k+6$  
$=6n+3(k^2+k)+6$  

We now prove that $3(k^2+k)$ is divisible by 6.  
Intermediate proposition: If $n\in\mathbb{Z}$ is divisible by $2$, then $3n$ is divisible by $6$.  
Proof.  
If $n\in\mathbb{Z}$ is divisible by $2$, then there exists a $l\in\mathbb{Z}$ where $n=2l$.  
We multiply both sides by $3$ to obtain $3n=6l$, and since this follows the definition of divisibility, $3n$ is divisible by $6$.  
Therefore, $3(k^2+k)$ is divisible by $6$, that is, there exists a $d\in\mathbb{Z}$ where $6d=3(k^2+k)$.  

We now rewrite the left-hand side as:  
$6n+6d+6=6(n+d+1)$

We let $q=(n+d+1)\in\mathbb{Z}$.  
$(k+1)^3+5(k+1)=6q$ where $q\in\mathbb{Z}$, therefore $P(k+1)$ is true.  

Prop 2.18(iii) proved by mathematical induction.  

### Let $n\in\mathbb{N}$ for the following propositions.  

> **Prop 2.18.1(i).**  
> $1+2+3+...+n = n(n+1)/2$  


> **Prop 2.18.1(ii).**  
> $2 \space | \space n(n+1)$  

Proof.  
We can derive this directly from Prop. 2.18.1(i):  
something something


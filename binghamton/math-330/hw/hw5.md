# Prove Props. 2.10, 2.21, 2.33. Do Project 2.28. Prove Props. 2.18(iii) by induction, and 2.18.1(i, ii).  

> **Prop. 2.10.**  
> The equation $x^2=-1$ has no solution in $\mathbb{Z}$.  

Proof.  
Let $m\in\mathbb{Z}$.  
The proposition can be rewritten as:  
There does not exist any $m$ where $m^2=-1$.  

Assume there *does* exist a $m\in\mathbb{Z}$ where $m^2=-1$.  

**Proposition 2.9** states that if $m\neq0$, then $m^2\in\mathbb{N}$.  
We know $m\neq0$ because for any $n\in\mathbb{Z}$, $n\cdot 0=0$, and $0\neq -1$, therefore $m\neq0$.    
Therefore, proposition 2.9 implies that $-1\in\mathbb{N}$.  

However, we know $-1\notin\mathbb{N}$.  
Proof.  
By **proposition 2.3**, we know $1\in\mathbb{N}$.  
$1\in\mathbb{N}$ and $-1\in\mathbb{N}$ cannot *both* be true, since **proposition 2.2** states for $m\in\mathbb{Z}$, only one of the following is true: $m\in\mathbb{N}, -m\in\mathbb{N}, m=0$.  
Therefore, $-1\notin\mathbb{N}$.  

By contradiction, there cannot exist a $m\in\mathbb{Z}$ where $m^2=-1$.  

> **Prop. 2.21.**  
> There exists no integer $x$ such that $0<x<1$.  

Proof.  
Let $k\in\mathbb{Z}$.  
Assume there *does* exist an $k$ where $0<k<1$.  
We rewrite the assumption as follows:  
There exists an $k$ where $0<k$ and $k<1$  
$\Rightarrow$ There exists an $k$ where $(k-0)\in\mathbb{N}$ and $(1-k)\in\mathbb{N}$  
$\Rightarrow$ There exists an $k$ where $k\in\mathbb{N}$ and $(1-k)\in\mathbb{N}$.  

Let $A$ be the assumption (for which we will be proving by contradiction):  
There exists an $k$ where $k\in\mathbb{N}$ and $(1-k)\in\mathbb{N}$.  

In order to prove assumption $A$ is false, we can prove that there is *no* $k\in\mathbb{N}$ where $(1-k)\in\mathbb{N}$.  
For this, we use induction - let $P(n)$ be the statement:  
$(1-n)\notin\mathbb{N}$.  

Prove $P(1)$.  
- $(1-1)\notin\mathbb{N}$
- $0\notin\mathbb{N}$

$0\notin\mathbb{N}$ is true, by Axiom 2.1(iii).  

Induction step.  
We assume $P(n)$ is true:  
$(1-k)\notin\mathbb{N}$.  

Prove $P(n+1)$.  
- $(1-(n+1))\notin\mathbb{N}$
- $(1-n-1)\notin\mathbb{N}$
- $(-n)\notin\mathbb{N}$

$(-n)\notin\mathbb{N}$ is true, because $n\in\mathbb{N}$ by the induction axiom, and by **proposition 2.2**, if $n\in\mathbb{N}$, then $(-n)\notin\mathbb{N}$.  

Therefore, since for all $k\in\mathbb{N}$, $(1-k)\notin\mathbb{N}$, and since the contrapositive of a true statement holds, there exists no $k\in\mathbb{N}$ where $(1-k)\in\mathbb{N}$.  

Therefore, assumption $A$ is false by contradiction. That is, there *does not* exist a $k$ where $k\in\mathbb{N}$ and $(1-k)\in\mathbb{N}$, so there cannot be an $x\in\mathbb{Z}$ where $0<x<1$.  

> **Prop. 2.33.**  
> Let $A \subseteq \mathbb{Z}, A\neq\emptyset$. Let $b\in\mathbb{Z}$ such that $(\forall a \in A) \space b \leq a$.  Then $A$ has a smallest element.  

The well-ordering principle states that every non-empty subset of $\mathbb{N}$ has a smallest element.  
uh...  
`UNFINISHED`

> **Project 2.28.**  
> Determine for which natural numbers $k^2-3k\geq 4$. Prove it.  

Reduce the original expression:  
$k(k-3)\geq 4$  
`UNFINISHED`

> **Prop. 2.18(iii).**  
> $\forall k\in\mathbb{N}, \space k^3+5k$ is divisible by 6.

Proof.  
$m$ is divisible by $n$ if there exists a $j\in\mathbb{Z}$ such that $m=jn$.  

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
> $\sum_{i=1}^{n} i = \frac{n(n+1)}{2}$  

Proof.  
Let $P(n)$ be the statement:  
$\sum_{i=1}^{n} i = \frac{n(n+1)}{2}$  

Prove $P(1)$.  
- $\sum_{i=1}^{1} i = \frac{1(1+1)}{2}$  
- $1 = \frac{1(2)}{2}$  
- $1=1$  

Therefore $P(1)$ is true.  

Induction step.  
Assume $P(n)$ is true.  

Prove $P(n+1)$.  
- $\sum_{i=1}^{n+1} i = \frac{(n+1)((n+1)+1)}{2}$  
- $\sum_{i=1}^{n} i + (n+1) = \frac{(n+1)(n+2)}{2}$  
- $\frac{n(n+1)}{2} + (n+1) = \frac{(n+1)(n+2)}{2}$  
- $n(n+1) + 2(n+1) = (n+1)(n+2)$  
- $n^2+n + 2n+2 = n^2+2n+n+2$  
- $n^2+3n+2 = n^2+3n+2$  

Therefore $P(n+1)$ is true.  

$\sum_{i=1}^{n} i = \frac{n(n+1)}{2}$ by mathematical induction.  

> **Prop 2.18.1(ii).**  
> $2 \space | \space n(n+1)$  

Proof.  
We rewrite the proposition:  
There exists $z\in\mathbb{Z}$ where $n(n+1)=2z$

By **proposition 2.18.1(i)**, $\frac{n(n+1)}{2}\in\mathbb{N}$ because the sum of natural numbers is in $\mathbb{N}$.   
If we let $z=\frac{n(n+1)}{2}$, then multiplying both sides by $2$ results in $2z=n(n+1)$.  
Since there exists a $z\in\mathbb{Z}$ where $n(n+1)=2z$, $n(n+1)$ is divisible by 2.  
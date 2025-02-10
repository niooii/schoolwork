# Homework 3: Props 2.3, 2.5, 2.6, 2.8
> **Prop. 2.3.**  
> $1\in\mathbb{N}$

Proof.  
Assume $1\notin\mathbb{N}$. By prop. 2.2, and the fact that $1\neq 0$, we know $-1\in\mathbb{N}$.  
According Axiom 2.1(ii), $1\in\mathbb{N}$, because $(-1)(-1)=1$.  
This forms a contradiction with our assumption that $1 \notin \mathbb{N}$.  
Therefore, $1\in\mathbb{N}$, because $1\neq 0$ and $-1 \notin \mathbb{N}$.

> **Prop. 2.5.**  
> For each $n\in\mathbb{N}$ there exists $m\in\mathbb{N}$ such that $m\gt n$

Proof.  
From the definition of $m>n$, we know $m-n\in\mathbb{N}$, or $m+(-n)\in\mathbb{N}$.  
UNFINISHED

> **Prop. 2.6.**  
> $(m,n\in\mathbb{Z})\space m\leq n\leq m \Rightarrow m=n$

Proof.  
Assume $m\neq n$.
From the definition of $m\leq n$, we know $m<n$ or $m=n$, but $m=n$ has been assumed false.  
We know $n-m\in\mathbb{N}$, by definition of $m<n$.
From $m\leq n \leq m$, we know:  
$n-m\in\mathbb{N}$  
and  
$m-n\in\mathbb{N}$  
By Axiom 2.1(i),  
$(n-m)+(m-n)\in\mathbb{N}$  
$(n-n)+(-m+n)\in\mathbb{N}$  
$0+0\in\mathbb{N}$  
Finally, $0\in\mathbb{N}$.  
However, by Axiom 2.1(iii), $0\notin\mathbb{N}$.  
Assuming the law of excluded middle, by contradiction, $m=n$.

> **Prop. 2.8.**  
> $(m,n\in\mathbb{Z})$ Exactly one of the following is true: $m<n$, $m=n$, $m>n$

Proof.  
First prove $m<n$ and $m>n$ cannot both be true.  
UNFINISHED


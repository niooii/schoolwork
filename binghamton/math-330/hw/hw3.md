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
From $m\leq n \leq m$, we know $n-m\in\mathbb{N}$ and $m-n\in\mathbb{N}$  
By Axiom 2.1(i),  
$(n-m)+(m-n)\in\mathbb{N}$  
$\Rightarrow(n-n)+(-m+n)\in\mathbb{N}$  
$\Rightarrow0+0\in\mathbb{N}$  
$\Rightarrow0\in\mathbb{N}$.  
However, by Axiom 2.1(iii), $0\notin\mathbb{N}$.  
By contradiction, $m=n$.

> **Prop. 2.8.**  
> $(m,n\in\mathbb{Z})$ Exactly one of the following is true: $m<n$, $m=n$, $m>n$

Proof.  
Prop. 2.2. states that for $m\in\mathbb{Z}$, one and only one of the following is true:  
$$m\in\mathbb{N}, \space m=0, \space-m\in\mathbb{N}$$  
Note the implications of the following relationships:  
- $m<n\Rightarrow (n-m)\in\mathbb{N}$
- $m=n\Rightarrow (n-m)=0$
- $m>n\Rightarrow (m-n)\in\mathbb{N}$, or rewritten, $-(n-m)\in\mathbb{N}$

Now, let $k=(n-m)$. We can rewrite the relationships as follows:  
- $m<n\Rightarrow k\in\mathbb{N}$
- $m=n\Rightarrow k=0$
- $m>n\Rightarrow -k\in\mathbb{N}$

Since proposition 2.2 states one and only one of $m\in\mathbb{N}, \space m=0, \space-m\in\mathbb{N}$ is true,  
then one and only one of the original relationships must be true.  


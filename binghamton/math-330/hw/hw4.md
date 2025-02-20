# Prove Prop. 2.18(ii) by induction. (F 2/14)

> **Prop. 2.18(ii).**  
> $\forall k\in\mathbb{N}, \space k^4-6k^3+11k^2-6k$ is divisible by $4$.

Proof.  
Definition of divisibility:  
$m$ is divisible by $n$ if there exists a $j\in\mathbb{Z}$ such that $m=jn$.  

Let $P(k)$ be the statement: There exists a $z\in\mathbb{Z}$ such that $k^4-6k^3+11k^2-6k=4z$.  

Prove $P(1)$.  
$1^4-6(1)^3+11(1)^2-6(1)=4z$.  
The left-hand side can be rewritten as:  
$1-6+11-6=0$  
To obtain:  
$0=4z$.  We can set $z=0$, therefore $P(1)$ is true.  

Induction step:  
Assume $P(k)$ is true:  
$k^4-6k^3+11k^2-6k=4z$, where $z\in\mathbb{Z}$.  

Prove $P(k+1)$.  
Prove there exists a $m\in\mathbb{Z}$ such that $(k+1)^4-6(k+1)^3+11(k+1)^2-6(k+1)=4m$.  
$(k+1)^4=k^4+4k^3+6k^2+4k+1$
$(k+1)^3=k^3+3k^2+3k+1$
$(k+1)^2=k^2+2k+1$

The left-hand side can be rewritten as:  
$$(k^4+4k^3+6k^2+4k+1)-6(k^3+3k^2+3k+1)+11(k^2+2k+1)-6(k+1) \newline 
= k^4+4k^3+6k^2+4k+1-6k^3-18k^2-18k-6+11k^2+22k+11-6k-6 \newline
= k^4-2k^3-k^2+2k \newline
= (k^4-2k^3-k^2+2k)+(4z-(k^4-6k^3+11k^2-6k)) \newline
= (k^4-2k^3-k^2+2k)-(k^4-6k^3+11k^2-6k)+4z \newline
= 4k^3-12k^2+8k+4z \newline
= 4(k^3-3k^2+2k+z)$$  

We can set $l=(k^3-3k^2+2k+z) \in \mathbb{Z}$, therefore $P(k)$ is true by mathematical induction.
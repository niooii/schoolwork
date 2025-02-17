# Prove Prop. 2.18(ii) by induction. (F 2/14)

> **Prop. 2.18(ii).**  
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
We rewrite the left hand side:  
$(k+1)^3+5(k+1)$
$=k^3+3k^2+3k+1+5k+5$   
$=(k^3+5k)+3k^2+3k+6$  
$=6n+3k^2+3k+6$  
$=6n+3(k^2+k)+6$  

TODO:  prove that if $k^2+k$ is divisible by $2$, then $3(k^2+k)$ is divisible by $6$.  
Then the entire expression is divisible by $6$.
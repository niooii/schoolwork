# Homework 2: Props 1.12-14, 1.24, 1.25(i), 1.26

> **Prop. 1.12**  
> $(x\in \mathbb{Z})\space (m \in \mathbb{Z})\space m+x=m \Rightarrow x=0$

Proof.  
Let $x\in \mathbb{Z}$, $m\in \mathbb{Z}$.  
- $(m+x)+(-m)=m+(-m)$, by adding the additive inverse (-m) to both sides
- $(m+(-m))+x=m+(-m)$, by Axiom 1.1(ii)
- $0+x=0$, by Axiom 1.4.
- Finally, $x=0$, by Prop. 1.7. 

> **Prop. 1.13.**  
> $(x\in \mathbb{Z})\space(\exists m\in \mathbb{Z})$ *such that* $m+x=m \Rightarrow x=0$.

Proof.  
Let $x\in \mathbb{Z}$, $m=0$.  
We know $(0\in \mathbb{Z})$ by Axiom 1.2.  
- $0+x=0$, by substitution
- Finally, $x=0$, by Prop. 1.7.  

> **Prop. 1.14**  
> $(\forall m\in \mathbb{Z}) \space m\cdot 0=0=0\cdot m$

Proof.  
- $m=m$
- $m\cdot0=m\cdot 0$, by multiplying both sides by $0$.

We know $0+0=0$, from Prop. 1.7.  
- $m\cdot(0+0)=m\cdot 0$, by substitution
- $m\cdot 0 + m\cdot 0=m\cdot 0$, by Axiom 1.1(iii)

We know $(m\cdot 0)\in \mathbb{Z}$, due to the closure property of binary operations.
We know the additive inverse $-(m\cdot 0)\in \mathbb{Z}$, by Axiom 1.4.
- $(m\cdot 0+m\cdot 0)+(-(m\cdot 0))=m\cdot 0+(-(m\cdot 0))$, by adding $-(m\cdot 0)$ to both sides
- $m\cdot 0+(m\cdot 0+(-(m\cdot 0)))=m\cdot 0+(-(m\cdot 0))$, by Axiom 1.1(ii)
- $m\cdot 0+0=0$, by Axiom 1.4
- Finally, $m\cdot 0=0$ by Axiom 1.2.  

$m\cdot 0=0\cdot m$, by Axiom 1.1(iv)  
$\therefore m\cdot 0=0=0\cdot m$ by transitivity.  

> **Prop. 1.24**  
> $(x\in\mathbb{Z})\space x\cdot x=x \Rightarrow x=1 \lor x=0$

Proof.  
Prove $x=1$ is a solution.  
- $1\cdot1=1$, by substitution
- Finally, $1=1$, by Axiom 1.3

Prove $x=0$ is a solution.
- $0\cdot0=0$, by substitution
- Finally, $0=0$, by Prop. 1.4.

$\therefore 0$ and $1$ are both *solutions* to $x\cdot x=x$.

> **Prop. 1.25 (i)**  
> $\forall m,n\in\mathbb{Z},\space -(m+n)=(-m)+(-n)$ 

Proof.  

> **Prop. 1.26**  
> $(m,n\in\mathbb{Z})\space mn=0 \Rightarrow m=0 \lor n=0$

Proof.  
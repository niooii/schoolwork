# Homework 1: Prove props 1.7, 1.10

> **Prop 1.7.**
> $m \in \mathbb{Z} \Rightarrow (0 + m = m) \land (1 * m = m)$.

Proof.
Let $m \in \mathbb{Z}$.

Prove $(0+m=m)$:
- $0+m=m+0$, by axiom 1.1(i)
- $m+0=m$, by axiom 1.2

$\therefore 0+m=m$.

Prove $(1*m=m)$:
- $1*m=m*1$, by axiom 1.1(iv)
- $m*1=m$, by axiom 1.3

$\therefore 1*m=m$

> **Prop 1.10.**
> $\forall m, x_1, x_2 \in \mathbb{Z} : (m + x_1 = 0) \land (m + x_2 = 0) \Rightarrow x_1 = x_2$

Proof.
Let $m,x_1,x_2 \in \mathbb{Z}$.
Assume $(m+x_1=0)$ and $(m+x_2=0)$
$\exists (-m) \in \mathbb{Z}$, by axiom 1.4.

For the first eq $(m+x_1=0)$:
- $(m+x_1)+(-m)=0+(-m)$, by adding $-m$ to both sides
- $(m+(-m))+x_1=-m$, by axiom 1.1(ii) on the left and prop. 1.7 on the right
- $0+x_1=-m$, by axiom 1.4
- $x_1=-m$, by prop. 1.7

For the second eq $(m+x_2=0)$, following the same reudction steps:
- $(m+x_2)+(-m)=0+(-m)$
- $(m+(-m))+x_2=-m$
- $0+x_2=-m$
- $x_2=-m$

Since $x_1=-m$ and $x_2=-m$, by transitivity, $x_1=x_2$
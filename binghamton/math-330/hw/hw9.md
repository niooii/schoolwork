# Homework 9 
Prove props. 4.7(i), 4.13, 4.16(ii), 4.22. Do projects 4.12, 4.23, 4.26, 6.7(i). (M 3/31)   

## Proposition 4.7(i)  
$(\forall k\in \mathbb{N}) \text{ } 5^{2k}-1 \text{ is divisble by } 24$  

**Proof.**  
Let $P(k)$ be the statement $5^{2k}-1 \text{ | } 24$, where $k\in\mathbb{N}$  
Prove the base case, $P(1)$:  
$5^{2} - 1 \text{ | } 24 \iff \exists j\in\mathbb{Z}$ where $5^2-1=24j$.  
$5^2-1=24j$  
$24=24j$.  
We set $j=1$, therefore $j$ exists.  
$\therefore P(1)$ is true.  

Now prove $P(k) \implies P(k+1)$.  
Assume $P(k)$.  $P(k) \iff \exists m\in\mathbb{Z}$ where $5^{2k}-1=24m$  
Prove $P(k+1)$ assuming $P(k)$.  
$P(k+1)$ says that there exists an $n\in\mathbb{Z}$ where $5^{2(k+1)}-1=24n$.  
$24n=5^{2k+2} - 1 = 5^{2k}\cdot5^2 - 1=5^{2k}\cdot5^2 - 5^{2k} + 5^{2k} - 1$  
$=5^{2k}(5^2 - 1) + (5^{2k} - 1)=5^{2k}\cdot24+24m=24(5^{2k}+m)$  
We've shown that the equation can be written as:  
$24n=24(5^{2k}+m)$, where $m\in\mathbb{Z}$  
We can let $n=(5^{2k}+m)$, therefore $n$ exists and we know $n\in\mathbb{Z}$.  
$\therefore P(k)\implies P(k+1)$.  
Proved by mathematical induction.  
**QED.**  

## Proposition 4.13    
$\text{For } x \neq 1 \text{ and } k \in \mathbb{Z}_{\geq 0}, \sum_{j=0}^k x^j = \frac{1-x^{k+1}}{1-x}$  

**Proof.**  
We can write the sum as $S=\sum_{j=0}^k x^j=1+x+x^2+...+x^k$. Then, multiply $S$ by $(1-x)$:  
$(1-x)S=(1-x)(1+x+x^2+...+x^k)$.  We can do this because since $x\neq1$, we will not be multiplying $S$ by $0$.  
Distributing on the right side:  
$(1-x)S=(1+x+x^2+...+x^k)-x(1+x+x^2+...+x^k)$  
$=(1+x+x^2+...+x^k)-(x+x^2+x^3+...+x^{k+1})$  
$=(1+x+x^2+...+x^k)+(-x-x^2-x^3-...-x^{k+1})$  
$=(1-x^{k+1})$.  
Dividing both sides of $(1-x)S=1-x^{k+1}$, we obtain $S=\frac{1-x^{k+1}}{1-x}$.  
**QED.**  
*This was probably supposed to be by induction, but I like this proof a lot.*  

## Proposition 4.16(ii)   
$\text{ Let } (x_j)_{j=1}^{\infty} \text{ and } (y_j)_{j=1}^{\infty} \text{ be sequences in } \mathbb{Z}, \text{ and let } a,b,c \in \mathbb{Z} \text{ such that } a < b < c. \text{ Then, } \sum_{j=a}^{b} (x_j + y_j) = \left( \sum_{j=a}^{b} x_j \right) + \left( \sum_{j=a}^{b} y_j \right)$

**Proof.**  
We can express the sum $\sum_{j=a}^{b} (x_j + y_j)=(x_a + y_a)+(x_{a+1} + y_{a+1})+...+(x_b + y_b)$  
$=x_a + y_a+x_{a+1} + y_{a+1}+...+x_b + y_b = x_a + x_{a+1} + ... + x_b + y_a + y_{a+1}+...+ y_b$  
$= (x_a + x_{a+1} + ... + x_b) + (y_a + y_{a+1}+...+ y_b)=(\sum_{j=a}^{b} x_j) + (\sum_{j=a}^{b} y_j)$  
**QED.**  

## Corollary 4.22
$\text{For } k \in \mathbb{Z}_{\geq 0}, \sum_{m=0}^{k} \binom{k}{m} = 2^k$  

**Proof.**  
We know $(a+b)^k=\sum_{m=0}^{k}\binom{k}{m}a^mb^{k-m}$, by proposition 4.21.  
Let $a=1$ and $b=1$.   
$(1+1)^k=\sum_{m=0}^{k}\binom{k}{m}1^m1^{k-m}$  

### Intermediate proposition  
$(\forall n\in\mathbb{N}) \text{ } 1^n=1$  
**Proof.**  

**QED.**

$2^k=\sum_{m=0}^{k}\binom{k}{m}1^m1^{k-m}$  

## Project 4.12  
$\text{(i)} \sum_{j=1}^{k} j = \frac{k(k+1)}{2}$  
$\text{(ii)} \sum_{j=1}^{k} j^2 = \frac{k(k+1)(2k+1)}{6}$  

Find (and prove) a formula for $\sum_{j=1}^{k}j^3$, where $k\in\mathbb{N}$.  



## Project 4.23 — Leibniz's formula
Consider an operation denoted by $'$ that is applied to symbols such as $u, v, w$. Assume that the operation $'$ satisfies the following axioms:  

$(u+v)' = u' + v'$,  
$(uv)' = uv' + u'v$,  
$(cu)' = cu'$, where $c$ is a constant.  

Define $w^{(k)}$ recursively by  

(i) $w^{(0)} := w$.  

(ii) Assuming $w^{(n)}$ defined (where $n \in \mathbb{Z}_{\geq 0}$), define $w^{(n+1)} := (w^{(n)})'$.  

Prove:  
$(uv)^{(k)} = \sum_{m=0}^{k} \binom{k}{m} u^{(m)} v^{(k-m)}$.  



## Project 4.26  
A sequence $(x_j)_{j=0}^{\infty}$ satisfies $x_1 = 1$ and for all $m \geq n \geq 0$, $x_{m+n} + x_{m-n} = \frac{1}{2}(x_{2m} + x_{2n})$.  

Find a formula for $x_j$. Prove that your formula is correct.  



## Project 6.7(i)  

Determine whether the following relation defined on $\mathbb{Z}$ is an equivalence relation. If it is, determine the equivalence classes.  

$x \sim y \text{ if } x < y.$  

This is not an equivalence relation, as the relation is not *reflexive* — $x\nless x$.  


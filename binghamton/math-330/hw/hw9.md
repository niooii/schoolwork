# Homework 9 
Prove props. 4.7(i), 4.13, 4.16(ii), 4.22. Do projects 4.12, 4.23, 4.26, 6.7(i). (M 3/31)   

## Proposition 4.7(i)  
$(\forall k\in \mathbb{N}) \text{ } 5^{2k}-1 \text{ is divisble by } 24$  

**Proof.**  

Proof by induction on $k\in\mathbb{N}$.  
Let $P(k)$ be the statement $5^{2k}-1 \text{ | } 24$    

Prove the base case, $P(1)$:  
$5^{2} - 1 \text{ | } 24 \iff \exists j\in\mathbb{Z}$ where $5^2-1=24j$.  
$5^2-1=24j$  
$24=24j$.  
We set $j=1$, therefore $j$ exists.  

Now prove $P(k) \implies P(k+1)$.  
Assume $P(k)$, that is, there exists an $m\in\mathbb{Z}$ where $5^{2k}-1=24m$  
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

### Intermediate proposition (i)
$(\forall n\in\mathbb{N}) \text{ } 1^n=1$  
**Proof (in case it isn't evident).**  
Let $P(k)$ be the statement $1^k=1$.  
Prove the base case, $P(1)$.  
$1^1=1^0\cdot 1$, by definition.  
$1^1=1\cdot 1$, since we know $1^0=1$ by definition.  
$1^1=1$.    
Prove $P(k)\implies P(k+1)$.  
Assume $P(k)$ is true, $1^k=1$.  
We prove $P(k+1)$, the statement $1^{k+1}=1$.    
$1^{k+1}=1^k\cdot 1^1=1\cdot 1^1=1\cdot 1 = 1$.  
Proved by mathematical induction.    
**QED.**  

$2^k=\sum_{m=0}^{k}\binom{k}{m}1^m1^{k-m}$  

We know $k-m\geq0$, so either $k-m\in\mathbb{N}$, or $k-m=0$.   
If $k-m\in\mathbb{N}$, then $1^{k-m}=1$, as proved earlier.  
If $k-m=0$, then $1^0=1$ by definition.  
Therefore, $1^{k-m}=1$.  The same reasoning shows that $1^m=1$, since $m\geq0$.  

$2^k=\sum_{m=0}^{k}\binom{k}{m}1\cdot 1$  
$2^k=\sum_{m=0}^{k}\binom{k}{m}$  
**QED.**  

## Project 4.12  
$\text{(i)} \sum_{j=1}^{k} j = \frac{k(k+1)}{2}$  
$\text{(ii)} \sum_{j=1}^{k} j^2 = \frac{k(k+1)(2k+1)}{6}$  

Find (and prove) a formula for $\sum_{j=1}^{k}j^3$, where $k\in\mathbb{N}$.  

For the sum of $j^3$ with $k$ values $2,3,4$:  
$1+8=9$  
$1+8+27=36$  
$1+8+27+64=100$  

Looking at the first sum $\sum_{j=1}^{k} j$ for some $k$ values $2,3,4$:  
$1+2=3$  
$1+2+3=6$  
$1+2+3+4=10$  

Since we're given $\sum_{j=1}^{k} j = \frac{k(k+1)}{2}$, if we prove this pattern holds for all $k\geq1$, we can say $\sum_{j=1}^kj^3=(\sum_{j=1}^{k}j)^2=(\frac{k(k+1)}{2})^2=\frac{k^2(k+1)^2}{4}$.  

**Proof.**  
Proof by induction on $k\in\mathbb{N}$.   
Let $P(k)$ be the statement $\sum_{j=1}^{k} j^3 = (\sum_{j=1}^{k}j)^2$  

Prove the base case, $P(1)$:  
$\sum_{j=1}^{1} j^3 = (\sum_{j=1}^{1}j)^2$  
$1^3 = 1^2$  
$1 = 1$  

Now prove $P(k) \implies P(k+1)$:  
Assume $P(k)$, that is, $\sum_{j=1}^{k} j^3 = (\sum_{j=1}^{k}j)^2=\frac{k^2(k+1)^2}{4}$  
Prove $P(k+1)$, the statement $\sum_{j=1}^{k+1} j^3=\frac{(k+1)^2(k+2)^2}{4}$  

$\sum_{j=1}^{k+1} j^3=(\sum_{j=1}^{k} j^3)+(\sum_{j=k}^{k+1} j^3)$, by proposition 4.16(i)  
$=(\sum_{j=1}^{k} j^3)+(k+1)^3$, by definition of the summation  
$=(\frac{k^2(k+1)^2}{4})+(k+1)^3$, using our induction hypothesis  
$=\frac{k^2(k+1)^2+4(k+1)^3}{4}$  
$=\frac{(k+1)^2(k^2+4(k+1))}{4}$, by factoring out $(k+1)^2$  
$=\frac{(k+1)^2(k^2+4k+4)}{4}=\frac{(k+1)^2(k+2)^2}{4}$  
$\therefore P(k)\implies P(k+1)$.  

Proved by mathematical induction.  
**QED.**  

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

**Proof.**  

Proof by induction on $k\geq0$.  
Let $P(k)$ be the statement $(uv)^{(k)} = \sum_{m=0}^{k} \binom{k}{m} u^{(m)} v^{(k-m)}$  

Prove the base case, $P(0)$:  
$uv=\binom{0}{0}u^{(0)}v^{(0)}$  
$uv=1\cdot u^{(0)}v^{(0)}$  
$uv=uv$  

Now prove $P(k)\implies P(k+1)$.  
Assume $P(k)$, that is, for some $k\geq0$, $(uv)^{(k)} = \sum_{m=0}^{k} \binom{k}{m} u^{(m)} v^{(k-m)}$  
$P(k+1)$ says $(uv)^{(k+1)} = \sum_{m=0}^{k+1} \binom{k+1}{m} u^{(m)} v^{(k+1-m)}$  
$\sum_{m=0}^{k+1} \binom{k+1}{m} u^{(m)} v^{(k+1-m)}$  
$=\binom{k+1}{0}u^{(0)}v^{(k+1)}+\sum_{m=1}^{k} \binom{k+1}{m} u^{(m)} v^{(k+1-m)} + \binom{k+1}{k+1}a^{n+1}b^0$, by proposition 4.16(i)  


## Project 4.26  
A sequence $(x_j)_{j=0}^{\infty}$ satisfies $x_1 = 1$ and for all $m \geq n \geq 0$, $x_{m+n} + x_{m-n} = \frac{1}{2}(x_{2m} + x_{2n})$.  

Find a formula for $x_j$. Prove that your formula is correct.  



## Project 6.7(i)  

Determine whether the following relation defined on $\mathbb{Z}$ is an equivalence relation. If it is, determine the equivalence classes.  

$x \sim y \text{ if } x < y.$  

This is not an equivalence relation, as the relation is not *reflexive* — $x\nless x$.  


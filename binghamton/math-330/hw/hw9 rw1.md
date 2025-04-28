# Homework 9 [REWRITE]

## Proposition 4.13    
$\text{For } x \neq 1 \text{ and } k \in \mathbb{Z}_{\geq 0}, \sum_{j=0}^k x^j = \frac{1-x^{k+1}}{1-x}$  

**Proof.**  

We prove this with induction on $k\in\mathbb{Z}_{\geq0}$.  

Let $P(k)$ be the statement $\sum_{j=0}^k x^j = \frac{1-x^{k+1}}{1-x}$, for some $x\in\mathbb{Z}$.  

Let $x\in \mathbb{Z}$.  

**Base case: Prove $P(0)$.**  

$P(0)$ is the statement $\sum_{j=0}^0 x^j = \frac{1-x^{1}}{1-x}$.  
By definition of the summation, $\sum_{j=0}^0 x^j = x^0$, and by definition of powers, $x^0=1$. By definition of powers, $x^1=x^0 \cdot x = 1 \cdot x = x$, therefore $\frac{1-x^{1}}{1-x}=\frac{1-x}{1-x}=1$. 

Therefore, $\sum_{j=0}^0 x^j = \frac{1-x^{1}}{1-x}=1$.  

**Inductive step: Prove $P(k)\implies P(k+1)$.**  

Assume $P(k)$, that is, $\sum_{j=0}^k x^j = \frac{1-x^{k+1}}{1-x}$.  

$P(k+1)$ is the statement $\sum_{j=0}^{k+1} x^j = \frac{1-x^{k+2}}{1-x}$.  

By definition, $\sum_{j=0}^{k+1} x^j = \sum_{j=0}^k (x^j) + x^{k+1}$. By the inductive hypothesis, we can substitute the summation: $\frac{1-x^{k+1}}{1-x}+x^{k+1}$. Since $x\neq 1$, then $x-1\neq 0$, and we can multiply the $x^{k+1}$ term by $\frac{1-x}{1-x}$: $\frac{1-x^{k+1} + (1-x)x^{k+1}}{1-x}$.  

- $\frac{1-x^{k+1} + x^{k+1}-(x\cdot x^{k+1})}{1-x}$, simplifying the expression.  
- $\frac{1-(x\cdot x^{k+1})}{1-x}$, by cancellation.  
- $\frac{1-x^{k+2}}{1-x}$, by Proposition 4.6(ii), as we know $x=x^1$ from before.  

Therefore, $P(k+1)$ is true.  

Proved by induction.  

**QED.**  

## Proposition 4.16(ii)   
$\text{ Let } (x_j)_{j=a}^{\infty} \text{ and } (y_j)_{j=a}^{\infty} \text{ be sequences in } \mathbb{Z}, \text{ and let } a,b,c \in \mathbb{Z} \text{ such that } a < b < c. \text{ Then, } \sum_{j=a}^{b} (x_j + y_j) = \left( \sum_{j=a}^{b} x_j \right) + \left( \sum_{j=a}^{b} y_j \right)$  

**Proof.**  

Let $a \in \mathbb{Z}$.  
We prove this with induction on $k\in \mathbb{Z}$.  

Let $P(k)$ be the statement $\sum_{j=a}^{k} (x_j + y_j) = \left( \sum_{j=a}^{k} x_j \right) + \left( \sum_{j=a}^{k} y_j \right)$.  

**Base case: Prove $P(a)$.**  

$P(a)$ is the statement $\sum_{j=a}^{a} (x_j + y_j) = \left( \sum_{j=a}^{a} x_j \right) + \left( \sum_{j=a}^{a} y_j \right)$, for some fixed $a\in\mathbb{Z}$.  
By definition of summation, $\sum_{j=a}^{a} (x_j + y_j)=x_a+y_a=\left( \sum_{j=a}^{k} x_j \right) + \left( \sum_{j=a}^{k} y_j \right)$.  

**Inductive step: Prove $P(k)\implies P(k+1)$.**  

Assume $P(k)$, that is, $\sum_{j=a}^{k} (x_j + y_j) = \left( \sum_{j=a}^{k} x_j \right) + \left( \sum_{j=a}^{k} y_j \right)$.  

$P(k+1)$ is the statement $\sum_{j=a}^{k+1} (x_j + y_j) = \left( \sum_{j=a}^{k+1} x_j \right) + \left( \sum_{j=a}^{k+1} y_j \right)$.  

By definition of summation:  
$\sum_{j=a}^{k+1} (x_j + y_j)=\sum_{j=a}^{k} (x_j + y_j) + (x_{k+1}+y_{k+1})$   

$\sum_{j=a}^{k+1} (x_j)=\sum_{j=a}^{k} (x_j) + x_{k+1}$  

$\sum_{j=a}^{k+1} (y_j)=\sum_{j=a}^{k} (y_j) + y_{k+1}$   

Let $s=\sum_{j=a}^{k} (x_j + y_j) = \left( \sum_{j=a}^{k} x_j \right) + \left( \sum_{j=a}^{k} y_j \right)$, by our inductive hypothesis.  

Substituting the definitions: $\sum_{j=a}^{k} (x_j + y_j) + (x_{k+1}+y_{k+1})=\left(\sum_{j=a}^{k} (x_j) + x_{k+1} \right) +\left(\sum_{j=a}^{k} (y_j) + y_{k+1}\right)$.  
Rearranging terms: $\sum_{j=a}^{k} (x_j + y_j) + (x_{k+1}+y_{k+1})=\left(\sum_{j=a}^{k} (x_j) + \sum_{j=a}^{k} (y_j) \right) +\left(x_{k+1} + y_{k+1}\right)$.  
After substituting $s$, we obtain: $s+(x_{k+1}+y_{k+1})=s+(x_{k+1}+y_{k+1})$. This is trivially true.  

Proved by induction.  

**QED.**  

## Project 4.26  
A sequence $(x_j)_{j=0}^{\infty}$ satisfies $x_1 = 1$ and for all $m \geq n \geq 0$, $x_{m+n} + x_{m-n} = \frac{1}{2}(x_{2m} + x_{2n})$.  

Find a formula for $x_j$. Prove that your formula is correct.  

$x_j=j^2$.  

**Proof.**  

Using the sequence formula, we can rewrite the original constraint: 
$(m+n)^2+(m-n)^2=\frac{1}{2}((2m)^2+(2n)^2)$  
$\iff (m^2+2mn+n^2)+(m^2-2mn+n^2)=\frac{1}{2}(4m^2+4n^2)$  
$\iff (m^2+n^2+m^2+n^2)+(2mn-2mn)=2m^2+2n^2$  
$\iff m^2+n^2+m^2+n^2=2m^2+2n^2$  
$\iff 2m^2+2n^2=2m^2+2n^2$, which is true.  

**QED.**  
# Homework 12 [REWRITE]
Prove Props. 8.40, 8.43, 8.49. Do projects 8.44, 8.51, 9.3(i-iii), 9.4

You may use Proposition 8.25A without proof.  
Most of §§8.1-3 is familiar, but not §8.4.  
Don't forget to read the [advice](https://people.math.binghamton.edu/zaslav/330.S25/adv.html#8.25A) page.  

## Proposition 8.25A  
Suppose x, y, z, w ∈ R and x, w ≠ 0. Then $\frac{y}{x}\cdot\frac{z}{w}$ = $\frac{yz}{xw}$.  
Use this freely.  

## Proposition 8.40  
$\text{(i) } x\in\mathbb{R}_{>0} \text{ if and only if } \frac{1}{x}\in\mathbb{R}_{>0}$  

**Proof.**  
We can rewrite this as $x\in\mathbb{R}_{>0}\iff x^{-1}\in\mathbb{R}_{>0}$, by definition of the division operation.  
Since $\mathbb{R}_{>0}$ is defined as $\{x \in\mathbb{R}\text{ | } x > 0\}$, we can rewrite the proposition again as $x>0\iff x^{-1}>0$.  
Axiom 8.5 states that for each $x\in\mathbb{R}-\{0\}$, there exists an inverse $x^{-1}$ where $x\cdot x^{-1}=1$.  
This means that $x$ and $x^{-1}$ must have the same *sign*, that is, either $x, x^{-1}\in\mathbb{R}_{>0}$, or $-x, -x^{-1}\in\mathbb{R}_{>0}$. They cannot have opposite signs, as that would mean $x\cdot x^{-1}=-1$, violating our axiom. This conclusion can be rewritten as $x, x^{-1}>0$, or $-x, -x^{-1}>0$. We have proved that $x^{-1}>0\iff x>0$.  
**QED.**  

$\text{(ii) }$ Let $x,y\in\mathbb{R}_{>0}$. $\text{ If }x<y \text{ then } 0<\frac{1}{y}<\frac{1}{x}$.  

**Proof.**  

Assume $x,y\in\mathbb{R}_{>0} \text{ and }x<y $.  
By part (i) of this proposition, since $x,y\in\mathbb{R}_{>0}$, we know $\frac{1}{x},\frac{1}{y}\in\mathbb{R}_{>0}$. In other words, both $\frac{1}{x}>0$ and $\frac{1}{y}>0$.  

Now, prove $\frac{1}{y}<\frac{1}{x}$.  

By Axiom 8.26, since $x,y\in\mathbb{R}_{>0}$, then $xy\in\mathbb{R}_{>0}$.  

Since $xy>0$, we know $(xy)^{-1}>0$ by part (i) of this proposition. We can multiply both sides of the assumed true statement $x<y$ by $(xy)^{-1}$ without changing the inequality, resulting in $\frac{x}{xy}<\frac{y}{xy}$.  This simplifies to $\frac{1}{y}<\frac{1}{x}$ by the properties of inverses.  

We now know $\frac{1}{y}<\frac{1}{x}$, $0<\frac{1}{x}$ and $0<\frac{1}{y}$. Therefore, $0<\frac{1}{y}<\frac{1}{x}$.  

**QED.**  

## Theorem 8.43  
$\text{Let } x, y \in \mathbb{R} \text{ such that } x < y. \text{ There exists } z \in \mathbb{R} \text{ such that } x < z < y.$  

**Proof.**  

Assume $x,y,z\in\mathbb{R}, \text{ and } x<y$.  
Given an $x, y \in \mathbb{R} \text{ such that } x < y$, we can construct a $z\in\mathbb{R}$ where $x < z < y$.  
$$z=y-\frac{y-x}{2}$$  
Proof that $x<z$:  

<!-- We know $x<y \iff y-x\in\mathbb{R}_{>0}$   -->
$x<z \iff x<y-\frac{y-x}{2}$, by substitution of $z$  
$\iff 2x<2y-(y-x)$, by multiplying both sides with $2$  
$\iff 2x<2y+(-y+x)$, by proposition 8.22(i)  
$\iff 2x<(2y-y)+x$, by associativity  
$\iff 2x<y+x$    
$\iff x<y$, by proposition 8.32(i), adding $-x$ to both sides  
Since $x<z\iff x<y$, and it is assumed $x<y$, we know $x<z$.  

Now proof that $z<y$:  

$z<y \iff y-\frac{y-x}{2}<y$, by substitution of $z$  
$\iff 2y-(y-x)<2y$, by muiltiplying both sides of $2$  
$\iff 2y+(-y+x)<2y$, by proposition 8.22(i)  
$\iff (2y-y)+x<2y$, by associativity  
$\iff y+x<2y$  
$\iff x<y$, by proposition 8.32(i), adding $-y$ to both sides  
Since $z<y\iff x<y$, and it is assumed $x<y$, we know $z<y$.  

Since $x<z$ and $z<y$, we know $x<z<y$. We have constructed a number $z$ such that for any $x,y\in\mathbb{R}$ where $x<y$, $x<z<y$.  

**QED.**  

## Proposition 8.49  
$\text{Let } A \subset \mathbb{R} \text{ be nonempty. If } \sup(A) \in A \text{ then } \sup(A) \text{ is the largest}$  
$\text{element of } A\text{, i.e., } \sup(A) = \max(A)\text{. Conversely, if } A \text{ has a largest element then}$  
$\max(A) = \sup(A) \text{ and } \sup(A) \in A\text{.}$  

**Proof.**  

Part 1.  

The definition of the supremum of a set $A$ is the least upper bound of $A$. The set of upper bounds on $A$ can be defined as $\{x\in \mathbb{R} \text{ | } (\forall a\in A) \text{ } a\leq x\}$.  
Let $x=\sup(A)$.  We are given that $x\in A$, and by definition of the supremum, we know $(\forall a\in A) \text{ } a\leq x$. Note the definition of $\text{max}(A)$ is some $x\in A$ where $(\forall a\in A) \text{ } a\leq x$. The definitions are the same, therefore, $\sup(A)\in A \iff \sup(A)=\text{max(A)}$.  

Part 2.  

Since in part 1 we proved that $\sup(A)\in A \iff \sup(A)=\text{max(A)}$, and because this is a two way implication, the converse is true.  

**QED.**

## Project 8.44
$\text{Construct a subset } A \subseteq \mathbb{R} \text{ that satisfies}$  
$\text{(i) } 1 \in A \text{ and}$  
$\text{(ii) if } n \in A \text{ then } n + 1 \in A\text{,}$  
$\text{yet for which } \mathbb{R}_{>0} \text{ is not a subset of } A\text{.}$    

$\mathbb{R}_{\geq1}$. This seems too simple to be true...    

## Project 8.51  
$\text{For a nonempty set } B \subseteq \mathbb{R} \text{ one can define the greatest lower bound}$  
$\inf(B) \text{ (or infimum) of } B\text{. Give the precise definition for } \inf(B) \text{ and prove that it is}$  
$\text{unique if it exists. Also define } \min(B) \text{ and prove the analogue of Proposition 8.49}$
$\text{for greatest lower bounds and minima.}$  

**Definitions.**  
A **greatest lower bound** for $A$ is a lower bound that is greater than or equal to every lower bound for $A$.  
A real number $b\in A$ is the **minimum** or **smallest** element of $A$ if for all $a\in A$, $b\leq a$.  In this case we write $b=\min(A)$.  
The set of lower bounds for $A$ can be denoted as $A_l=\{x\in\mathbb{R} \text{ | } (\forall a\in A) \text{ } x\leq a\}$. The greatest lower bound for $A$ can also be represented as $\max(A_l)$, by it's definition.  

### The greatest lower bound of $A$, if it exists, is unique    

**Proof.**  

We can rewrite the statement as follows:  
If $x_1$ and $x_2$ are greatest lower bounds for $A$, then $x_1 = x_2$  

Let $x_1$ and $x_2$ be greatest lower bounds for $A$.  
By definition, $x_1=\max(A_l)$, and $x_2=\max(A_l)$.  Since the maximum element of a set, if it exists, must be unique, then $\max(A_l)=\max(A_l)$. Now by transitivity, $x_1=x_2$.  

**QED.**  

### Proposition 8.49 (but for the greatest lower bound instead) 
$\text{Let } A \subset \mathbb{R} \text{ be nonempty. If } \inf(A) \in A \text{ then } \inf(A) \text{ is the smallest}$  
$\text{element of } A\text{, i.e., } \inf(A) = \min(A)\text{. Conversely, if } A \text{ has a smallest element then}$  
$\min(A) = \inf(A) \text{ and } \inf(A) \in A\text{.}$  

**Proof.**  

Part 1.  

The definition of the infimum of a set $A$ is the greatest lower bound of $A$. The set of lower bounds on $A$ can be defined as $\{x\in \mathbb{R} \text{ | } (\forall a\in A) \text{ } x\leq a\}$.  
Let $x=\inf(A)$.  We are given that $x\in A$, and by definition of the infimum, we know $(\forall a\in A) \text{ } x\leq a$. Note the definition of $\min(A)$ is some $x\in A$ where $(\forall a\in A) \text{ } x\leq a$. The definitions are the same, therefore, $\sup(A)\in A \iff \sup(A)=\text{max(A)}$.  

Part 2.  

Since in part 1 we proved that $\inf(A)\in A \iff \inf(A)=\min(A)$, and because this is a two way implication, the converse is true.  

**QED.**  

## Project 9.3  
$\text{Determine which of the following functions are injective, surjective, or bijective. Justify your assertions.}$  

$\text{(i) } f : \mathbb{Z} \to \mathbb{Z}, f(n) = n^2\text{.}$  

This is not surjective, injective, or bijective. The image is a subset of $\mathbb{Z}_{\geq0}$, while the codomain is $\mathbb{Z}$, therefore it is not surjective.  For both $x=1,-1$, we know $y=1$, therefore it is not injective.  Since it is not surjective and injective, it is not bijective.  


$\text{(ii) } f : \mathbb{Z} \to \mathbb{Z}_{\geq 0}, f(n) = n^2\text{.}$  

This is not surjective, injective or bijective. This is not surjective, as the image is a subset of $Z_{\geq0}$, the codomain (the subset contains all perfect squares, but numbers like 2, 3, 5 have no mapping). This is not injective, for the same reason as in part $\text{(i)}$. Since it is not surjective and injective, it is not bijective.  

$\text{(iii) } f : \mathbb{Z}_{\geq 0} \to \mathbb{Z}_{\geq 0}, f(n) = n^2\text{.}$    

It is injective because now the function is strictly monotonic, and will never repeat an output. It is not surjective for the same reason as part $(ii)$, therefore it is not bijective.  

## Project 9.4
$\text{Construct (many) functions that are}$  

$\text{(i) bijective;}$  

$f(x)=x$  
The outputs of the function never repeat, therefore it is injective. The image is $\mathbb{R}$, therefore it is surjective. Since it is injective and surjective, it is bijective.  

$\text{(ii) injective, but not surjective;}$  

$f(x)=\frac{1}{x}$  
The outputs of the function never repeat, therefore it is injective. The image is $\mathbb{R}-\{0\}$, while the codomain is $\mathbb{R}$, therefore it is not surjective.  

$\text{(iii) surjective, but not injective;}$  

$f(x)=x^{3}+2x^{2}$  
The image is $\mathbb{R}$, so it is surjective. It has 2 distinct roots, making it not injective (multiple elements in the domain map to 0). 

$\text{(iv) neither injective nor surjective.}$  

$f(x)=x^2$  
The image is $\mathbb{R}_{\geq0}$, while the codomain is $\mathbb{R}$, therefore it is not surjective.  For both $x=1,-1$, we know $y=1$, therefore it is not injective.  
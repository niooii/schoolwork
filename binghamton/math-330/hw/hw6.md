# Do Projects 2.35 for (4,6), 3.3, 3.7, Extras #1(a-e). Prove Props. 2.23, 2.18.1(iii,iv).   

> **Project 2.35.**  
> Compute $gcd(4,6)$.  

$gcd(4,6)=min(\set{k\in\mathbb{N} | k=4x+6y, \text{ for }x,y\in\mathbb{Z}})$  
$=2$

> **Project 3.3.**  
> Construct two more mathematical if-then statements that are true, but whose converses are false.  

$1)$ If $f$ is differentiable, then $f$ is continuous.  
$2)$ If $f$ is bijective, then $f$ is surjective.   

> **Project 3.7.**  
> Negate the following statements.  

**$(i)$ Every cubic polynomial has a real root.**  
Every cubic polynomial does not have a real root.  
**$(ii)$ $G$ is normal and $H$ is regular.**  
$G$ is not normal or $H$ is not regular.  
**$(iii)$ $\exists!0$ such that $\forall x$, $x + 0 = x$.**  
$(\exists!x)\space P(x)=(\exists x) \space [P(x) \land \forall y \space (P(y) \implies y=x)]$  
$\lnot[(\exists!x)\space P(x)]=\lnot[(\exists x) \space [P(x) \land \forall y \space (P(y) \implies y=x)]]$  
$=(\forall x) \space [\lnot P(x) \lor \exists y \space \lnot(P(y) \implies y=x)]$  
$=(\forall x) \space [\lnot P(x) \lor \exists y \space (P(y) \land y\neq x)]$  

Negated: $\forall n \space [\lnot(\forall x \space (x + n = x)) \lor \exist y \space (\forall x \space (x + y = x) \land y \neq n)]$  
$=\forall n \space [(\exists x \space (x + n \neq x)) \lor \exist y \space (\forall x \space (x + y = x) \land y \neq n)]$  

**$(iv)$ The newspaper article was neither accurate nor entertaining.**  
Rewritten: The newspaper was not accurate and not entertaining.  
Negated: The newspaper was accurate or entertaining. 
**$(v)$ If $gcd(m, n)$ is odd, then $m$ or $n$ is odd.**  
Rewritten: $m$ or $n$ is odd, or $gcd(m,n)$ is even.  
Negated: $m$ and $n$ is even, and $gcd(m,n)$ is odd.  
**$(vi)$ $H/N$ is a normal subgroup of $G/N$ if and only if $H$ is a normal subgroup of $G$.**  
$(P\iff Q) = ((P\implies Q) \land (Q\implies P))$  
$\lnot(P\iff Q) = \lnot((P\implies Q) \land (Q\implies P))$  
$=\lnot(P\implies Q) \lor \lnot(Q\implies P)$  
$=(P\land \lnot Q) \lor (Q\land \lnot P)$  
$=P\oplus Q=(P\iff \lnot Q)$  
$H/N$ is a normal subgroup of $G/N$ if and only if $H$ is not a normal subgroup of $G$.  
**$(vii)$ For each $ε > 0$ there exists $N ∈ \mathbb{N}$ such that for all $n ≥ N$, $|a_n − L| < ε$.**   
Rewritten: $(\forall \epsilon>0)(\exists N\in\mathbb{N})(\forall n>N) |a_n-L| < \epsilon$  
Negation: $(\exists\epsilon>0)(\forall N\in\mathbb{N})(\exists n > N) |a_n-L|\geq \epsilon$

> **Extras 1a-1e.**  

$a)$ P and Q are statements. What is the difference among "P if Q", "P is necessary for Q", and "P only if Q"?  

P if Q means Q implies P.  
P is necessary for Q means Q requires P to be true (Q implies P).  
P only if Q means P is only true when Q is true (P implies Q).  

$b)$ Write the inverse, converse, and contrapositive of the following statement: "There can't be rain if there is no water."  

Inverse: There can be rain if there is water.  
Converse: There can't be water if there is no rain.
Contrapositive: There can be water if there is rain.  

$c)$ Consider the statement "All apples are pears." Formulate it as an implication P ⇒ Q (say what P and Q are). Then state the contrapositive, converse, and inverse of your implication. Which of the four statements are true and which are false? Explain why.  

`They are all false!`  

The implication: If it is an apple, then it is a pear.  
`False, proved below.`  
Contrapositive: If it is not a pear, then it is not an apple.  
`False. If it is not a pear, it could still be an apple. This would be true if the implication is true (that all apples are pears)`  
Converse: If it is a pear, then it is an apple.  
`False, by contrapositive of proposition Apple. Again, this would be true if the implication was true by transitivity, but the converse does not have to be true.`  
Inverse: If it is not an apple, then it is not a pear.  
`False. If it is not a pear, it could still be an apple.`  

$d)$ Consider the statement "No apples are pears." Formulate it as an implication R ⇒ S (say what R and S are). Then state the contrapositive, converse, and inverse of your implication.  

> **Prop. Apple**  
> If it is an apple, then it is not a pear.  

Proof.  
Let $S = \set{s | s \text{ is a species}}$  
Let $A_g=\set{s \in S | s \text{ is of the genus Malus}}$.  
Let $P_g=\set{s \in S| s \text{ is of the genus Pyrus}}$.  

By definition of the taxonimic category 'genus', $A_g$ and $P_g$ are disjoint.  

Let $\text{F}=\set{f | f \text{ is a fruit}}$, and a function $s: \text{F} \rightarrow \text{S}$ mapping a fruit to it's species.    

By definition:  
The set of all apples $A = \set{f \in F | s(f) \in A_g}$  
The set of all pears $P = \set{f \in F | s(f) \in P_g}$  

Let an apple $a\in A$.  
Since $s(a)\in A_g$, and $A_g \cap P_g = \emptyset$, $s(a)\notin P_g$.  

From the definition of the set $P$:  
$(p\in P \implies s(p)\in P_g)$  
$\iff$ $(s(p) \notin P_g \implies p\notin P)$  

Therefore, since $s(a)\notin P_g$, we know $a \notin P$.  

$\therefore $ if $x\in A$, $x\notin P$ - That is, if it is an apple, then it cannot be a pear.  

$\text{QED.}$  

Contrapositive: If it is a pear, then it is not an apple.  
Converse: If it is not a pear, then it is an apple.  
Inverse: If it is not an apple, then it is a pear.  

$e)$ Compare the implications of parts c and d. Are they different? Why, or why not?  

They are different. One is true and one is not. For part c, all the variants of the implication of false, but for part d, the implication and the contrapositive is true, and the inverse and the converse is false.  

> **Prop. 2.23.**  
> Let $m,n\in\mathbb{N}$. If $n$ is divisible by $m$ then $m\leq n$.  

Proof.  

Let $m,n\in\mathbb{N}$.  
$n$ is divisible by $m$ $\iff (\exists z \in \mathbb{Z})\space mz=n$  

The proposition can be rewritten as: 
If $(\exists z \in \mathbb{Z})\space mz=n$, then $m\leq n$.  

Proof that $z\in\mathbb{N}$.  
By proposition 2.2, we know one and only one of the following is true for $z\in\mathbb{Z}$:  
$z\in\mathbb{N}, z=0, -z\in\mathbb{N}$.  
Assume $z=0$. That means $m\cdot0=n$, so $n=0$. However, we know $n\in\mathbb{N}$, so $n\neq0$. By contradiction, $z\neq0$.  
`// Comment: Do i have to expand more on this part below?`
Assume $-z\in\mathbb{N}$. Since $m\in\mathbb{N}$, this means $mz=n<0$. However, $n\geq 1$ by proposition 2.20. By contradiction, $-z\notin\mathbb{N}$.  
Therefore $z\in\mathbb{N}$.  

We rewrite the proposition again:  
If $(\exists z \in \mathbb{N})\space mz=n$, then $m \leq n$.  

Proposition 2.12(iv) states if $m ≤ n$ and $0 ≤ p$ then $mp ≤ np$.  
$0\leq m$ because $m\in\mathbb{N}$.  
By proposition 2.20, since $z\in\mathbb{N}$, $1\leq z$.  
Using proposition 2.12(iv), $1m\leq zm$. We know $mz=n$, so by substituting $n$ for $mz$:  
$1m\leq n$, or $m\leq n$.  

$\therefore$ if $n$ is divisible by $m$ then $m\leq n$.  

### Let $n\in\mathbb{N}$ for the following propositions.  

> **Prop. 2.18.1(iii).**  
> The sum $1^2+2^2+3^2+...+n^2=\frac{n(n+1)(2n+1)}{6}$.  

Proof.  

Let $P(n)$ be the proposition: $1^2+2^2+3^2+...+n^2=\frac{n(n+1)(2n+1)}{6}$.  

Prove $P(1)$.  
$1=\frac{1(1+1)(2(1)+1)}{6}$  
$1=\frac{(2)(3)}{6}$  
$1=1$  

Prove $P(n) \implies P(n+1)$.  
$1^2+2^2+3^2+...+n^2+(n+1)^2=\frac{(n+1)(n+2)(2n+3)}{6}$  
$\frac{n(n+1)(2n+1)}{6}+(n+1)^2=\frac{(n+1)(n+2)(2n+3)}{6}$  
$n(n+1)(2n+1)+6(n^2+2n+1)=(n+1)(n+2)(2n+3)$  
$2n^3+3n^2+n+6(n^2+2n+1)=(n^2+3n+2)(2n+3)$  
$2n^3+3n^2+n+6n^2+12n+6=2n^3+9n^2+13n+6$  
$2n^3+9n^2+13n+6=2n^3+9n^2+13n+6$  

Therefore, $P(n) \implies P(n+1)$.  

$\therefore P(n)$ is true by mathematical induction.  

> **Prop. 2.18.1(iii).**  
> $6 \space | \space n(n+1)(2n+1)$

We know that $\frac{n(n+1)(2n+1)}{6}\in\mathbb{Z}$, because the sum of natural numbers is in $\mathbb{N}\subset \mathbb{Z}$.  
Let $z=\frac{n(n+1)(2n+1)}{6}\in\mathbb{Z}$.  Multiplying both sides by $6$:  
$6z=n(n+1)(2n+1)$, where $z\in\mathbb{Z}$.  
$\therefore n(n+1)(2n+1)$ is divisible by $6$.  
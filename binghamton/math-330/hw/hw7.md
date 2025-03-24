# Do Project 5.3 using def. of set equality. Do Projects 5.5, 5.12(i,ii), 5.16(ii), 5.21(i), and 5.4A(a). Prove Prop. 5.20(ii). Do Project 4.3. 

> **Project 5.3.**  

Determine which of the following set equalities are true. If a statement is true, prove it. If it is false, explain why this set equality does not hold.

Definition of set equality:
$$A=B \iff A\subseteq B \land B\subseteq A$$

(i) $D = E$, where  
$D := \{3x : x \in \mathbb{N} \land x > 7\}$  
$E := \{y : y \in \mathbb{N}\}$  

This statement is false.
***Proof.***    
We follow a simple proof by contradiction - If $D=E$, then $D\subseteq E$ and $E \subseteq D$.  
By definition, $E \subseteq D$ means $n\in E\implies n\in D$.  
We know $1\in\mathbb{N}$. Setting $y=1$ in the definition of $E$ shows us that $1\in E$.  
By the definition of $D$, $D$ contains natural numbers of the form $3x$, where $x\in\mathbb{N}$.  
We know that $1$ is not divisible by 3, and therefore cannot be represented as $3x$ for $x\in\mathbb{N}$.  
We see $1\in E$, but $1\notin D$. Therefore, $E\subseteq D$ is false, and consequently, $E\neq D$.  
***QED*.**

(iii) $D = B$, where  
$D := \{3x : x \in \mathbb{N} \land x > 7\}$  
$B := \{3y + 21 : y \in \mathbb{N}\}$  

These sets are equal.  
***Proof.***  
First prove $D\subseteq B$, that is, $n\in D \implies n\in B$  
Let $n\in D$. We know $n$ is a natural number with the form $3x$, for any $x\in\mathbb{N}$ where $x>7$.  
Now, we prove $n$ can be written in the form $3y+21$, for any $y\in\mathbb{N}$.  
`// COMMENT: Is there some better formal way to say what im trying to say here?`
Let $y=x-7$ for any $x>7$. By definition, $(x-7\in \mathbb{N})\iff (x>7)$. Therefore, $x-7$ can be used as a substitution for $y$.  
Solving for $x$, $x=y+7$. We substitute $y+7$ for $x$:  
$n=3x=3(y+7)=3y+21$
$\therefore n\in D \implies n\in B$.  
$\therefore D\subseteq B$.  

Now prove $B\subseteq D$, that is, $m\in B \implies m\in D$.  
Let $m\in B$. $m=3y+21$ for any $y\in\mathbb{N}$.  
Now, we prove this implies $m=3x$, for some $x\in\N$ where $x>7$.  
$m=3y+21=3(y+7)$.  
We let $x=y+7$, for any $y\in\mathbb{N}$. This works because solving for $y$, $y=x-7$, and $(x-7\in\mathbb{N})\iff (x>7)$.  
With $x=y+7$, we substitute:  
$m=3(y+7)=3x$ for all $x>7$.  
$\therefore m\in B\implies m\in D$.  
$\therefore B \subseteq D$. 

Since $D\subseteq B$ and $B \subseteq D$, then $B=D$.  
***QED.***

(ii) $C = G$, where  
$C := \{x + 7 : x \in \mathbb{N}\}$  
$G := \{y : y \in \mathbb{N} \land y > 7\}$  

These sets are equal.  
***Proof.***  
First prove $C\subseteq G$.  
We need to prove $n\in C \implies n\in G$.  
Let $n\in C$. We know $n=x+7$, for any $x\in\mathbb{N}$.  
Now, we prove this implies $n=y$ for some $y\in\mathbb{N}$ if $y>7$.  
Since $y>7 \iff y-7\in \mathbb{N}$, we can let $x=y-7$, where we know $x\in\mathbb{N}$.  
$y=x+7$, then we substitute:  
$n=x+7=y$.  
$\therefore n\in C \implies n\in G$.  
$\therefore C\subseteq G$.  

Now prove $G\subseteq C$.  
Let $m\in G$. We know $m=y$, for any $y\in\mathbb{N}$ if $y>7$.  
Prove this implies $m=x+7$, for some $x\in\mathbb{N}$.  
Following the reasoning from before, $x=y-7$.  
Substituting: $m=y=x+7$.  
$\therefore n\in G \implies n\in C$.  
$\therefore G\subseteq C$.  

Since $C \subseteq G$ and $G \subseteq C$, then $C=G$.  
***QED.***

> **Project 5.5.**  

When reading or writing a set definition, pay attention to what is a variable inside the set definition and what is not a variable. As examples, how do the following pairs of sets differ?

$S := \{m : m \in \mathbb{N}\}$ and $T_m := \{m\}$ for a specified $m \in \mathbb{N}$.  
$S$ and $T_m$ differ because the definition of $S$ is constructing a set of all natural numbers, and $T_m$ just contains one specified element which is a natural number.   

$U := \{my : y \in \mathbb{Z}, m \in \mathbb{N}, my > 0\}$ and $V_m := \{my : y \in \mathbb{Z}, my > 0\}$ for a specified $m \in \mathbb{N}$.  
In the set definition of $U$, a number is being constructed for each (pair of?) integer and natural number. In $V_m$, $m$ is a constant defined outside of the set definition, so each element of $V_m$ will be a multiple of the predefined constant $m$.  
 
$V_m$ and $W_m := \{my : y \in \mathbb{Z}, y > 0\}$ for a specified $m \in \mathbb{Z}$.  
The sets have the same definition and use the same constant $m$, so they are the same.  

> **Project 5.12.**  

Determine which of the following statements are true for all sets $A$, $B$, and $C$. If a double implication fails, determine whether one or the other of the possible implications holds. If a statement is true, prove it. If it is false, provide a counterexample.  

(i) $C \subseteq A$ and $C \subseteq B \iff C \subseteq (A \cup B)$.  
 
Only $C \subseteq A$ and $C \subseteq B \implies C \subseteq (A \cup B)$ is true.  
***Proof.***  
Let $x\in C$. Since $C\subseteq A \iff (x\in C \implies x\in A)$, $x\in A$.   
By definition, $A\cup B=\set{x:x\in A \text{ or } x\in B}$.  
Since $x\in A \text{ or } x\in B$ is always true if $x\in A$, all elements of $A$ must be in $A\cup B$, that is, $A\subseteq (A\cup B)$.  
Additionally, since $x\in A \text{ or } x\in B$ is always true if $x\in B$, $B\subseteq (A\cup B)$ (this will be used later).  
Since $x\in A$ and $A\subseteq (A\cup B)$, $x\in (A\cup B)$.  
We have shown $x\in C \implies x\in (A\cup B)$, and this is precisely the definition of $C\subseteq (A\cup B)$.    
$\therefore C \subseteq A$ and $C \subseteq B \implies C \subseteq (A \cup B)$.  

Now, we disprove  $C \subseteq (A \cup B) \implies C \subseteq A$ and $C \subseteq B$, by a counterexample.  
We define the following sets:  
$A:=\set{1,2,3}$  
$B:=\set{4,5}$  

$(A\cup B) = \set{1,2,3,4,5}$  
Define the set $C:=\set{2,3,4}$, where $C\subseteq (A\cup B)$.  
$C=\set{2,3,4}$ is not a subset of $A=\set{1,2,3}$, which means $(C \subseteq A$ and $C \subseteq B)$ is false.  
***QED.***

(ii) $C \subseteq A$ or $C \subseteq B \iff C \subseteq (A \cup B)$.  

Only $C \subseteq A$ or $C \subseteq B \implies C \subseteq (A \cup B)$ is true.  
***Proof.***  
Let $x\in C$. It is sufficient to prove two cases: when $C\subseteq A$ and when $C\subseteq B$.  
Let $C\subseteq A$. Since $x\in C$, $x\in A$. We know from previous results that $A\subseteq (A\cup B)$. Since $x\in A$, $x\in (A\cup B)$.  
Now, let $C\subseteq B$.  Since $x\in C$, $x\in B$. From previous results, $B\subseteq (A\cup B)$.  Since $x\in B$, $x\in (A\cup B)$.  
We have shown that when $C\subseteq A$, $x\in C \implies x\in (A\cup B)$.  
We have also shown that when $C\subseteq B$, $x\in C \implies x\in (A\cup B)$.  
Note that these implications are the same, so if $C\subseteq A$ or $C\subseteq B$, $x\in C \implies x\in (A\cup B)$, or rewritten, $C\subseteq (A\cup B)$.  
$\therefore C \subseteq A$ or $C \subseteq B \implies C \subseteq (A \cup B)$.  

Now, we disprove $C \subseteq (A \cup B) \implies C \subseteq A$ or $C \subseteq B$, by a counterexample.  
We define the same sets as before:  
$A:=\set{1,2,3}$  
$B:=\set{4,5}$  

$(A\cup B) = \set{1,2,3,4,5}$  
Define the set $C:=\set{2,3,4}$, where $C\subseteq (A\cup B)$.  

$C\subseteq A$ is false, and $C\subseteq B$ is false, which means $(C\subseteq A$ or $C\subseteq B)$ is false.    
***QED.***  

> **Project 5.16**  

Someone tells you that the following equalities are true for all sets $A$, $B$, $C$. In each case, either prove the claim or provide a counterexample.  

(ii) $A \cap (B - C) = (A \cap B) - (A \cap C)$.  

We rewrite the equality statement as follows:  
$A \cap \set{x : x\in B \land x\notin C} = \set{y : y \in A \land y \in B} - \set{y : y \in A \land y\in C}$   
$\set{x : x\in A \land x\in B \land x\notin C} = \set{y : (y \in A \land y \in B) \land \lnot (y \in A \land y\in C)}$  
$\set{x : x\in A \land x\in B \land x\notin C} = \set{y : (y \in A \land y \in B) \land (y \notin A \lor y\notin C)}$  
For the definition on the right side, we know $y\in A$. Therefore, $y\notin A$ is always false.  
$\set{x : x\in A \land x\in B \land x\notin C} = \set{y : (y \in A \land y \in B) \land y\notin C}$  
$\set{x : x\in A \land x\in B \land x\notin C} = \set{y : y \in A \land y \in B \land y\notin C}$  
These are exactly the same definitions. Therefore, the equality holds.  

> **Project 5.21**  

Let $A$, $B$, $C$, $D$ be sets. Decide whether each of the following statements is true or false; in each case prove the statement or give a counterexample.  

(i) $(A \times B) \cup (C \times D) = (A \cup C) \times (B \cup D)$.  

(1,3) (2,3) (1,4) (2,4)

This statement is false. We prove this with a counterexample:  
Define the following sets:  
$A:=\set{1}$  
$B:=\set{2}$  
$C:=\set{3}$  
$D:=\set{4}$  

$A \times B = \set{(1,2)}$
$C \times D = \set{(3,4)}$
$(A \times B) \cup (C \times D) = \set{(1,2), (3,4)}$  

$A \cup C = \set{1,3}$
$B \cup D = \set{2,4}$
$(A \cup C) \times (B \cup D) = \set{(1,2), (1,4), (3,2), (3,4)}$

These two results are not equal.  

> **Functions: 5.4A(a)**   

**A function $g:X\rightarrow Y$ is defined as follows:**  

|    $x$    | $g(x)$ |
| :-------: | :----: |
|    cat    |   3    |
| squirrel  |   0    |
| sunflower |   1    |
|   grass   |   4    |

**What is the domain, $\text{Dom}(g)$?**  

$\set{cat, squirrel, sunflower, grass}$  

**What is the codomain, $\text{Codom}(g)$?**  

The set $Y$  

**What is the image, $\text{Im}(g)$?**  

$\set{3, 0, 1, 4}$  

**Is $g$ injective (one-to-one)?**  

Yes.  

**Is $g$ surjective (onto)?**  

Yes. (Assuming $Y=\set{3,0,1,4}$)

**Is $g$ bijective (a one-to-one correspondence)?**  

Yes. Injectivity and surjectivity $\iff$ bijectivity. 

> **Proposition 5.20.**  

(ii) $A \times (B \cap C) = (A \times B) \cap (A \times C)$  
***Proof.***  
Let the ordered pair $(a, x)\in A\times (B\cap C)$.  
$(a, x)\in A\times (B\cap C)$
$\iff a\in A$ and $x\in (B\cap C)$, by definition of the cartesian product.  
$\iff a\in A$ and $x\in B$ and $x\in C$, by definition of the intersection operation.  
We now have the following true statement: $a\in A \land x\in B \land x\in C$  
$\iff (a\in A \land x\in B) \land (a\in A \land x\in C)$  
$\iff [(a, x) \in (A \times B)] \land [(a, x) \in (A \times C)]$  
$\iff (a, x)\in [(A\times B) \cap (A\times C)]$, by definition of intersections.  
Since $(a,x)\in A\times (B\cap C)\iff (a,x)\in [(A\times B) \cap (A\times C)]$, by the definition of set equality, these two sets are equal.  
***QED.***  

> **Project 4.3** (The $x + 1$ problem)  

We revise the $3x + 1$ problem as follows: Pick your favorite natural number $m$, and define the following sequence:  

(i) Define $x_1 := m$.  



(ii) Assuming $x_n$ defined, define $x_{n+1} :=   
\begin{cases}  
\frac{x_n}{2} & \text{if } x_n \text{ is even,} \\
x_n + 1 & \text{otherwise.}
\end{cases}$  

Does this sequence eventually take on the value $1$, no matter what $m \in \mathbb{N}$ one chooses as the starting point? Try to prove your assertion.  

Uhh... 
`unfinished`
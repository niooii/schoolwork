# Homework 11 [REWRITE]
Prove Props. 6.15-16, 6.25, 8.6. Do Projects 6.9, 6.27

## Proposition 6.15
The integer $m$ is odd if and only if $\exists q\in\mathbb{Z}$ such that $m=2q+1$.  

**Proof.**  
Recall that $m\in\mathbb{Z}$ is even $\iff$ $m$ is divisible by $2$.  We define the set of even integers with this definition:  
$$\mathbb{Z}_E:=\{x\in\mathbb{Z} \text{ | } x \text{ is divisible by 2 }\}$$  

The odd integers are defined by those that are not even:  
$$\mathbb{Z}_O:=\{x\in\mathbb{Z} \text{ | } x \text{ is not divisible by 2 }\}$$  
For any integer $m\in\mathbb{Z}$ and a divisor of $n=2$, by the Division Algorithm, we know there exist unique $q,r\in\mathbb{Z}$ where $m=2q+r$. The division algorithm says that $0\leq r\leq n-1$, and when $n=2$, $0\leq r \leq 1$. Therefore, we know $r$ must be either $0 \text{ or } 1$. If we let $m$ be odd, then we know that $m$ is not divisible by $2$, therefore $r\neq 0$, leaving the only possible value $r=1$. Since $r$ is known if $m$ is odd, we can rewrite $m=2q+r$ as $m=2q+1$.  
$\therefore m$ is odd $\iff$ $\exists q\in\mathbb{Z}$ such that $m=2q+1$.  
**QED.**  



## Proposition 6.16
For every $n\in \mathbb{Z}$, $n$ is even or $n+1$ is even.  

**Proof.**  
It is sufficient to prove that ($n$ is even) and ($n+1$ is even) cannot both be false, then the original statement will be true, as an $or$ is only false when both of it's operands are false.  
Assume $n$ is not even and $n+1$ is not even, for any $n\in\mathbb{Z}$.  
By the definition of the **odd integers**, we can rewrite the above as:  
Assume $n$ is odd and $n+1$ is odd.  We know $n=2q+1$ for some $q\in\mathbb{Z}$, by proposition 6.15.  
We also know $n+1=2r+1$ for some $r\in\mathbb{Z}$. Subtracting $1$ on both sides, we obtain $n=2r$.  
By substitution, $2r=2q+1$, for some $r, q\in\mathbb{Z}$. This is unsatsifiable in the integers, so the assumption that $n$ is not even and $n+1$ is not even must be false by contradiction.   
Therefore, since $n$ is even and $n+1$ is even cannot both be false, $n$ is even or $n+1$ is even must be true.  
**QED.**  

## Proposition 6.25
If $a\equiv a' \text{ (mod } n \text{)}$ and $b\equiv b' \text{ (mod } n \text{)}$, then:  
$a+b\equiv a'+b'\text{ (mod } n \text{)} \text{ and } ab\equiv a'b' \text{ (mod } n \text{)}$  

**Proof.**  
By definition, $x\equiv y \text{ (mod } n \text{)} \iff x-y \text{ is divisible by n} \iff \exists q \in \mathbb{Z} \text{ where } x-y = qn$  
Let $n\in\mathbb{N}$ be a fixed modulus.  
$a\equiv a'\iff \exists q \in \mathbb{Z} \text{ where } a-a' = qn$, by definition of the relation  
$b\equiv b'\iff \exists r \in \mathbb{Z} \text{ where } b-b' = rn$, by definition of the relation  

Prove that $(a+b)-(a'+b')$ is divisible by $n$.  
Rearranging the terms:  
$(a+b)-(a'+b')=a+b-a'-b'=a-a'+b-b'$  
Substituting our definitions:  
$a-a'+b-b'=qn+rn=n(q+r)$, which is divisible by $n$.  

Now prove that $ab-a'b'$ is divisible by $n$.  
Add and subtract $a'b$:  
$ab-a'b+a'b-a'b'=b(a-a')+a'(b-b')$  
Substituting our definitions:  
$b(qn)+a'(rn)=n(bq+a'r)$, which is divisible by $n$.      

Therefore, $a+b\equiv a'+b'\text{ (mod } n \text{)} \text{ and } ab\equiv a'b' \text{ (mod } n \text{)}$.  

**QED.**  

## Project 6.9
On $\mathbb{Z} \times (\mathbb{Z} - \{0\})$ we define the relation $(x, y) \sim (z, w)$ if $xw = yz$.

(i) Show that this is an equivalence relation.

**Proof.**  
$xy=xy$, therefore the relation is **reflexive**.  
$xy=zw \implies zw=xy$, therefore the relation is **symmetric**.  
We now prove that $(x, y)\sim (z, w) \text{ and } (z, w) \sim (j, k) \implies (x, y)\sim (j, k)$.    
Rewritten, prove that $xw=yz$ and $zk=wj$ implies $xk=yj$.  
We know $y,w,k\neq0$.  
Multiplying the first equation by $k$:  
$xkw=yzk$  
Substituting the second equation:  
$xkw=ywj$  
We can cancel the $w$ on both sides, as $w\neq0$:  
$xk=yj$.  
Therefore, the relation is **transitive**.  
Since the relation is reflexive, symmetric, and transitive, then the relation is an equivalence relation.  
**QED.**  

(ii) For two equivalence classes $[(x, y)]$ and $[(z, w)]$, we define two binary operations $\oplus$ and $\odot$ via

$$[(x, y)] \oplus [(z, w)] = [(x w + z y, y w)]\text{ and }[(x, y)] \odot [(z, w)] = [(x z, y w)].$$

What properties do the binary operations $\oplus$ and $\odot$ have?

If you think about it, these operations look oddly familiar.. almost like the addition and multiplication operation on the *rationals*.  
Take this operation: $[(x, y)] \oplus [(z, w)] = [(x w + z y, y w)]$.  
This exactly resembles addition on fractions: $\frac{x}{y}+\frac{z}{w}=\frac{xw+zy}{yw}$.  
Same for the $\odot$ operation: $\frac{x}{y}\cdot\frac{z}{w}=\frac{xz}{yw}$. 
In fact, take a look at the equivalence relation in part $i$:   
$(x, y) \sim (z, w)$ if $xw = yz$  
What this is *really* saying is that two fractions $\frac{x}{y} \text{ and } \frac{z}{w}$ are equivalent if $xw=yz$. This makes sense intuitively — take the example $\frac{2}{4} \text{ and } \frac{5}{10}$. We know both of them reduce to $\frac{1}{2}$, but neither is in it's simplest form. The equivalence relation says these two fractions are equal because $2\cdot10=4\cdot5$. In other words, this relation formalizes the notion that fractions can have the same value, even with different numerators and denominators.  
Additionally, the definition of the set of ordered pairs from $\mathbb{Z} \times (\mathbb{Z} - \{0\})$ when interpreted in this way states that the **denominator can never be 0**, which fits into the definition of the rationals.  

Let $F=(Z×(Z−\{0\}))/\sim$, the set of equivalence classes $[(x,y)]$.  
The set $F$ is equipped with the binary operations $\oplus$ and $\odot$. The set $F$ contains every uniquely valued fraction — all the fractions that are not equivalent to themselves.  

- Both operations are associative commutative, and closed under the set $F$.  
**Proof.**  

- $\odot$ distributes over $\oplus$.  
- $\oplus$ has the identity element $[(0, 1)]$, or all fractions equivalent to $0$.  
- $\odot$ has the identity element $[(1, 1)]$, or all fractions equivalent to $\frac{1}{1}$
- For every $\frac{m}{n}\in F$, there is an additive inverse
- For every $\frac{m}{n}\in F$ where $m\neq 0$, there is a multiplicitive inverse

Looking at this structure, we can say the fields $(F, \oplus, \odot)$ and $(\mathbb{Q}, +, \times)$ are isomorphic. In other words, we have constructed $\mathbb{Q}$ from $\mathbb{Z}$.  

## Project 6.27
**Axiom 1.5 recap (cancellation)**: Let $m,p,q\in\mathbb{Z}$. If $m\cdot n = m\cdot p$ and $m\neq 0$, then $m=p$.  

Study for which $n$ the set $\mathbb{Z}_n$ satisfies the cancellation property (Axiom 1.5). Prove your assertions.  

Consider $\mathbb{Z}_6$:  
$2\cdot3 = 6 \equiv 0$  
$1\cdot6=6 \equiv 0$  
$3\neq0 \text{ in } \mathbb{Z}_6$  

Consider $\mathbb{Z}_7$:  
$1\cdot7 = 7 \equiv 0$  
$1\cdot0=7 \equiv 0$  
$7=0 \text{ in } \mathbb{Z}_7$  

**Conclusion:**  Cancellation is satisfiable where $n$ is prime.  

**Proof.**  

Suppose $n$ is not prime. Let $d$ be a non-trivial divisor of $n$.  
Since $d$ divides $n$, there exists $q\in\mathbb{Z}$ where $n=qd$.  
$d\cdot \frac{n}{d}\equiv 0$  
$d\cdot 0\equiv 0$  
Since $d$ is non-trivial, $\frac{n}{d}\neq0$, therefore the cancellation property is not satisfiable.  

Now suppose $n$ is prime, that is, it's only divisors are $1$ and $n$, and $n\neq1$.  
<!-- Since $n\equiv 0$ in $\mathbb{Z}_n$, $m\neq n$.   -->
We show for some $a,b,c\in\mathbb{Z}_n$, if $a\cdot b = a\cdot c$ and $a\neq 0$, then $b=c$  
Since $a,b,c\in\mathbb{Z}_n$, we rewrite the original statement as:  
$a\cdot b \equiv a\cdot c$ (mod n)  
By definition, this means $n$ divides $a(b-c)$. By Euclid's lemma, if $n$ divides $a(b-c)$, and $n$ is prime, then $n$ must divide either $a$ or $(b-c)$.  
If $n$ divides $a$, $n=a$, because $n\neq 1$. However, this would mean $a\equiv 0$, and we can assume this is false as $a\neq 0$ by the cancellation\axiom.  
If $n$ does not divide $a$, then by Euclid's lemma, $n$ must divide $(b-c)$. By definition, this means $b\equiv c$.  

**QED.**  


## Proposition 8.6  [rewritten]
$(\forall x,y\in\mathbb{R}-\{0\}) \text{ }\text{ } (xy)^{-1}=x^{-1}y^{-1}$  

**Proof.**  

We start with the true statement $1\cdot 1=1$.  

By proposition 8.5, $(x\cdot x^{-1})=(y\cdot y^{-1})=1$, therefore we can substitute for 1:  
$(x\cdot x^{-1})(y\cdot y^{-1})=1$  

By Axiom 8.1(iii, v), the commutativity and associativity of multiplication over real numbers, we can rearrange the terms as follows:  
- $((x\cdot x^{-1})\cdot y)\cdot y^{-1}=1$, by associativity  
- $(x\cdot (x^{-1}\cdot y))\cdot y^{-1}=1$, by associativity  
- $(x\cdot (y\cdot x^{-1}))\cdot y^{-1}=1$, by commutativity  
- $((x\cdot y)\cdot x^{-1})\cdot y^{-1}=1$, by associativity  
- $(xy)\cdot (x^{-1}y^{-1})=1$, by associativity  

By proposition 8.5, since $x,y\in\mathbb{R}-\{0\}$, $(xy)(xy)^{-1}=1$  

Now, we know $(xy)(x^{-1}y^{-1})=1$ and $(xy)(xy)^{-1}=1$.  To conclude the proof, we introduce and prove another proposition:  

### Proposition 8.7   
Let $x,y,z\in \mathbb{R}$ and $x\neq 0$. If $xy=xz$, then $y=z$.  

**Proof.**  

By Axiom 8.5, there exists an $x^{-1}$ such that $x\cdot x^{-1}=1$.  
Multiplying both sides by $x^{-1}$:  
- $x^{-1}(xy)=x^{-1}(xz)$  
- $(x^{-1}x)y=(x^{-1}x)z$, by associativity  
- $(1)y=(1)z$, by Axiom 8.5  
- $y=z$, by Axiom 8.3  

**QED.**  

Now, we have $(xy)(x^{-1}y^{-1})=1$ and $(xy)(xy)^{-1}=1$, so by transitivity $(xy)(x^{-1}y^{-1})=(xy)(xy)^{-1}$.  

By Proposition 8.7, $x^{-1}y^{-1}=(xy)^{-1}$.  

**QED.**  
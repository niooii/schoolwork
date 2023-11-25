/* Transition matrix:
   E    C    P
E 0.4  0.3  0.3
C 0.25 0.5  0.25
P 0.35 0.15 0.5

where E is exploration, 
C is combat, and
P is puzzle.

The most chosen quest appears to be assigned more often.
This allows for a varied but predictable quest experience, as there
isn't TOO low of a chance for another quest to be
assigned.

A certain weight/bias could be added to random assignment, perhaps
based off of the player's class or skillsets.

The following program raises the transition matrix to the
10th power, and prints the result of each
to stdout.

Built & ran on toolchain
nightly-x86_64-unknown-linux-gnu (default)
rustc 1.75.0-nightly (1c05d50c8 2023-10-21)

Crates:
glm
rand

*/ 

use glm::mat3;
use rand::Rng;

#[derive(Debug)]
enum Quest {
    Exploration = 0,
    Combat = 1,
    Puzzle = 2
}
fn main() {
    let mut rng = rand::thread_rng();

    let mut markov = mat3(
        0.4, 0.3, 0.3, // E
        0.25, 0.5, 0.25, // C
        0.35, 0.15, 0.5);// P
    //   E    C    P
    
    let original = markov;

    let mut current_quest = Quest::Exploration;

    for n in 0..10 {
        // random number out of 1
        let r = rng.gen_range(0_f32..1_f32);

        // chances of each quest
        let e: f32;
        let c: f32;
        let p: f32;

        // get probabilities of each
        let probabilities = {
            let v: glm::Vector3<f32> = match current_quest {
                Quest::Exploration => {
                    markov.c0
                },
                Quest::Combat => {
                    markov.c1
                },
                Quest::Puzzle => {
                    markov.c2
                }
            };
            e = v.x;
            c = v.y;
            p = v.z;
            format!("PROBABILITIES:\nexploration: {e}, combat: {c}, puzzle: {p}")
        };

        println!("{probabilities}");

        // update current quest state
        if r < e {
            current_quest = Quest::Exploration;
        } 
        else if e < r && r > e + c {
            current_quest = Quest::Combat;
        }
        else {
            current_quest = Quest::Puzzle;
        }

        println!("set quest to {current_quest:?}");

        // update markov matrix
        markov = markov.mul_m(&original);
    }
    
}

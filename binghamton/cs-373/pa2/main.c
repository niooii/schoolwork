#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int gate_idx(int from, char dir) {
  if (from > 2)
    return -1;

  if (from) {
    if (dir == 'L')
      return 3;
    else
      return 4;
  } else {
    if (dir == 'L')
      return 2;
    else
      return 3;
  }
}

void flip_gate(char* gates, int idx) {
    if (gates[idx] == 'L')
        gates[idx] = 'R';
    else
        gates[idx] = 'L';
}

int main(int argc, char **argv) {
  if (argc < 3)
    return 1;

  char *dirs = argv[1];
  char *in = argv[2];

  int dir_l = strlen(dirs);
  int in_l = strlen(in);

  for (int i = 0; i < in_l; i++) {
    int in_gate = (int)(in[i] - 48);

    int next = gate_idx(in_gate, dirs[in_gate]);

    // flip gate
    flip_gate(dirs, in_gate);
    flip_gate(dirs, next);

    if (i == in_l - 1) {
        char end;
        // flip back temporarily
        flip_gate(dirs, next);
        
        char dir = dirs[next];
        if (next == 2 && dir == 'L')
            end = 'C';
        else if ((next == 2 && dir == 'R') || (next == 3 && dir == 'L'))
            end = 'D';
        else if ((next == 3 && dir == 'R') || (next == 4 && dir == 'L'))
            end = 'E';
        else if (next == 4 && dir == 'R')
            end = 'F';

        flip_gate(dirs, next);
        printf("%s %c", dirs, end);
    } else {
        printf("%s->", dirs);
    }
  }

  printf("\n");

  return 0;
}

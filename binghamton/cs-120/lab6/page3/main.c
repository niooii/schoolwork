// HEWITT WANG LAB-06

#include <stdio.h>

enum OPERATION {
  OP_MULT,
  OP_AND,
  OP_OR
};

void print_bits(int n, int bits);
void table(int rows, int columns, int bits, enum OPERATION op);

int main(int argc, char** argv)
{
  table(8, 8, 3, OP_MULT);
  printf("\n");
  table(8, 8, 3, OP_AND); 
  printf("\n");
  table(8, 8, 3, OP_OR); 
}


void table(int rows, int columns, int bits, enum OPERATION op)
{
  for (unsigned int i = 1; i <= rows; i++)
  {
    for (unsigned int j = 1; j <= columns; j++)
    {
      unsigned int v = 0;
      switch (op)
      {
        case OP_MULT:
        {
          v = i * j;
          break;
        }
      case OP_AND:
        {
          v = i & j;
          break;
        }
      case OP_OR:
        {
          v = i | j;
          break;
        }
      }
      print_bits(v, bits);
      printf(" ");
    }
    printf("\n");
  }
}

void print_bits(int n, int bits)
{
    // 0110 & 0011   (0&0)(1&0)(1&1)(0&1) = 0010

    // 0110
    // 0011
    // ----
    // 0010

    for(int i = bits - 1; i >= 0; --i)
    {
        if(n & (1 << i))  // For example 0001 << 2 = 0100
        {
            printf("1");
        }
        else
        {
            printf("0");
        }
    }
}

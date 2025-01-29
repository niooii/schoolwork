#include <stdio.h>

static const int b = 582;

int main(int argc, char** argv)
{
  int max = 0;
  for (int a = 0; a < 100; a++)
  {
    int t = ((a << 2) | (b << 4) | ( a & b ) ) & 0xF351;
    if (t > max)
      max = t;
  }
  printf("max: %d\n", max);
  return 0;
}

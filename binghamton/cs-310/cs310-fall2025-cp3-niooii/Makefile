CXX = clang++
CXXFLAGS = -std=c++17 -O3 -pthread -Wall
TARGET = benchmark
SRC = benchmark.cpp

all: $(TARGET)

$(TARGET): $(SRC) sorts.h sorts.cpp sort_interface.h
	$(CXX) $(CXXFLAGS) $(SRC) -o $(TARGET)

run: $(TARGET)
	./$(TARGET)

clean:
	rm -f $(TARGET)

.PHONY: all run clean

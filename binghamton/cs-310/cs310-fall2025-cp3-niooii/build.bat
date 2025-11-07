@echo off
echo Building sorting benchmark...
clang++ -std=c++17 -O3 -ffast-math -DNDEBUG -pthread benchmark.cpp -o benchmark.exe
if %errorlevel% equ 0 (
    echo Build successful!
    echo Running benchmark...
    .\benchmark.exe
) else (
    echo Build failed!
)

#!/bin/bash

pandoc --toc $1 -f markdown -t pdf -o $1.pdf

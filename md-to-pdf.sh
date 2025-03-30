#!/bin/bash

pandoc --toc $1 -f md -t pdf -o $1.pdf

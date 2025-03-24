#!/bin/bash

pandoc --toc --standalone --mathjax $1 -t html -o $1.pdf

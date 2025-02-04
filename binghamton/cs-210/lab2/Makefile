.PHONY: all run clean

all: HelloWorld.class

HelloWorld.class: HelloWorld.java
	javac HelloWorld.java

run: all
	java HelloWorld

clean:
	rm -f *.class

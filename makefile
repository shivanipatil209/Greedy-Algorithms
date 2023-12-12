# javac *.java
JCFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
		$(JC) $(JCFLAGS) $*.java

CLASSES = *.java

default: clean classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class

run1:
		java STRAT1

run2:
		java STRAT2

run3:
		java STRAT3

run4:
		java STRAT4

run5:
		java STRAT4_optimal
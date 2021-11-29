all: flex bison
	gcc zad3.tab.c lex.yy.c utils.c -lm -o zad3

flex: 
	flex zad3.l

bison:
	bison -d zad3.y

clean:
	rm *.tab.* zad3 lex.yy.c